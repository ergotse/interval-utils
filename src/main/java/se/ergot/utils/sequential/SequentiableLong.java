package se.ergot.utils.sequential;

public class SequentiableLong implements Sequentiable<Long> {

    private final Long value;

    private SequentiableLong(Long value) {
        if (value == null) throw new NullPointerException();
        this.value = value;
    }

    public static SequentiableLong of(long value) {
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
    public long getDistance(Long other) {
        return Math.abs(value - other);
    }

    @Override
    public int compareTo(Sequentiable<Long> o) {
        return Long.compare(value, o.getValue());
    }
}
