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

    SwimEvent e1 = new SwimEvent("fly", 1);
    SwimEvent e2 = new SwimEvent("back", 2);
    SwimEvent e3 = new SwimEvent("free", 3);
    SwimEvent e4 = new SwimEvent("breast", 4);

    ArrayList<SwimEvent> eventList1;
    ArrayList<SwimEvent> eventList2;
    ArrayList<SwimEvent> eventList3;
    
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

