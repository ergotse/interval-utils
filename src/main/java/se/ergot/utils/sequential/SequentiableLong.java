package se.ergot.utils.sequential;

import lombok.NonNull;

public class SequentiableLong implements Sequentiable<Long> {

    private final Long value;

    private SequentiableLong(@NonNull Long value) {
        this.value = value;
    }

    public static SequentiableLong of(@NonNull Long value) {
        return new SequentiableLong(value);
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public Long getNext() {
        return value + 1;
    }

    @Override
    public Long getPrevious() {
        return value - 1;
    }

    @Override
    public long getDistance(@NonNull Long other) {
        return Math.abs(value - other);
    }

    @Override
    public boolean isLesserThan(@NonNull Long other) {
        return value < other;
    }
}
