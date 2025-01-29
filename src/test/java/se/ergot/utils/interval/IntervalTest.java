package se.ergot.utils.interval;

import org.junit.jupiter.api.Test;
import se.ergot.utils.sequential.SequentiableInteger;
import se.ergot.utils.sequential.SequentiableLong;
import se.ergot.utils.sequential.SequentiableYear;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervalTest {

    @Test
    void testInterval_integer() {
        final int start = 1;
        final int end = 20;
        final Interval<SequentiableInteger> interval = new Interval<>(SequentiableInteger.of(start), SequentiableInteger.of(end));
        assertEquals(start, interval.getStart().getValue());
        assertEquals(end, interval.getEnd().getValue());
        assertEquals("1-20", interval.toString());
    }

    @Test
    void testInterval_long() {
        final long start = 1L;
        final long end = 20L;
        final Interval<SequentiableLong> interval = new Interval<>(SequentiableLong.of(start), SequentiableLong.of(end));
        assertEquals(start, interval.getStart().getValue());
        assertEquals(end, interval.getEnd().getValue());
        assertEquals("1-20", interval.toString());
    }

    @Test
    void testInterval_year() {
        final Year start = Year.of(2016);
        final Year end = Year.of(2022);
        final Interval<SequentiableYear> interval = new Interval<>(SequentiableYear.of(start), SequentiableYear.of(end));
        assertEquals(start, interval.getStart().getValue());
        assertEquals(end, interval.getEnd().getValue());
        assertEquals("2016-2022", interval.toString());
    }

    @Test
    void testInterval_same() {
        final long start = 1L;
        final Interval<SequentiableLong> interval = new Interval<>(SequentiableLong.of(start), SequentiableLong.of(start));
        assertEquals(start, interval.getStart().getValue());
        assertEquals(start, interval.getEnd().getValue());
        assertEquals("1", interval.toString());
    }

    @Test
    void testInterval_greaterToLesser() {
        final long start = 1L;
        final long end = 20L;
        final Interval<SequentiableLong> interval = new Interval<>(SequentiableLong.of(end), SequentiableLong.of(start));
        assertEquals(start, interval.getStart().getValue());
        assertEquals(end, interval.getEnd().getValue());
        assertEquals("1-20", interval.toString());
    }
}