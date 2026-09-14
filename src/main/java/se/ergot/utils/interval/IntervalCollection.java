package se.ergot.utils.interval;

import lombok.NonNull;
import se.ergot.utils.sequential.Sequentiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IntervalCollection<T extends Sequentiable<U>, U> {

    private final List<T> items;

    private IntervalCollection(@NonNull Collection<T> items) {
        this.items = items.stream().distinct().sorted().toList();
    }

    public static <T extends Sequentiable<U>, U> IntervalCollection<T, U> of(@NonNull Collection<T> items) {
        return new IntervalCollection<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<Interval<T>> getIntervals() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        final List<Interval<T>> list = new ArrayList<>();
        T start = items.get(0);
        T prev = items.get(0);
        for (int i = 0; i < items.size(); i++) {
            final T item = items.get(i);
            if (i > 0) {
                prev = items.get(i - 1);
            }
            final long diff = prev.getDistance(item.getValue());
            if (diff > 1 && i == items.size() - 1) {
                list.add(Interval.of(start, prev));
                list.add(Interval.of(item, item));
            } else if (i == items.size() - 1) {
                list.add(Interval.of(start, item));
            } else if (diff > 1) {
                list.add(Interval.of(start, prev));
                start = item;
            }
        }

        return list;
    }
}
