package persistence;

import org.json.JSONObject;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public interface Writable {

    //EFFECTS: returns this as a JSON object
    JSONObject toJson();

}
