package ru.myitschool.lab23.controller.producer;

import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.NoHandlerException;

public interface IProducer {
    void sendUpdateRequest(LengthType typeFrom, double value) throws NoHandlerException;
    void sendUpdateRequest(String text);
}
