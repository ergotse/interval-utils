package se.ergot.utils.sequential;

public interface Sequentiable<T> extends Comparable<Sequentiable<T>> {

    T getValue();

    T getNext();

    T getPrevious();

    long getDistance(T other);

    int compareTo(Sequentiable<T> o);
}
