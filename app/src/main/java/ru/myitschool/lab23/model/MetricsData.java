package ru.myitschool.lab23.model;

import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.NoMetricaDataException;

public class MetricsData {
    private static final double FACTOR_METRE = 1.1;
    private static final double FACTOR_MILE = 2.6;
    private static final double FACTOR_FEET = 2.6;

    public static double getMetrica(LengthType type) throws NoMetricaDataException {
        switch (type) {
            case MILE: return FACTOR_MILE;
            case FEET: return FACTOR_FEET;
            case METRE: return FACTOR_METRE;
            default: throw new NoMetricaDataException();
        }
    }
}
