# Winsor's Swim Meet Organizer 

## Project description

A swim meet organizer which will handle the organizational/ backend end of a swim meet. This application will allow someone to enter a list of swimmers and their events and then organize these swimmers into heats. This organization will be done based on their best time (so that the fastest swimmers are in lane 1), and the type of race (the differing stroke/ event). A user interface would then be able to display this information in an organized matter. Moreover, a simple swimmer lookup function could be added to fetch information on what events a swimmer is swimming.

This application will be useful to both swimmers participating in a swim meet and the organizers of a swim meet. Oftentimes it is difficult for a swimmer at a swim meet to figure out what and when their events are in a quick way. In addition, for places without the funds or the scale to purchase other swim meet organizing applications, manually organizing swimmers into heats manually is really cumbersome. I have witnessed both of these issues through my experiences in competitive swimming, even seeing younger swimmers miss their races because they were unable to figure out when they were swimming! Therefore, this project is of interest to me because I want to address these two problems and create a more streamlined swim meet experience. 

A *bulleted* list:
- As a user, I want to be able to add a swimmer, their events, and their times (arbitrary X) to a list of participating swimmers (Y). 
- As a user, I want to be able to view a list of all participating swimmers (list all the Xs in my Y).
- As a user, I want to be able to organize the list of participating swimmers into heats based on their events and time.
- As a user, I want to be able to lookup my name to find my events.
- As a user, I also want to be able to remove a swimmer from the swim meet.
- As a user, I want an option to save a list of participating swimmers and their events and best times.
- As a user, I want an option to load a list of participating swimmers and their events and best times.

An example of text with **bold** and *italic* fonts.  

**Instructions for End User**
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking the "Add Swimmer" button in the main menu.
    - Once the Add Swimmer window appears, indicate which events the swimmer is swimming using the checkboxes, and enter their best times in the text fields. Hit "save" once this is completed.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by clicking the "Lookup Swimmer" button in the main menu.
    - Once the Lookup Swimmer window appears, enter their name, hit 'enter' and view the swimmers events at the bottom of the window.
- You can locate my visual component by viewing the image icons which can be found on each button in the main menu.
- You can save the state of my application by hitting the "Save" button in the main menu.
- You can reload the state of my application by hitting the "Load" button in the main menu.

Phase 4: Task 2 (Event logging)

Logged Events:
Swimmer added!
Swimmer added!
Swimmer removed!
Looked up a swimmer!
Swimmer added!

Phase 4: Task 3 (Refactoring)

Firstly, I would try to refactor the shared behaviour between all of my window classes so that their shared behaviour of the window’s construction is abstracted. Between the windows, much of the window setup for things that initialize the windows behaviour or the layout of the window is the exact same. Creating this abstract class would then reduce the coupling between my classes, as some change to how the window initializes would no longer need to be reflected in every window class within my GUI.

Second, I would perhaps create new GUI classes to handle the saving and loading function within the GUI. Currently saving and loading is implemented within the MainWindow class making the MainWindow incohesive. The MainWindow exists purely to act as a bridge to facilitate the other user stories. As such, the window itself should not deal with the physical saving and loading as this function is different from what the window is intended for. In addition, I would also like to refactor my GUI such that the program is less dependent on the MainWindow. Currently the MainWindow also stores information on the state of the program which once again isn’t very cohesive with the intention of the MainWindow. As such, a new class which purely facilitates the state of the swim meet instead of the MainWindow could be created. This would reduce the dependencies and associations (decreasing coupling) of the other window classes on MainWindow and better fit the intended role of the MainWindow (increasing cohesion).

