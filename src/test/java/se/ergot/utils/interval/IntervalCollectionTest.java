package se.ergot.utils.interval;

import org.junit.jupiter.api.Test;
import se.ergot.utils.sequential.SequentiableInteger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervalCollectionTest {

    @Test
    void testGetIntervalsWhenInteger() {
        final IntervalCollection<SequentiableInteger, Integer> collection = new IntervalCollection<>(List.of(
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
        final IntervalCollection<SequentiableInteger, Integer> collection = new IntervalCollection<>(List.of(
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

}