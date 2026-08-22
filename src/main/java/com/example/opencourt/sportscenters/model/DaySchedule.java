package com.example.opencourt.sportscenters.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DayScheduleDayOff.class, name = "Day off"),
        @JsonSubTypes.Type(value = DayScheduleWorkDay.class, name = "Workday"),
        @JsonSubTypes.Type(value = DayScheduleOpen24Hours.class, name = "Open 24 hours")
})
public sealed interface DaySchedule permits DayScheduleDayOff, DayScheduleWorkDay, DayScheduleOpen24Hours {
}
