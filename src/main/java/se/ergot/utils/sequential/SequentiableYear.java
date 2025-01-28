package se.ergot.utils.sequential;

import lombok.NonNull;

import java.time.Year;

public class SequentiableYear implements Sequentiable<Year> {

    private final Year year;

    private SequentiableYear(Year year) {
        this.year = year;
    }

    public static SequentiableYear of(Year year) {
        return new SequentiableYear(year);
    }

    @Override
    public Year getValue() {
        return year;
    }

    @Override
    public Year getNext() {
        return year.plusYears(1);
    }

    @Override
    public Year getPrevious() {
        return year.minusYears(1);
    }

    @Override
    public long getDistance(@NonNull Year other) {
        return Math.abs(year.getValue() - other.getValue());
    }

    @Override
    public boolean isLesserThan(@NonNull Year other) {
        return year.isBefore(other);
    }
}
