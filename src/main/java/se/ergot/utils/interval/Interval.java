package se.ergot.utils.interval;

import lombok.Getter;
import lombok.NonNull;
import se.ergot.utils.sequential.Sequentiable;

import java.lang.reflect.Method;

@Getter
public class Interval<T extends Sequentiable<U>, U extends Comparable<? super U>> {

    private final T start;

    private final T end;

    public Interval(@NonNull T start, @NonNull T end) {
        if (start.isLesserThan(end.getValue())) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    public Interval(@NonNull U start, @NonNull U end, Class<T> clazz) {
        this.start = createInstance(start, clazz);
        this.end = createInstance(end, clazz);
    }

    public U getStartValue() {
        return start.getValue();
    }

    public U getEndValue() {
        return end.getValue();
    }

    @Override
    public String toString() {
        if (start.getValue().equals(end.getValue())) {
            return start.getValue().toString();
        }
        return start.getValue() + "-" + end.getValue();
    }

    @SuppressWarnings("unchecked")
    private T createInstance(U value, Class<T> clazz) {
        try {
            final Method ofMethod = clazz.getMethod("of", value.getClass());
            return (T) ofMethod.invoke(null, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of T using value: " + value, e);
        }
    }

}
