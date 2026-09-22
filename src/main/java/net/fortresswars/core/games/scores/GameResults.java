package net.fortresswars.core.games.scores;

import com.google.gson.JsonObject;
import net.fortresswars.core.entities.StatisticsContainer;
import net.fortresswars.core.games.states.EndReason;

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
        Set<StatisticsContainer> statisticsPacks
) {

}
