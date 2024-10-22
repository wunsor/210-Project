package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import model.*;

public class JsonTest {
    protected void checkSwimmer(String name, List<Event> events, Swimmer swimmer ) {
        assertEquals(name, swimmer.getSwimmerName());
        assertEquals(events, swimmer.getSwimmerEvents());
    }
}
