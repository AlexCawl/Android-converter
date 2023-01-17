package ru.myitschool.lab23.controller.consumer;

public interface IConverter {
    /**
     * @param value в base размерности
     * @return double в this размерности
     * */
    double convertFromBase(double value);

    /**
     * @param value в this размерности
     * @return double в base размерности
     * */
    double convertToBase(double value);
}
