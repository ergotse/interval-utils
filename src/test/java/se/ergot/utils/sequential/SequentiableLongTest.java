package se.ergot.utils.sequential;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SequentiableLongTest {

    @Test
    void testEquals_sameValue() {
        // Two separately created instances with the same value must be equal, so distinct() in IntervalCollection can deduplicate them.
        assertEquals(SequentiableLong.of(5L), SequentiableLong.of(5L));
        assertEquals(SequentiableLong.of(5L).hashCode(), SequentiableLong.of(5L).hashCode());
    }

    @Test
    void testGetDistance_throwsOnUnrepresentableDistance() {
        // The true distance between Long.MIN_VALUE and Long.MAX_VALUE does not fit in a long,
        // so it must fail fast instead of silently returning a wrapped-around wrong value.
        final SequentiableLong min = SequentiableLong.of(Long.MIN_VALUE);
        assertThrows(ArithmeticException.class, () -> min.getDistance(Long.MAX_VALUE));
    }
}
