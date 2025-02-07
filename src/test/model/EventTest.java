package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventTest {
    SwimEvent e1;
    SwimEvent e2;

    @BeforeEach
    void runBefore() {
        e1 = new SwimEvent("fly",1);
        e2 = new SwimEvent("back", 2);
    }

    @Test
    void testGetEventName() {
        assertEquals("fly", e1.getEventName());
        assertEquals("back", e2.getEventName());
    }

    @Test
    void testGetEventTime() {
        assertEquals(1, 0.001, e1.getEventTime());
        assertEquals(2, 0.001, e2.getEventTime());
    }

}
