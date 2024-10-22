package persistence;

import org.junit.jupiter.api.Test;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ParticipatingSwimmers ps = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyParticipatingSwimmers() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyParticipatingSwimmers.json");
        try {
            ParticipatingSwimmers ps = reader.read();
            assertEquals(0, ps.getParticipatingSwimmers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralParticipatingSwimmers() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralParticipatingSwimmers.json");
        Event e1 = new Event("fly", 55);
        Event e2 = new Event("free", 44);
        List<Event> eventList1 = new ArrayList<Event>();
        eventList1.add(e1);
        List<Event> eventList2 = new ArrayList<Event>();
        eventList2.add(e2);
        try {
            ParticipatingSwimmers ps = reader.read();
            assertEquals(2, ps.getParticipatingSwimmers().size());
            checkSwimmer("winsor", eventList1, ps.getParticipatingSwimmers().get(0));
            checkSwimmer("john", eventList2, ps.getParticipatingSwimmers().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
