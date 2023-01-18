package ru.myitschool.lab23.model;

public class MetricsData {
    private static final double FACTOR_INCHES = 39.3701;
    private static final double FACTOR_YARDS = 1.09361;
    private static final double FACTOR_FEET = 3.28084;
    private static final double FACTOR_MILES = 0.000621371;

    private static final double FACTOR_YOTTAMETRES = Math.pow(10, -24);
    private static final double FACTOR_ZETTAMETRES = Math.pow(10, -21);
    private static final double FACTOR_EXAMETRES = Math.pow(10, -18);
    private static final double FACTOR_PETAMETRES = Math.pow(10, -15);
    private static final double FACTOR_TERAMETRES = Math.pow(10, -12);
    private static final double FACTOR_GIGAMETRES = Math.pow(10, -9);
    private static final double FACTOR_MEGAMETRES = Math.pow(10, -6);
    private static final double FACTOR_KILOMETRES = Math.pow(10, -3);
    private static final double FACTOR_HECTOMETRES = Math.pow(10, -2);
    private static final double FACTOR_DECAMETRES = Math.pow(10, -1);
    private static final double FACTOR_METRES = Math.pow(10, 0);
    private static final double FACTOR_DECIMETRES = Math.pow(10, 1);
    private static final double FACTOR_CENTIMETRES = Math.pow(10, 2);
    private static final double FACTOR_MILLIMETRES = Math.pow(10, 3);
    private static final double FACTOR_MICROMETRES = Math.pow(10, 6);
    private static final double FACTOR_NANOMETRES = Math.pow(10, 9);
    private static final double FACTOR_PICOMETRES = Math.pow(10, 12);
    private static final double FACTOR_FEMTOMETRES = Math.pow(10, 15);
    private static final double FACTOR_ATTOMETRES = Math.pow(10, 18);
    private static final double FACTOR_ZEPTOMETRES = Math.pow(10, 21);
    private static final double FACTOR_YOCTOMETRES = Math.pow(10, 24);


    public static double getMetrica(LengthType type) throws NoMetricaDataException {
        switch (type) {
            case INCHES: return FACTOR_INCHES;
            case YARDS: return FACTOR_YARDS;
            case FEET: return FACTOR_FEET;
            case MILES: return FACTOR_MILES;
            case YOTTAMETRES: return FACTOR_YOTTAMETRES;
            case ZETTAMETRES: return FACTOR_ZETTAMETRES;
            case EXAMETRES: return FACTOR_EXAMETRES;
            case PETAMETRES: return FACTOR_PETAMETRES;
            case TERAMETRES: return FACTOR_TERAMETRES;
            case GIGAMETRES: return FACTOR_GIGAMETRES;
            case MEGAMETRES: return FACTOR_MEGAMETRES;
            case KILOMETRES: return FACTOR_KILOMETRES;
            case HECTOMETRES: return FACTOR_HECTOMETRES;
            case DECAMETRES: return FACTOR_DECAMETRES;
            case METRES: return FACTOR_METRES;
            case DECIMETRES: return FACTOR_DECIMETRES;
            case CENTIMETRES: return FACTOR_CENTIMETRES;
            case MILLIMETRES: return FACTOR_MILLIMETRES;
            case MICROMETRES: return FACTOR_MICROMETRES;
            case NANOMETRES: return FACTOR_NANOMETRES;
            case PICOMETRES: return FACTOR_PICOMETRES;
            case FEMTOMETRES: return FACTOR_FEMTOMETRES;
            case ATTOMETRES: return FACTOR_ATTOMETRES;
            case ZEPTOMETRES: return FACTOR_ZEPTOMETRES;
            case YOCTOMETRES: return FACTOR_YOCTOMETRES;
            default: throw new NoMetricaDataException();
        }
    }
}
