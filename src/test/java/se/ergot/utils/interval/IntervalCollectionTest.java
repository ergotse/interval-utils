package se.ergot.utils.interval;

import org.junit.jupiter.api.Test;
import se.ergot.utils.sequential.SequentiableYear;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervalCollectionTest {

    @Test
    void testGetYearIntervals() {
        final IntervalCollection<SequentiableYear, Year> collection = new IntervalCollection<>(List.of(
                SequentiableYear.of(Year.of(2024)),
                SequentiableYear.of(Year.of(2021)), SequentiableYear.of(Year.of(2020)),
                SequentiableYear.of(Year.of(2018)), SequentiableYear.of(Year.of(2016)), SequentiableYear.of(Year.of(2017))
        ));
        assertEquals(Year.of(2016), collection.getFrom());
        assertEquals(Year.of(2024), collection.getTo());
        final List<Interval<SequentiableYear, Year>> intervals = collection.getIntervals();
        assertEquals(3, intervals.size());
        assertEquals(Year.of(2016), intervals.get(0).getStartValue());
        assertEquals(Year.of(2018), intervals.get(0).getEndValue());
        assertEquals(Year.of(2020), intervals.get(1).getStartValue());
        assertEquals(Year.of(2021), intervals.get(1).getEndValue());
        assertEquals(Year.of(2024), intervals.get(2).getStartValue());
        assertEquals(Year.of(2024), intervals.get(2).getEndValue());
    }
/*
    @Test
    void testGetYearIntervals() {
        final IntervalCollection<SequentiableYear, Year> collection = new IntervalCollection<>(List.of(
                Year.of(2024),
                Year.of(2021), Year.of(2020),
                Year.of(2018), Year.of(2016), Year.of(2017)
        ));
        assertEquals(Year.of(2016), collection.getFrom());
        assertEquals(Year.of(2024), collection.getTo());
        final List<Interval<SequentiableYear,  Year>> intervals = collection.getIntervals();
        assertEquals(3, intervals.size());
        assertEquals(Year.of(2016), intervals.get(0).getStart());
        assertEquals(Year.of(2018), intervals.get(0).getEnd());
        assertEquals(Year.of(2020), intervals.get(1).getStart());
        assertEquals(Year.of(2021), intervals.get(1).getEnd());
        assertEquals(Year.of(2024), intervals.get(2).getStart());
        assertEquals(Year.of(2024), intervals.get(2).getEnd());
    }

    @Test
    void testGetLocalLongIntervals() {
        final IntervalCollection<SequentiableLong,  Long> collection = new IntervalCollection<>(List.of(
                2024L,
                2021L, 2020L,
                2018L, 2016L, 2017L
        ));
        assertEquals(2016L, collection.getFrom());
        assertEquals(2024L, collection.getTo());
        final List<Interval<SequentiableLong,  Long>> intervals = collection.getIntervals();
        assertEquals(3, intervals.size());
        assertEquals(2016L, intervals.get(0).getStart());
        assertEquals(2018L, intervals.get(0).getEnd());
        assertEquals(2020L, intervals.get(1).getStart());
        assertEquals(2021L, intervals.get(1).getEnd());
        assertEquals(2024L, intervals.get(2).getStart());
        assertEquals(2024L, intervals.get(2).getEnd());
    }

    @Test
    void testGetLocalIntegerIntervals() {
        final IntervalCollection<SequentiableInteger, Integer> collection = new IntervalCollection<>(List.of(
                2024,
                2021, 2020,
                2018, 2016, 2017
        ));
        assertEquals(2016, collection.getFrom());
        assertEquals(2024, collection.getTo());
        final List<Interval<SequentiableInteger,  Integer>> intervals = collection.getIntervals();
        assertEquals(3, intervals.size());
        assertEquals(2016, intervals.get(0).getStart());
        assertEquals(2018, intervals.get(0).getEnd());
        assertEquals(2020, intervals.get(1).getStart());
        assertEquals(2021, intervals.get(1).getEnd());
        assertEquals(2024, intervals.get(2).getStart());
        assertEquals(2024, intervals.get(2).getEnd());
    }
*/
}