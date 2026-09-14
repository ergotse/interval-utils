package se.ergot.utils.sequential;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SequentiableIntegerTest {

    @Test
    void testEquals_sameValue() {
        // Two separately created instances with the same value must be equal, so distinct() in IntervalCollection can deduplicate them.
        assertEquals(SequentiableInteger.of(5), SequentiableInteger.of(5));
        assertEquals(SequentiableInteger.of(5).hashCode(), SequentiableInteger.of(5).hashCode());
    }

    @Test
    void testEquals_differentValue() {
        // Instances with different values must not be equal.
        assertNotEquals(SequentiableInteger.of(5), SequentiableInteger.of(6));
    }

    @Test
    void testGetDistance_noOverflowAtIntBoundaries() {
        // value - other used to overflow int when the two values sit at opposite ends of the Integer range.
        final long distance = SequentiableInteger.of(Integer.MAX_VALUE).getDistance(Integer.MIN_VALUE);
        assertEquals((long) Integer.MAX_VALUE - Integer.MIN_VALUE, distance);
    }
}
