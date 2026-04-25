package net.fortresswars.core;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ParkourProfile (
        UUID uuid,
        Date date,
        List<ParkourInfo> courses
) {

}
