package com.example.opencourt.sportscenters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record TimeRange(
        @NotNull(message = "Время начала интервала обязательно")
        @JsonFormat(pattern = "HH:mm")
        LocalTime startTime,

        @NotNull(message = "Время конца интервала обязательно")
        @JsonFormat(pattern = "HH:mm")
        LocalTime endTime
) implements Comparable<TimeRange> {

    @AssertTrue(message = "startTime должен быть раньше, чем endTime")
    @JsonIgnore
    private boolean isValid() {
        // В случае, если isValid() вызвался раньше проверки на Null, лучше вернуть true, чтоб не путать ошибку
        // с заполнением Null, с ошибкой "начало интервала должно быть раньше конца"
        if (startTime == null || endTime == null) {
            return true;
        }
        return startTime.isBefore(endTime);
    }

    @Override
    public int compareTo(TimeRange range) {
        if (startTime.compareTo(range.startTime) == 0) {
            return endTime.compareTo(range.endTime);
        }
        return startTime.compareTo(range.startTime);
    }
}
