package se.ergot.utils.sequential;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@EqualsAndHashCode
public class SequentiableLocalDate implements Sequentiable<LocalDate> {

    private final LocalDate value;

    private SequentiableLocalDate(@NonNull LocalDate value) {
        this.value = value;
    }

    public static SequentiableLocalDate of(LocalDate value) {
        return new SequentiableLocalDate(value);
    }

    @Override
    public LocalDate getValue() {
        return value;
    }

    @Override
    public LocalDate getNext() {
        return value.plusDays(1);
    }

    @Override
    public LocalDate getPrevious() {
        return value.minusDays(1);
    }

    @Override
    public long getDistance(@NonNull LocalDate other) {
        return Math.abs(ChronoUnit.DAYS.between(value, other));
    }

    @Override
    public int compareTo(Sequentiable<LocalDate> o) {
        return value.compareTo(o.getValue());
    }
}
