package model;

import java.util.ArrayList;

// Represents a list of participating swimmers at a swim meet
public class ParticipatingSwimmers {
    private ArrayList<Swimmer> swimmers; //a list of swimmers

    //EFFECT: a list of all participating swimmer which is empty when initialized
    public ParticipatingSwimmers() {

    }

    //REQUIRES: event must be one of fly, back, breast, or free
    //EFFECTS: takes an event name, filters the list for only the swimmers which swim that event, 
    //         then re-arranges them from fastest to slowest times 
    public ArrayList<Swimmer> organizeIntoHeats(String event) {
        return null;

    }

    //EFFECTS: takes a swimmer's name, returns their events as a string 
    public ArrayList<String> lookupSwimmersEvents(String name) {
        return null;

    }

    //MODIFIES: this
    //EFFECTS: takes a swimmer and adds them to the list of participating swimmers
    public void addSwimmer(Swimmer swimmer) {

    }

    //MODIFIES: this
    //EFFECTS: takes a swimmers name as a string and removes them from the list of participating swimmers
    public void removeSwimmer(String name) {

    }

    // setters and getters

    public ArrayList<Swimmer> getParticipatingSwimmers(){
        return null;
    }


}
