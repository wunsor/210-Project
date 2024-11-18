package ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ParticipatingSwimmers;
import persistence.JsonReader;
import persistence.JsonWriter;

//creates a main window in which the GUI initilizes and operates at
public class MainWindow {
    private ParticipatingSwimmers participatingSwimmers;

    private static final String JSON_STORE = "./data/participatingswimmers.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame window;
    private JPanel panel;

    private ImageIcon addIcon;
    private ImageIcon removeIcon;
    private ImageIcon lookupIcon;
    private ImageIcon showIcon;
    private ImageIcon saveIcon;
    private ImageIcon loadIcon;

    private JButton addSwimmerButton;
    private JButton lookupButton;
    private JButton removeSwimmerButton;
    private JButton showAllButton;
    private JButton saveButton;
    private JButton loadButton;

    // EFFECTS: creates a main window
    public MainWindow() {
        window = new JFrame();
        initializeWindow();
        initializePanel();
        initializeIcons();
        initializeButtons();
        initializeListeners();

    }

    //EFFECTS: initializes the action listeners
    private void initializeListeners() {
        addSwimmerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AddSwimmerWindow addWindow = new AddSwimmerWindow();
                participatingSwimmers.addSwimmer(addWindow.getSwimmerToAdd());
            }
            
        });
    }

    //EFFECTS: initializes the button icons
    private void initializeIcons() {
        addIcon = new ImageIcon("./Images/Add.png");
        removeIcon = new ImageIcon("./Images/Remove.png");
        lookupIcon = new ImageIcon("./Images/Lookup.png");
        showIcon = new ImageIcon("./Images/Show.png");
        saveIcon = new ImageIcon("./Images/Save.png");
        loadIcon = new ImageIcon("./Images/Load.png");
    }

    // EFFECTS: initializes all buttons
    private void initializeButtons() {
        addSwimmerButton = new JButton("Add Swimmer");
        removeSwimmerButton = new JButton("Remove Swimmer");
        lookupButton = new JButton("Lookup Swimmer");
        showAllButton = new JButton("Show All Swimmers");
        saveButton = new JButton("Save Swimmers");
        loadButton = new JButton("Load Swimmer");

        panel.add(addSwimmerButton);
        panel.add(removeSwimmerButton);
        panel.add(lookupButton);
        panel.add(showAllButton);
        panel.add(saveButton);
        panel.add(loadButton);

        addSwimmerButton.setMargin(new Insets(10, 20, 10, 20));
        removeSwimmerButton.setMargin(new Insets(10, 20, 10, 20));
        lookupButton.setMargin(new Insets(10, 20, 10, 20));
        showAllButton.setMargin(new Insets(10, 20, 10, 20));
        saveButton.setMargin(new Insets(10, 20, 10, 20));
        loadButton.setMargin(new Insets(10, 20, 10, 20));

        putButtonIcons();

    }

    //EFFECTS: formats the button icons
    private void putButtonIcons() {
        addSwimmerButton.setBackground(Color.WHITE);
        removeSwimmerButton.setBackground(Color.WHITE);
        lookupButton.setBackground(Color.WHITE);
        showAllButton.setBackground(Color.WHITE);
        saveButton.setBackground(Color.WHITE);
        loadButton.setBackground(Color.WHITE);

        addSwimmerButton.setIcon(addIcon);
        removeSwimmerButton.setIcon(removeIcon);
        lookupButton.setIcon(lookupIcon);
        showAllButton.setIcon(showIcon);
        saveButton.setIcon(saveIcon);
        loadButton.setIcon(loadIcon);
    }

    // EFFECTS: initializes the JPanel
    private void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        window.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
    }

    // EFFECTS: initialize the main window with a title, close behaviour, size, and
    // location on screen
    private void initializeWindow() {
        window.setVisible(true);
        window.setTitle("Winsor's Swim Meet Organizer");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(250, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}
