package se.ergot.utils.sequential;

import lombok.NonNull;

public interface Sequentiable<T> extends Comparable<Sequentiable<T>> {

    T getValue();

    T getNext();

    T getPrevious();

    long getDistance(@NonNull T other);

    int compareTo(Sequentiable<T> o);
}
