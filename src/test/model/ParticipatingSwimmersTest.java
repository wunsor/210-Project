package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParticipatingSwimmersTest {
    ParticipatingSwimmers pswimmersTest;
    
    Swimmer s1;
    Swimmer s2;
    Swimmer s3;
    Swimmer s4;
    
    Event e1 = new Event("fly", 1);
    Event e2 = new Event("back", 2);
    Event e3 = new Event("free", 3);
    Event e4 = new Event("breast", 4);
    Event e5 = new Event("fly", 4);

    ArrayList<Event> eventList1;
    ArrayList<Event> eventList2;
    ArrayList<Event> eventList3;

    ArrayList<String> eventStringList1;
    ArrayList<String> emptyList;

    @BeforeEach
    void runBefore() {
        eventList1 = new ArrayList<>();
        eventList2 = new ArrayList<>();
        eventList3 = new ArrayList<>();

        eventStringList1 = new ArrayList<>();
        emptyList = new ArrayList<>();

        eventList1.add(e1);
        eventList1.add(e2);

        eventList2.add(e4);
        eventList2.add(e2);
        eventList2.add(e3);

        eventList3.add(e4);
        eventList3.add(e2);
        eventList3.add(e5);
        eventList3.add(e3);

        eventStringList1.add("fly");
        eventStringList1.add("back");

        s1 = new Swimmer("john", eventList1);
        s2 = new Swimmer("jack", eventList2);
        s3 = new Swimmer("gill", eventList3);
        s4 = new Swimmer("terry", eventList3);

        pswimmersTest = new ParticipatingSwimmers();
    }

    @Test
    void testConstructor() {
        assertEquals(0, pswimmersTest.getParticipatingSwimmers().size());
    }

    @Test
    void testOrganizeIntoHeats() {
        pswimmersTest.addSwimmer(s1);
        pswimmersTest.addSwimmer(s2);
        pswimmersTest.addSwimmer(s3);
        ArrayList<Swimmer> returnedList = pswimmersTest.organizeIntoHeats("fly");
        assertEquals(2, returnedList.size());
        assertEquals("john", returnedList.get(0).getSwimmerName());
        assertEquals("gill", returnedList.get(1).getSwimmerName());
    }

    @Test
    void testOrganizeIntoHeatsOutOfOrder() {
        pswimmersTest.addSwimmer(s3);
        pswimmersTest.addSwimmer(s2);
        pswimmersTest.addSwimmer(s1);
        ArrayList<Swimmer> returnedList = pswimmersTest.organizeIntoHeats("fly");
        assertEquals(2, returnedList.size());
        assertEquals("john", returnedList.get(0).getSwimmerName());
        assertEquals("gill", returnedList.get(1).getSwimmerName());
    }



    @Test
    void testLookupSwimmersEvents() {
        pswimmersTest.addSwimmer(s1);
        pswimmersTest.addSwimmer(s2);
        pswimmersTest.addSwimmer(s3);
        assertEquals(eventStringList1, pswimmersTest.lookupSwimmersEvents("john"));
        assertEquals(emptyList, pswimmersTest.lookupSwimmersEvents("a"));
    }

    @Test
    void testAddSwimmer() {
        assertEquals(0, pswimmersTest.getParticipatingSwimmers().size());
        pswimmersTest.addSwimmer(s1);
        assertEquals(1, pswimmersTest.getParticipatingSwimmers().size());
    }

    @Test
    void testRemoveSwimmer() {
        pswimmersTest.addSwimmer(s1);
        assertEquals(1, pswimmersTest.getParticipatingSwimmers().size());
        pswimmersTest.removeSwimmer("john");
        assertEquals(0, pswimmersTest.getParticipatingSwimmers().size());

    }

    
}
