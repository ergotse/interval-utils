package se.ergot.utils.sequential;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequentiableYearTest {

    @Test
    void testEquals_sameValue() {
        // Two separately created instances with the same value must be equal, so distinct() in IntervalCollection can deduplicate them.
        assertEquals(SequentiableYear.of(Year.of(2024)), SequentiableYear.of(Year.of(2024)));
        assertEquals(SequentiableYear.of(Year.of(2024)).hashCode(), SequentiableYear.of(Year.of(2024)).hashCode());
    }
}
