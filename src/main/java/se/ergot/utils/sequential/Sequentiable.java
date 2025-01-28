package se.ergot.utils.sequential;

import lombok.NonNull;

public interface Sequentiable<T extends Comparable<? super T>> extends Comparable<Sequentiable<T>> {

    T getValue();

    T getNext();

    T getPrevious();

    long getDistance(@NonNull T other);

    boolean isLesserThan(@NonNull T other);

    static <T extends Sequentiable<U>, U extends Comparable<? super U>> T of(U value) {
        throw new UnsupportedOperationException("Method must be implemented by specific Sequentiable type");
    }

    @Override
    default int compareTo(Sequentiable<T> o) {
        return getValue().compareTo(o.getValue());
    }
}
