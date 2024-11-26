package persistence;

import org.junit.jupiter.api.Test;

import model.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
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
        SwimEvent e1 = new SwimEvent("fly", 55);
        SwimEvent e2 = new SwimEvent("free", 44);
        ArrayList<SwimEvent> eventList1 = new ArrayList<SwimEvent>();
        ArrayList<SwimEvent> eventList2 = new ArrayList<SwimEvent>();
        eventList1.add(e1);
        eventList2.add(e2);
        eventList1.add(e2);
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
