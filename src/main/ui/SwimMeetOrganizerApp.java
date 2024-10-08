package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Event;
import model.ParticipatingSwimmers;
import model.Swimmer;

//SwimMeetOrganizer creates an instance of a swim meet application in the ui.
public class SwimMeetOrganizerApp {
    private Scanner scanner;
    private boolean programRunStatus;
    private ParticipatingSwimmers participatingSwimmers;

    // EFFECTS: runs the application
    public SwimMeetOrganizerApp() {
        initilze();

        divider();
        System.out.println("Welcome to Winsor's Swim Meet Organizer App!");
        divider();

        while (this.programRunStatus) {
            handleMenu();
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes the application with correct state
    public void initilze() {
        this.programRunStatus = true;
        scanner = new Scanner(System.in);
        participatingSwimmers = new ParticipatingSwimmers();

    }

    // EFFECTS: prints and processes the menu
    public void handleMenu() {
        showMenu();
        String input = this.scanner.nextLine();
        processMenu(input);
    }

    // EFFECTS: prints possible commands which can be used in the menu
    public void showMenu() {
        System.out.println("What would you like to do?\n");
        System.out.println("q: Add a swimmer");
        System.out.println("w: Remove a swimmer");
        System.out.println("e: Lookup a swimmer");
        System.out.println("r: See all swimmers participating");
        System.out.println("t: Create heats");
        System.out.println("y: Quit application");
        divider();
    }

    // EFFECTS: takes a menu input from the user and processes it
    public void processMenu(String input) {
        divider();
        switch (input) {
            case "q":
                doAddSwimmer();
                break;
            case "w":
                doRemoveSwimmer();
                break;
            case "e":
                doLookupSwimmer();
                break;
            case "r":
                doSeeAllSwimmers();
                break;
            case "t":
                doCreateHeats();
                break;
            case "y":
                quitProgram();
                break;
            default:
                System.out.println("Invalid input! Please try again!");
        }
        divider();
    }

    // EFFECTS: creates heats based on an event
    private void doCreateHeats() {
        divider();
        System.out.println("Would you like to make events for fly, back, breast, or free?");
        switch (this.scanner.nextLine()) {
            case "fly":
                handleHeatCreation("fly");
                break;
            case "back":
                handleHeatCreation("back");
                break;
            case "breast":
                handleHeatCreation("breast");
                break;
            case "free":
                handleHeatCreation("free");
                break;

            default:
                System.out.println("Invaild event name! Try again!");
        }
    }

    // EFFECTS: prints heats and lane assignments for the swimmers in an event
    private void handleHeatCreation(String eventName) {
        ArrayList<Swimmer> swimmersInEvent;
        swimmersInEvent = participatingSwimmers.organizeIntoHeats(eventName);

        divider();
        System.out.println("The heats for" + " " + eventName + " " + "are:");
        Boolean stillPrintingHeats = true;
        Boolean stillCountingLanes = true;
        int heatNumber = 1;

        if (swimmersInEvent.size() != 0) {
            while (stillPrintingHeats) {
                divider();
                System.out.println("Heat " + heatNumber + ":");
                int swimmerCounter = 0;
                int laneCounter = 1;
                while (laneCounter <= 10 && stillCountingLanes) {  
                    String swimmerNameInLane =  swimmersInEvent.get(swimmerCounter).getSwimmerName();
                    System.out.println("Lane " + laneCounter + ": " + swimmerNameInLane);
                    swimmerCounter++;
                    laneCounter++;
                    if (swimmerCounter + 1 > swimmersInEvent.size()) {
                        stillCountingLanes = false;
                        stillPrintingHeats = false;
                    }
                }
                heatNumber++;
            }
        } else {
            System.out.println("Can't create heat as no swimmers are swimming this event!"); 
        }
        
    }

    // MODIFIES: this
    // EFFECTS: quits the program
    private void quitProgram() {
        System.out.println("Thanks for using Winsor's Swim meet organizer!");
        programRunStatus = false;
    }

    // EFFECTS: returns the name of every participating swimmer
    private void doSeeAllSwimmers() {
        divider();
        System.out.println("Printing all swimmer names!\n");
        for (Swimmer s : participatingSwimmers.getParticipatingSwimmers()) {
            System.out.println(s.getSwimmerName());
        }

    }

    // EFFECTS: return all the events of a swimmer
    private void doLookupSwimmer() {
        divider();
        System.out.println("What is the swimmer's name?");
        String answeredName = this.scanner.nextLine();
        if (participatingSwimmers.isSwimmerParticipating(answeredName)) {
            ArrayList<String> eventsList;

            eventsList = participatingSwimmers.lookupSwimmersEvents(answeredName);

            System.out.println(answeredName + "'s" + " events are:");
            for (String s : eventsList) {
                System.out.println(s);
            }

        } else {
            System.out.println("Swimmer can't be found! Please try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: handles removing a swimmer from the swim meet
    private void doRemoveSwimmer() {
        divider();
        System.out.println("What is the swimmer's name?");
        String answeredName = this.scanner.nextLine();
        if (participatingSwimmers.isSwimmerParticipating(answeredName)) {
            participatingSwimmers.removeSwimmer(answeredName);
            System.out.println("Swimmer removed!");

        } else {
            System.out.println("Swimmer can't be found! Please try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a swimmer to participating swimmers
    public void doAddSwimmer() {
        divider();
        System.out.println("Please enter the swimmer's name:");
        String swimmerName = this.scanner.nextLine();
        ArrayList<Event> swimmerEvents = handleEventAdding();

        Swimmer swimmerToAdd = new Swimmer(swimmerName, swimmerEvents);

        participatingSwimmers.addSwimmer(swimmerToAdd);

        System.out.println("New swimmer added!");
        divider();
    }

    // EFFECTS: handles the adding of multiple events for a swimmer
    public ArrayList<Event> handleEventAdding() {
        ArrayList<Event> swimmerEventList;
        swimmerEventList = new ArrayList<>();
        Boolean keepAddingEvents = true;

        swimmerEventList.add(handleEvent());
        while (keepAddingEvents) {
            divider();
            System.out.println("Would you like to add another event for this swimmer?");
            switch (this.scanner.nextLine()) {
                case "yes":
                    swimmerEventList.add(handleEvent());
                    break;

                case "no":
                    keepAddingEvents = false;
                    break;

                default:
                    System.out.println("Invalid answer!");
            }
        }

        return swimmerEventList;
    }

    // EFFECTS: handles creating an event with a name and time for a swimmer
    public Event handleEvent() {
        divider();
        System.out.println("Please enter if the swimmer is in fly, back, breast, or free:");
        System.out.println("(Make sure to not add the same event twice!)");
        String swimmerEventName = this.scanner.nextLine();
        switch (swimmerEventName) {
            case "fly":
                return new Event("fly", handleEventTime());
            case "back":
                return new Event("back", handleEventTime());

            case "breast":
                return new Event("breast", handleEventTime());

            case "free":
                return new Event("free", handleEventTime());

            default:
                System.out.println("Invalid event name! Please try again!");
        }
        return null;
    }

    // EFFECTS: handles giving a best time to the swimmers event
    public Double handleEventTime() {
        Double bestTime;
        divider();
        System.out.println("Please enter the swimmer's best time for this event:");
        bestTime = Double.parseDouble(this.scanner.nextLine());

        return bestTime;
    }

    // EFFECTS: prints a divider
    public void divider() {
        System.out.println("==================================");

    }

}
