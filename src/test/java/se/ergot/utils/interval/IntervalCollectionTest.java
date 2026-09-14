package se.ergot.utils.interval;

import org.junit.jupiter.api.Test;
import se.ergot.utils.sequential.SequentiableInteger;
import se.ergot.utils.sequential.SequentiableLocalDate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntervalCollectionTest {

    @Test
    void testOf_nullItems() {
        // A null collection must be rejected explicitly rather than silently treated as empty.
        assertThrows(NullPointerException.class, () -> IntervalCollection.of(null));
    }

    @Test
    void testGetIntervalsWhenInteger() {
        final IntervalCollection<SequentiableInteger, Integer> collection = IntervalCollection.of(List.of(
                SequentiableInteger.of(2024),
                SequentiableInteger.of(2021), SequentiableInteger.of(2020),
                SequentiableInteger.of(2018), SequentiableInteger.of(2016), SequentiableInteger.of(2017)
        ));

        final List<Interval<SequentiableInteger>> intervals = collection.getIntervals();
        assertEquals(3, intervals.size());
        assertEquals(2016, intervals.get(0).getStart().getValue());
        assertEquals(2018, intervals.get(0).getEnd().getValue());
        assertEquals(2020, intervals.get(1).getStart().getValue());
        assertEquals(2021, intervals.get(1).getEnd().getValue());
        assertEquals(2024, intervals.get(2).getStart().getValue());
        assertEquals(2024, intervals.get(2).getEnd().getValue());
    }

    @Test
    void testGetIntervalsWhenInteger_duplicateValues() {
        final IntervalCollection<SequentiableInteger, Integer> collection = IntervalCollection.of(List.of(
                SequentiableInteger.of(2024),
                SequentiableInteger.of(2021), SequentiableInteger.of(2020), SequentiableInteger.of(2016),
                SequentiableInteger.of(2018), SequentiableInteger.of(2016), SequentiableInteger.of(2017)
        ));
        final List<Interval<SequentiableInteger>> intervals = collection.getIntervals();
        assertEquals(3, intervals.size());
        assertEquals(2016, intervals.get(0).getStart().getValue());
        assertEquals(2018, intervals.get(0).getEnd().getValue());
        assertEquals(2020, intervals.get(1).getStart().getValue());
        assertEquals(2021, intervals.get(1).getEnd().getValue());
        assertEquals(2024, intervals.get(2).getStart().getValue());
        assertEquals(2024, intervals.get(2).getEnd().getValue());
    }

    @Test
    void testGetIntervalsWhenLocalDate() {
        final IntervalCollection<SequentiableLocalDate, LocalDate> collection = IntervalCollection.of(List.of(
                SequentiableLocalDate.of(LocalDate.of(2024, 1, 1)), SequentiableLocalDate.of(LocalDate.of(2024, 1, 2)),
                SequentiableLocalDate.of(LocalDate.of(2024, 1, 3)), SequentiableLocalDate.of(LocalDate.of(2024, 1, 10))
        ));

        final List<Interval<SequentiableLocalDate>> intervals = collection.getIntervals();
        assertEquals(2, intervals.size());
        assertEquals(LocalDate.of(2024, 1, 1), intervals.get(0).getStart().getValue());
        assertEquals(LocalDate.of(2024, 1, 3), intervals.get(0).getEnd().getValue());
        assertEquals(LocalDate.of(2024, 1, 10), intervals.get(1).getStart().getValue());
        assertEquals(LocalDate.of(2024, 1, 10), intervals.get(1).getEnd().getValue());
    }

}