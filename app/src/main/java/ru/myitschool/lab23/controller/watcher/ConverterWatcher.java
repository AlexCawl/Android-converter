package ru.myitschool.lab23.controller.watcher;

import android.text.Editable;
import android.text.TextWatcher;

import ru.myitschool.lab23.controller.locker.ILocker;
import ru.myitschool.lab23.controller.producer.IProducer;
import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.MetricsData;
import ru.myitschool.lab23.model.NoHandlerException;
import ru.myitschool.lab23.model.NoMetricaDataException;
import ru.myitschool.lab23.model.TooMuchValueException;

public class ConverterWatcher implements TextWatcher {
    private final IProducer producer;
    private final ILocker lock;
    private final LengthType type;
    private final double MAX_VALUE_LIMIT;

    public ConverterWatcher(IProducer producer, ILocker lock, LengthType type) throws NoMetricaDataException {
        this.producer = producer;
        this.lock = lock;
        this.type = type;
        this.MAX_VALUE_LIMIT = MetricsData.getMaxValues(type);
    }

    public LengthType getType() {
        return this.type;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (lock.isUnlocked()) {
            try {
                double value = validate(editable.toString());
                producer.sendUpdateRequest(getType(), value);
            } catch (NoHandlerException exception) {
                System.out.println("WARN | No handler exception | " + getType().name());
            } catch (NumberFormatException exception) {
                producer.sendUpdateRequest("");
            } catch (TooMuchValueException e) {
                producer.sendUpdateRequest("Too much value!");
            }
        }
    }

    private double validate(String value) throws TooMuchValueException, NumberFormatException {
        double val = Double.parseDouble(value);
        if (val > this.MAX_VALUE_LIMIT) {
            throw new TooMuchValueException();
        }
        return val;
    }
}
