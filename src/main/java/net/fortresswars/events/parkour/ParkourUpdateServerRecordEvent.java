package net.fortresswars.events.parkour;

import net.fortresswars.core.parkour.ParkourServerRecord;
import net.fortresswars.events.FortressWarsEvent;

public class ParkourUpdateServerRecordEvent extends FortressWarsEvent {

    private final String courseID;
    private final ParkourServerRecord  record;

    public ParkourUpdateServerRecordEvent(String courseID, ParkourServerRecord record) {
        this.courseID = courseID;
        this.record = record;
    }

    public String getCourseID() {
        return courseID;
    }

    public ParkourServerRecord getRecord() {
        return record;
    }
}
