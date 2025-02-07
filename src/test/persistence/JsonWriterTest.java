package persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriterTest extends JsonTest {

    Swimmer s1;
    Swimmer s2;
    ArrayList<SwimEvent> eventList1 = new ArrayList<SwimEvent>();
    ArrayList<SwimEvent> eventList2 = new ArrayList<SwimEvent>();

    @BeforeEach
    void runBefore() {
        SwimEvent e1 = new SwimEvent("fly", 55);
        SwimEvent e2 = new SwimEvent("free", 44);
        
        eventList1.add(e1); 
        eventList2.add(e2);

        s1 = new Swimmer("winsor", eventList1);
        s2 = new Swimmer("john", eventList2);
    }

    @Test
    void testWriterInvalidFile() {
        try {
            ParticipatingSwimmers ps = new ParticipatingSwimmers();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterGeneralParticipatingSwimmers() {
        try {
            ParticipatingSwimmers ps = new ParticipatingSwimmers();
            ps.addSwimmer(s1);
            ps.addSwimmer(s2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralParticipatingSwimmers.json");
            writer.open();
            writer.write(ps);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralParticipatingSwimmers.json");
            ps = reader.read();
            assertEquals(2, ps.getParticipatingSwimmers().size());
            checkSwimmer("winsor", eventList1, ps.getParticipatingSwimmers().get(0));
            checkSwimmer("john", eventList2, ps.getParticipatingSwimmers().get(1));

        } catch (IOException e) {
            fail("exception should not have been thrown");
        }
    }

}
