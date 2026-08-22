package com.example.opencourt.sportscenters.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class DayScheduleWorkDay implements DaySchedule {

    @NotEmpty(message = "Time ranges should not be null or empty")
    private final List<@Valid @NotNull(message = "Time range should not be null") TimeRange> ranges;

    public DayScheduleWorkDay(List<TimeRange> ranges) {
        if (ranges == null) {
            this.ranges = null;
        } else {
            this.ranges = new ArrayList<>(ranges);
        }
    }

    public List<TimeRange> getRanges() {
        return List.copyOf(ranges);
    }
}
