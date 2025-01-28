package se.ergot.utils.interval;

import se.ergot.utils.sequential.Sequentiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IntervalCollection<T extends Sequentiable<U>, U extends Comparable<U>> {

    private final List<T> items;

    public IntervalCollection(Collection<T> items) {
        this.items = items != null ? items.stream().distinct().sorted().toList() : Collections.emptyList();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public U getFrom() {
        return items.isEmpty() ? null : items.get(0).getValue();
    }

    public U getTo() {
        return items.isEmpty() ? null : items.get(items.size() - 1).getValue();
    }

    public List<Interval<T, U>> getIntervals() {
        final List<Interval<T, U>> list = new ArrayList<>();
        T start = null;
        T prev = null;
        int i = 0;
        for (T item : items) {
            if (prev == null) {
                start = item;
                prev = item;
            }

            final long diff = prev.getDistance(item.getValue());
            if (diff > 1 && i == items.size() - 1) {
                list.add(new Interval<>(start, prev));
                list.add(new Interval<>(item, item));
            } else if (i == items.size() - 1) {
                list.add(new Interval<>(start, item));
            } else if (diff > 1) {
                list.add(new Interval<>(start, prev));
                start = item;
            }

            prev = item;
            i++;
        }
        return list;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else if (getFrom().equals(getTo())) {
            return getFrom().toString();
        }
        return getFrom() + "-" + getTo();
    }

}
