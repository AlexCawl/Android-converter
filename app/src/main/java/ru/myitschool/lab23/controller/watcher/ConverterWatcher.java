package ru.myitschool.lab23.controller.watcher;

import android.text.Editable;
import android.text.TextWatcher;

import ru.myitschool.lab23.controller.locker.ILocker;
import ru.myitschool.lab23.controller.producer.IProducer;
import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.NoHandlerException;

public class ConverterWatcher implements TextWatcher {
    private final IProducer producer;
    private final ILocker lock;
    private final LengthType type;

    public ConverterWatcher(IProducer producer, ILocker lock, LengthType type) {
        this.producer = producer;
        this.lock = lock;
        this.type = type;
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
                double value = Double.parseDouble(editable.toString());
                producer.sendUpdateRequest(getType(), value);
            } catch (NoHandlerException exception) {
                System.out.println("WARN | No handler exception | " + getType().name());
            } catch (NumberFormatException exception) {
                producer.sendUpdateRequest("");
            }
        }
    }
}
