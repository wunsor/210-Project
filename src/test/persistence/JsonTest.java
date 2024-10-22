package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import model.*;

public class JsonTest {
    protected void checkSwimmer(String name, ArrayList<Event> events, Swimmer swimmer) {
        assertEquals(name, swimmer.getSwimmerName());
        assertEquals(events.size(), swimmer.getSwimmerEvents().size());
        assertEquals(events.get(0).getEventName(), swimmer.getSwimmerEvents().get(0).getEventName());
        assertEquals(events.get(0).getEventTime(), swimmer.getSwimmerEvents().get(0).getEventTime());
    }
}
