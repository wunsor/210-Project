package model;

import org.json.JSONObject;

import persistence.Writable;

// Represents an Event which a swimmer might have, includes the name of the event and a time
public class SwimEvent implements Writable {
    private String eventName; // name of the event, ie. fly
    private double eventTime; // best time of the swimmer in that event in seconds

    // REQUIRES: name must be one of fly, back, breast, or free.
    // EFFECTS: creates an instance of an event with a name and a best time in that event in seconds
    public SwimEvent(String name, double time) {
        this.eventName = name;
        this.eventTime = time;

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("eventName", eventName);
        json.put("eventTime", eventTime);
        return json;
    }


    //setters and getters
    public String getEventName() {
        return this.eventName;
    }

    public double getEventTime() {
        return this.eventTime;
    }

}
