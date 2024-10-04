package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwimmerTest {
    Swimmer s1;
    Swimmer s2;

    Event e1 = new Event("fly", 1);
    Event e2 = new Event("back", 2);
    Event e3 = new Event("free", 3);
    Event e4 = new Event("breast", 4);

    ArrayList<Event> eventList1;
    ArrayList<Event> eventList2;
    ArrayList<Event> eventList3;
    
    @BeforeEach
    void runBefore() {
        eventList1 = new ArrayList<>();
        eventList2 = new ArrayList<>();
        eventList3 = new ArrayList<>();

        eventList1.add(e1);
        eventList1.add(e2);

        eventList2.add(e4);
        eventList2.add(e2);
        eventList2.add(e3);

        eventList3.add(e1);
        eventList3.add(e2);
        eventList3.add(e4);

        s1 = new Swimmer("john", eventList1);
        s2 = new Swimmer("jack", eventList2);
    }

    @Test
    void testConstructor() {
        assertEquals("john", s1.getSwimmerName());
        assertEquals(eventList1, s1.getSwimmerEvents());
    }

    @Test
    void testCheckIfSwimmerHasEvent() {
        assertTrue(s1.checkIfSwimmerHasEvent("fly"));
        assertFalse(s1.checkIfSwimmerHasEvent("breast"));
    }

    @Test
    void testAddEvent() {
        assertEquals(eventList1, s1.getSwimmerEvents());
        assertEquals(2, s1.getSwimmerEvents().size());
        s1.addEvent(e4);
        assertEquals(3, s1.getSwimmerEvents().size());
        assertEquals(eventList3, s1.getSwimmerEvents());
        s1.addEvent(e3);
        assertEquals(4, s1.getSwimmerEvents().size());
    }

    @Test
    void testGetSpecificEventTime() {
        assertEquals(1,s1.getSpecificEventTime("fly"));
        assertEquals(0,s1.getSpecificEventTime("a"));
    }
}

