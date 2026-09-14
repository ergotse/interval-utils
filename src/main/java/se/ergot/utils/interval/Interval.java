package se.ergot.utils.interval;

import lombok.Getter;
import lombok.NonNull;
import se.ergot.utils.sequential.Sequentiable;

@Getter
public class Interval<T extends Sequentiable<?>> {

    private final T start;

    private final T end;

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Interval(@NonNull T start, @NonNull T end) {
        if (((Sequentiable) start).compareTo(end) < 0) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public static <T extends Sequentiable<?>> Interval<T> of(@NonNull T start, @NonNull T end) {
        return new Interval<>(start, end);
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
