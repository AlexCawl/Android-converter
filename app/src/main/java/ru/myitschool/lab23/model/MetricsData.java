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

    private static final double MAX_INCHES = Math.pow(10, 15);
    private static final double MAX_YARDS = Math.pow(10, 14);
    private static final double MAX_FEET = Math.pow(10, 14);
    private static final double MAX_MILES = Math.pow(10, 10);
    private static final double MAX_YOTTAMETRES = Math.pow(10, 3);
    private static final double MAX_ZETTAMETRES = Math.pow(10, 4);
    private static final double MAX_EXAMETRES = Math.pow(10, 5);
    private static final double MAX_PETAMETRES = Math.pow(10, 6);
    private static final double MAX_TERAMETRES = Math.pow(10, 7);
    private static final double MAX_GIGAMETRES = Math.pow(10, 8);
    private static final double MAX_MEGAMETRES = Math.pow(10, 9);
    private static final double MAX_KILOMETRES = Math.pow(10, 10);
    private static final double MAX_HECTOMETRES = Math.pow(10, 11);
    private static final double MAX_DECAMETRES = Math.pow(10, 12);
    private static final double MAX_METRES = Math.pow(10, 13);
    private static final double MAX_DECIMETRES = Math.pow(10, 14);
    private static final double MAX_CENTIMETRES = Math.pow(10, 15);
    private static final double MAX_MILLIMETRES = Math.pow(10, 16);
    private static final double MAX_MICROMETRES = Math.pow(10, 17);
    private static final double MAX_NANOMETRES = Math.pow(10, 18);
    private static final double MAX_PICOMETRES = Math.pow(10, 19);
    private static final double MAX_FEMTOMETRES = Math.pow(10, 20);
    private static final double MAX_ATTOMETRES = Math.pow(10, 21);
    private static final double MAX_ZEPTOMETRES = Math.pow(10, 22);
    private static final double MAX_YOCTOMETRES = Math.pow(10, 23);


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

    public static double getMaxValues(LengthType type) throws NoMetricaDataException {
        switch (type) {
            case INCHES: return MAX_INCHES;
            case YARDS: return MAX_YARDS;
            case FEET: return MAX_FEET;
            case MILES: return MAX_MILES;
            case YOTTAMETRES: return MAX_YOTTAMETRES;
            case ZETTAMETRES: return MAX_ZETTAMETRES;
            case EXAMETRES: return MAX_EXAMETRES;
            case PETAMETRES: return MAX_PETAMETRES;
            case TERAMETRES: return MAX_TERAMETRES;
            case GIGAMETRES: return MAX_GIGAMETRES;
            case MEGAMETRES: return MAX_MEGAMETRES;
            case KILOMETRES: return MAX_KILOMETRES;
            case HECTOMETRES: return MAX_HECTOMETRES;
            case DECAMETRES: return MAX_DECAMETRES;
            case METRES: return MAX_METRES;
            case DECIMETRES: return MAX_DECIMETRES;
            case CENTIMETRES: return MAX_CENTIMETRES;
            case MILLIMETRES: return MAX_MILLIMETRES;
            case MICROMETRES: return MAX_MICROMETRES;
            case NANOMETRES: return MAX_NANOMETRES;
            case PICOMETRES: return MAX_PICOMETRES;
            case FEMTOMETRES: return MAX_FEMTOMETRES;
            case ATTOMETRES: return MAX_ATTOMETRES;
            case ZEPTOMETRES: return MAX_ZEPTOMETRES;
            case YOCTOMETRES: return MAX_YOCTOMETRES;
            default: throw new NoMetricaDataException();
        }
    }
}
