package net.fortresswars.core.statistics;

import java.util.HashMap;

public interface StatisticsContainer {

    /**
     * @param statistic the statistic type to set a value to
     * @param value of the specified statistic to set
     */
    void setStatistic(FWStat statistic, double value);

    /**
     * @param statistic type to add a value to
     * @param value of the specified statistic to add
     * @return new value of the specified statistic
     */
    double addStatistic(FWStat statistic, double value);


    /**
     * @param statistic the statistic to get.
     * @return the value of the specified statistic.
     */
    double getStatistic(FWStat statistic);

    /**
     * Get a ratio statistic
     * @param numerator the numerator statistic type of the ratio
     * @param denominator the denominator statistic type of the ratio
     * @return the numerator / denominator or numerator is the denominator is 0
     */
    double getRatioStatistic(FWStat numerator, FWStat denominator);

    /**
     * @return the entire hashMap
     */
    HashMap<FWStat, Double> getAllStatistics();

}
