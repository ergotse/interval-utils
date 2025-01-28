package se.ergot.utils.interval;

import org.junit.jupiter.api.Test;
import se.ergot.utils.sequential.SequentiableDate;
import se.ergot.utils.sequential.SequentiableInteger;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervalTest {

    private final LocalDate first = LocalDate.of(2024, 1, 1);

    private final LocalDate last = LocalDate.of(2024, 1, 2);

    @Test
    void testInterval_date() {
        final Interval<SequentiableDate, LocalDate> interval = new Interval<>(SequentiableDate.of(first),
                SequentiableDate.of(last));
        assertEquals(first, interval.getStart().getValue());
        assertEquals(last, interval.getEnd().getValue());
        assertEquals("2024-01-01-2024-01-02", interval.toString());
    }

    @Test
    void testInterval_date2() {
        final Interval<SequentiableDate, LocalDate> interval = new Interval<>(first, last, SequentiableDate.class);
        assertEquals(first, interval.getStart().getValue());
        assertEquals(last, interval.getEnd().getValue());
        assertEquals("2024-01-01-2024-01-02", interval.toString());
    }

    @Test
    void testInterval_integer() {
        final Interval<SequentiableInteger, Integer> interval = new Interval<>(SequentiableInteger.of(1), SequentiableInteger.of(2));
        assertEquals(1, interval.getStart().getValue());
        assertEquals(2, interval.getEnd().getValue());
        assertEquals("1-2", interval.toString());
    }

    @Test
    void testIntervalBackwards() {
        final Interval<SequentiableInteger, Integer> interval = new Interval<>(SequentiableInteger.of(2), SequentiableInteger.of(1));
        assertEquals(1, interval.getStart().getValue());
        assertEquals(2, interval.getEnd().getValue());
        assertEquals("1-2", interval.toString());
    }

    @Test
    void testIntervalSame() {
        final Interval<SequentiableInteger, Integer> interval = new Interval<>(SequentiableInteger.of(1), SequentiableInteger.of(1));
        assertEquals(1, interval.getStart().getValue());
        assertEquals(1, interval.getEnd().getValue());
        assertEquals("1", interval.toString());
    }
}