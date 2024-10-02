package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
    
    Event[] eventList1 = {e1, e2};
    Event[] eventList2 = {e4, e2, e3};
    Event[] eventList3 = {e4, e2, e5, e3};

    @BeforeEach
    void runBefore() {
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
        List<Swimmer> returnedList = pswimmersTest.organizeIntoHeats("fly");
        assertEquals(2, returnedList.size());
        assertEquals("john", returnedList.get(0).getSwimmerName());
        assertEquals("gill", returnedList.get(1).getSwimmerName());
    }

    @Test
    void testLookupSwimmersEvents() {
        pswimmersTest.addSwimmer(s1);
        pswimmersTest.addSwimmer(s2);
        pswimmersTest.addSwimmer(s3);
        assertEquals("fly,back", pswimmersTest.lookupSwimmersEvents("john"));

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
