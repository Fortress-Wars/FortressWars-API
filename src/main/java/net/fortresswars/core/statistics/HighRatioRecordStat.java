package net.fortresswars.core.statistics;

import net.fortresswars.core.entities.FortressWarsPlayer;

import java.util.List;

public class HighRatioRecordStat extends HighRecordStat {

    private final FWStat numerator;
    private final FWStat denominator;

    public HighRatioRecordStat(List<FortressWarsPlayer> players, FWStat numerator, FWStat denominator, boolean includeZero) {
        super(players, numerator, includeZero);
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    protected double fetchRecordValue(FortressWarsPlayer player) {
        return player.getRatioStatistic(numerator, denominator);
    }
}
