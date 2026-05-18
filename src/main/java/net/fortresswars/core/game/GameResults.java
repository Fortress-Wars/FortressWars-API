package net.fortresswars.core.game;

import com.google.gson.JsonObject;
import net.fortresswars.core.statistics.StatisticsPack;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record GameResults(
        UUID gameID,
        String mapID,
        String gameruleID,
        JsonObject score,
        Date startDate,
        Date endDate,
        EndReason endReason,
        Set<StatisticsPack> statisticsPacks
) {

}
