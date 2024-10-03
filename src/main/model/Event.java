package model;

// Represents an Event which a swimmer might have, includes the name of the event and a time
public class Event {
    private String eventName; // name of the event, ie. fly
    private double eventTime; // best time of the swimmer in that event in seconds

    // REQUIRES: name must be one of fly, back, breast, or free. time is a time in seconds
    public Event(String name, double time) {
        this.eventName = name;
        this.eventTime = time;

    }

    //setters and getters
    public String getEventName() {
        return this.eventName;
    }

    public double getEventTime() {
        return this.eventTime;
    }

}
