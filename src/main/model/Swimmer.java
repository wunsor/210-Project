package model;

import java.util.ArrayList;

// Represents a swimmer with, a name, and Events
public class Swimmer {
    String swimmerName; //the name of the swimmer
    ArrayList<Event> events; // list of the swimmers events

    public Swimmer(String name, ArrayList<Event> events) {
        this.swimmerName = name;
        this.events = events;

    }

    //REQUIRES: event must be one of fly, back, breast, or free
    //EFFECTS: takes an event name, returns true if the swimmer has that event, false otherwise
    public boolean checkIfSwimmerHasEvent(String event) {
        for (Event e: events) {
            if (e.getEventName() == event) {
                return true;
            }
        }
        return false;
    }

    //MODIFIES: this
    //EFFECTS: adds an event to the swimmer's events
    public void addEvent(Event event) {
        this.events.add(event);
    }

    //REQUIRES: eventName is one of fly, back, breast, free
    //EFFECTS: finds an event with the same name and returns that time, returns 0 otherwise
    public double getSpecificEventTime(String eventName) {
        for (Event e : events) {
            if (e.getEventName() == eventName) {
                return e.getEventTime();
            }
        }
        return 0;
    }   
    
    

    //getters and setters

    public String getSwimmerName() {
        return this.swimmerName;
    }

    public ArrayList<Event> getSwimmerEvents() {
        return this.events;
    }
}
