package ru.myitschool.lab23.controller.consumer;

import ru.myitschool.lab23.model.LengthType;

public interface IConsumer {
    void consume(double value);
    void consume(String text);
    LengthType getType();
}
