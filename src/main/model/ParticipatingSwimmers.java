package model;

import java.util.List;

// Represents a list of participating swimmers at a swim meet
public class ParticipatingSwimmers {
    private List<Swimmer> swimmers; //a list of swimmers

    public ParticipatingSwimmers() {

    }
    //REQUIRES: event must be one of fly, back, breast, or free
    //MODIFIES: This
    //EFFECTS: takes an event name, filters the list for only the swimmers which swim that event, 
    //         then re-arranges them from fastest to slowest times 

    public List<Swimmer> organizeIntoHeats(String event) {
        return null;

    }

    //REQUIRES: event must be one of fly, back, breast, or free
    //EFFECTS: takes an event name, returns true if the swimmer has that event, false otherwise

    public boolean checkIfSwimmerHasEvent(String event) {
        return false;
    }

    //EFFECTS: takes a swimmer's name, returns their events as a List<String>

    public List<String> lookupSwimmersEvents() {
        return null;

    }

    //MODIFIES: this
    //EFFECTS: takes a swimmer and adds them to the list of participating swimmers

    public void addSwimmer(Swimmer swimmer) {

    }

    //MODIFIES: this
    //EFFECTS: takes a swimmers name as a string and removes them from the list of participating swimmers

    public void removeSwimmer() {

    }




}
