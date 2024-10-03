package model;

import java.util.ArrayList;

// Represents a swimmer with, a name, Events, and gender 
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
        return false;
    }

    //MODIFIES: this
    //EFFECTS: adds an event to the swimmer's events
    public void addEvent(Event event) {

    }

    //getters and setters

    public String getSwimmerName() {
        return null;
    }

    public ArrayList<Event> getSwimmerEvents() {
        return null;
    }
}
