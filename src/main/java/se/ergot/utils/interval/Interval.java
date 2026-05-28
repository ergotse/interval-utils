package se.ergot.utils.interval;

import se.ergot.utils.sequential.Sequentiable;

public class Interval<T extends Sequentiable<?>> {

    private final T start;

    private final T end;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Interval(T start, T end) {
        if (start == null || end == null) throw new NullPointerException();
        if (((Sequentiable) start).compareTo(end) < 0) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public T getStart() {
        return start;
    }

    public T getEnd() {
        return end;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public String toString() {
        if (((Sequentiable) start).compareTo(end) == 0) {
            return "" + start.getValue();
        }
        return start.getValue() + "-" + end.getValue();
    }
}
