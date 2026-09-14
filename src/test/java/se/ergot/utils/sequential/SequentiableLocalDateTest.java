package se.ergot.utils.sequential;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequentiableLocalDateTest {

    @Test
    void testEquals_sameValue() {
        // Two separately created instances with the same value must be equal, so distinct() in IntervalCollection can deduplicate them.
        assertEquals(SequentiableLocalDate.of(LocalDate.of(2024, 1, 1)), SequentiableLocalDate.of(LocalDate.of(2024, 1, 1)));
        assertEquals(SequentiableLocalDate.of(LocalDate.of(2024, 1, 1)).hashCode(), SequentiableLocalDate.of(LocalDate.of(2024, 1, 1)).hashCode());
    }

    @Test
    void testGetDistance() {
        final SequentiableLocalDate date = SequentiableLocalDate.of(LocalDate.of(2024, 1, 1));
        assertEquals(4, date.getDistance(LocalDate.of(2024, 1, 5)));
        assertEquals(4, date.getDistance(LocalDate.of(2023, 12, 28)));
    }

    @Test
    void testGetNextAndGetPrevious() {
        final SequentiableLocalDate date = SequentiableLocalDate.of(LocalDate.of(2024, 1, 1));
        assertEquals(LocalDate.of(2024, 1, 2), date.getNext());
        assertEquals(LocalDate.of(2023, 12, 31), date.getPrevious());
    }
}
