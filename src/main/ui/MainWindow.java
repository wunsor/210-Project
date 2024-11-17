package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.ParticipatingSwimmers;
import persistence.JsonReader;
import persistence.JsonWriter;

//creates a main window in which the GUI initilizes and operates at
public class MainWindow {
    private static final String JSON_STORE = "./data/participatingswimmers.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame window;
    private JPanel panel;
    private ParticipatingSwimmers participatingSwimmers;

    // EFFECTS: creates a main window
    public MainWindow() {
        window = new JFrame();
        initialize();

    }

    // EFFECTS: initialize the main window with a title, close behaviour, size, and
    // location on screen
    private void initialize() {
        window.setVisible(true);
        window.setTitle("Winsor's Swim Meet Organizer");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
    }
}
