package ru.myitschool.lab23.controller.consumer;

import android.widget.EditText;

import ru.myitschool.lab23.model.MetricsData;
import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.NoMetricaDataException;

public class Handler implements IConsumer, IConverter {
    protected EditText editTextComponent;
    protected final double conversionFactor;
    protected final LengthType type;

    public Handler(EditText editTextComponent,
                   LengthType type) throws NoMetricaDataException {
        this.editTextComponent = editTextComponent;
        this.conversionFactor = MetricsData.getMetrica(type);
        this.type = type;
    }

    @Override
    public void consume(double value) {
        double thisValue = this.convertFromBase(value);
        this.editTextComponent.setText(String.valueOf(thisValue));
    }

    @Override
    public void consume(String text) {
        this.editTextComponent.setText(text);
    }

    @Override
    public LengthType getType() {
        return this.type;
    }

    @Override
    public double convertFromBase(double value) {
        return value * this.conversionFactor;

    }

    @Override
    public double convertToBase(double value) {
        return value / this.conversionFactor;
    }
}
