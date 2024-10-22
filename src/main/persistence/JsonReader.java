package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

import model.*;

// Represents a reader that reads ParticipatingSwimmers from JSON data stored in file

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReader {
    private String source;

    //EFFECTS: constrcuts reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //EFFECTS: reads ParticipatingSwimmers from file and return it,
    //         throws IOException if an error occurs reading data from file
    public ParticipatingSwimmers read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseParticipatingSwimmers(jsonObject);
    }
    
     // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses ParticipatingSwimmers from JSON object and returns it
    private ParticipatingSwimmers parseParticipatingSwimmers(JSONObject jsonObject) {
        ParticipatingSwimmers ps = new ParticipatingSwimmers();
        addSwimmers(ps, jsonObject);
        return ps;
    }

    // MODIFIES: ps
    // EFFECTS: parses swimmers from JSON object and adds them to participating swimmers
    private void addSwimmers(ParticipatingSwimmers ps, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("swimmers");
        for (Object json : jsonArray) {
            JSONObject nextSwimmer = (JSONObject) json;
            addSwimmer(ps, nextSwimmer);
        }
    }

    // MODIFIES: ps
    // EFFECTS: parses swimmer from JSON object and adds it to participating swimmers
    private void addSwimmer(ParticipatingSwimmers ps, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ArrayList<Event> events = readEvents(jsonObject);
        Swimmer swimmer = new Swimmer(name, events);
        ps.addSwimmer(swimmer);
    }

    // EFFECTS: parses events from JSON object and complies a list of events from it
    private ArrayList<Event> readEvents(JSONObject jsonObject) {
        ArrayList<Event> eventList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("events");
        for (Object json : jsonArray) {
            JSONObject nextEvent = (JSONObject) json;
            eventList.add(addEvent(nextEvent));
        }
        return eventList;
    }

    // EFFECTS: parses event from JSON object and returns it
    private Event addEvent(JSONObject jsonObject) {
        String name = jsonObject.getString("eventName");
        Double time = jsonObject.getDouble("eventTime");
        return new Event(name, time);

    }

    
}
