package net.fortresswars.core.statistics;

public class RatioMultiStat implements MultiStat {

    private final double calculatedValue;

    public RatioMultiStat(double topValue, double bottomValue) {
        if (bottomValue == 0) bottomValue = 1;
        calculatedValue = topValue / bottomValue;
    }

    @Override
    public double getCalculatedValue() {
        return calculatedValue;
    }
}
