package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Event;
import model.*;

public class AddSwimmerWindow {
    private Swimmer swimmerToAdd;
    private MainWindow mainWindow;
    
    private JFrame window;
    private JPanel panel;
    private JButton saveButton;

    private JCheckBox flyBox;
    private JCheckBox backBox;
    private JCheckBox breastBox;
    private JCheckBox freeBox;

    private JLabel nameLabel;
    private JLabel flyLabel;
    private JLabel backLabel;
    private JLabel breastLabel;
    private JLabel freeLabel;

    private JTextField swimmerName;
    private JTextField flyTime;
    private JTextField backTime;
    private JTextField breastTime;
    private JTextField freeTime;
    
    //EFFECTS: creates a new window to add a new swimmer
    public AddSwimmerWindow(MainWindow mw) {
        mainWindow = mw;
        window = new JFrame();
        initializeWindow();
        initializePanel();
        initializeLabels();
        initializeTextFields();
        initializeCheckBoxes();
        initializeButton();
        placePanelItems();
    }

    //EFFECTS: initializes the check boxes
    private void initializeCheckBoxes() {
        flyBox = new JCheckBox();
        backBox = new JCheckBox();
        breastBox = new JCheckBox();
        freeBox = new JCheckBox();
    }

    //EFFECTS: places the panel items
    private void placePanelItems() {
        panel.add(nameLabel);
        panel.add(swimmerName);
        panel.add(flyLabel);
        panel.add(flyBox);
        panel.add(flyTime);
        panel.add(backLabel);
        panel.add(backBox);
        panel.add(backTime);
        panel.add(breastLabel);
        panel.add(breastBox);
        panel.add(breastTime);
        panel.add(freeLabel);
        panel.add(freeBox);
        panel.add(freeTime);
        panel.add(saveButton);
    }

    //EFFECTS: initializes the save button
    private void initializeButton() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    recordUserInput();
                    updateMainWindow();
                } catch (Exception e1) {
                    new ErrorWindow();
                } finally {
                    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                }  
            }
            
        });
    }

    private void updateMainWindow() {
        mainWindow.getParticipatingSwimmers().addSwimmer(swimmerToAdd);
    }

    //MODIFIES: this
    //EFFECTS: reads the user input and sets a swimmer of this frame
    protected void recordUserInput() {
        String name = swimmerName.getText();
        ArrayList<Event> events = new ArrayList<>();

        if (flyBox.isSelected()) {
            events.add(new Event("fly", Double.parseDouble(flyTime.getText())));
        }

        if (backBox.isSelected()) {
            events.add(new Event("back", Double.parseDouble(backTime.getText())));
        }

        if (breastBox.isSelected()) {
            events.add(new Event("breast", Double.parseDouble(breastTime.getText())));
        }

        if (freeBox.isSelected()) {
            events.add(new Event("free", Double.parseDouble(freeTime.getText())));
        }

        this.swimmerToAdd = new Swimmer(name, events);
    }

    //EFFECTS: initializes the text fields
    private void initializeTextFields() {
        swimmerName = new JTextField();
        flyTime = new JTextField();
        backTime = new JTextField();
        breastTime = new JTextField();
        freeTime = new JTextField();
    }

    //EFFECTS: initializes the text labels
    private void initializeLabels() {
        nameLabel = new JLabel("Swimmer's Name");
        flyLabel = new JLabel("Fly? + Best Time");
        backLabel = new JLabel("Back? + Best Time");
        breastLabel = new JLabel("Breast? + Best Time");
        freeLabel = new JLabel("Free? + Best Time");
    }

    // EFFECTS: initializes the JPanel
    private void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        window.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
    }

    //EFFECTS: initializes the window
    private void initializeWindow() {
        window.setVisible(true);
        window.setTitle("Add Swimmer");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(250, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }

    //EFFECTS: returns the swimmer to be added
    public Swimmer getSwimmerToAdd() {
        return swimmerToAdd;
    }
}
