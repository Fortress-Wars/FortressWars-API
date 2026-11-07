package net.fortresswars.core.statistics;

public class WinRateMultiStat implements MultiStat {

    private final double calculatedValue;

    public WinRateMultiStat(double winValue, double drawValue, double lossValue) {
        double winRate = 0;
        if (winValue > 0 || drawValue > 0 || lossValue > 0) {
            winRate = winValue / (winValue + drawValue + lossValue);
            winRate = winRate * 100;
            winRate = Math.round(winRate);
        }
        this.calculatedValue = winRate;
    }

    @Override
    public double getCalculatedValue() {
        return calculatedValue;
    }
}
