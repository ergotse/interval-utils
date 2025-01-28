package se.ergot.utils.sequential;

import lombok.NonNull;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class SequentiableDate implements Sequentiable<LocalDate> {

    private final LocalDate date;

    private SequentiableDate(@NonNull LocalDate date) {
        this.date = date;
    }

    public static SequentiableDate of(@NonNull LocalDate date) {
        return new SequentiableDate(date);
    }

    @Override
    public LocalDate getValue() {
        return date;
    }

    @Override
    public LocalDate getNext() {
        return date.plusDays(1);
    }

    @Override
    public LocalDate getPrevious() {
        return date.minusDays(1);
    }

    @Override
    public long getDistance(@NonNull LocalDate other) {
        return Math.abs(DAYS.between(date, other));
    }

    @Override
    public boolean isLesserThan(@NonNull LocalDate other) {
        return date.isBefore(other);
    }

}
