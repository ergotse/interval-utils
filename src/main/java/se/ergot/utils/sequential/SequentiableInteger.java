package se.ergot.utils.sequential;

import lombok.NonNull;

public class SequentiableInteger implements Sequentiable<Integer> {

    private final Integer value;

    private SequentiableInteger(@NonNull Integer value) {
        this.value = value;
    }

    public static SequentiableInteger of(int value) {
        return new SequentiableInteger(value);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer getNext() {
        return value + 1;
    }

    @Override
    public Integer getPrevious() {
        return value - 1;
    }

    @Override
    public long getDistance(@NonNull Integer other) {
        return Math.abs(value - other);
    }

    @Override
    public int compareTo(Sequentiable<Integer> o) {
        return Integer.compare(value, o.getValue());
    }
}
