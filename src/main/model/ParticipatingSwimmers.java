package model;

import java.util.ArrayList;

// Represents a list of participating swimmers at a swim meet
public class ParticipatingSwimmers {
    private ArrayList<Swimmer> swimmers; //a list of swimmers

    //EFFECT: a list of all participating swimmer which is empty when initialized
    public ParticipatingSwimmers() {
        this.swimmers = new ArrayList<>();
    }

    //REQUIRES: event must be one of fly, back, breast, or free
    //EFFECTS: takes an event name, filters the list for only the swimmers which swim that event, 
    //         then re-arranges them from fastest to slowest times 
    public ArrayList<Swimmer> organizeIntoHeats(String event) {
        ArrayList<Swimmer> initialList;
        ArrayList<Double> listForTimes;
        ArrayList<Swimmer> finalList;
        finalList = new ArrayList<>();

        initialList = new ArrayList<>();
        listForTimes = new ArrayList<>();
        
        for (Swimmer s : swimmers) {
            if (s.checkIfSwimmerHasEvent(event)) {
                initialList.add(s);
                listForTimes.add(s.getSpecificEventTime(event));
            }
        }

        listForTimes.sort((timeOne, timeTwo) -> {
            return Double.compare(timeOne, timeTwo); 
        });

        for (Double d : listForTimes) {
            matchSwimmerToTime(event, initialList, finalList, d);
        }

        return finalList;

    }

    //REQUIRES: event must be one of fly, back, breast, or free
    //EFFECTS: matches each swimmer to a time
    public void matchSwimmerToTime(String e, ArrayList<Swimmer> inList, ArrayList<Swimmer> fiList, Double d) {
        for (int i = 0; i < inList.size(); i++) {
            if (inList.get(i).getSpecificEventTime(e) == d) {
                fiList.add(inList.get(i));
                inList.remove(inList.get(i));
                break;
            }
        }
    }

    //REQUIRES: name must be one the swimmers names already in the list
    //EFFECTS: takes a swimmer's name, returns their events as a list of string 
    public ArrayList<String> lookupSwimmersEvents(String name) {
        ArrayList<String> eventsStringList;
        eventsStringList = new ArrayList<>();
        for (Swimmer s : swimmers) {
            if (s.getSwimmerName().equals(name)) {
                for (Event e : s.getSwimmerEvents()) {
                    eventsStringList.add(e.getEventName());
                }
                return eventsStringList;
            }
        }
        return eventsStringList;

    }

    //MODIFIES: this
    //EFFECTS: takes a swimmer and adds them to the list of participating swimmers
    public void addSwimmer(Swimmer swimmer) {
        this.swimmers.add(swimmer);
    }

    //REQUIRES: name matches one of the names in the list of participating swimmers
    //MODIFIES: this
    //EFFECTS: takes a swimmers name as a string and removes them from the list of participating swimmers
    public void removeSwimmer(String name) {
        for (int i = 0; i < swimmers.size(); i++) {
            if (swimmers.get(i).getSwimmerName().equals(name)) {
                this.swimmers.remove(swimmers.get(i));
            }
        }
    }

    //EFFECTS: checks if a swimmer name exists within participating swimmers
    public Boolean isSwimmerParticipating(String name) {
        for (Swimmer s : swimmers) {
            if (s.getSwimmerName().equals(name)) {
                return true;
            }
        }

        return false;
    }



    // setters and getters

    public ArrayList<Swimmer> getParticipatingSwimmers() {
        return this.swimmers;
    }


}
