package se.ergot.utils.sequential;

import lombok.NonNull;

import java.time.Year;

public class SequentiableYear implements Sequentiable<Year> {

    private final Year value;

    private SequentiableYear(@NonNull Year value) {
        this.value = value;
    }

    public static SequentiableYear of(Year value) {
        return new SequentiableYear(value);
    }

    @Override
    public Year getValue() {
        return value;
    }

    @Override
    public Year getNext() {
        return value.plusYears(1);
    }

    @Override
    public Year getPrevious() {
        return value.minusYears(1);
    }

    @Override
    public long getDistance(@NonNull Year other) {
        return Math.abs(value.getValue() - other.getValue());
    }

    @Override
    public int compareTo(Sequentiable<Year> o) {
        return Integer.compare(value.getValue(), o.getValue().getValue());
    }
}
