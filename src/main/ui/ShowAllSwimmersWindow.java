package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ParticipatingSwimmers;
import model.*;

// Represents and facilitates the Show all swimmer function in GUI
public class ShowAllSwimmersWindow {
    private ParticipatingSwimmers ps;
    private JFrame window;
    private JPanel panel;

    public ShowAllSwimmersWindow(ParticipatingSwimmers ps) {
        this.ps = ps;
        window = new JFrame();
        initializeWindow();
        initializePanel();
        printSwimmersGUI();
    }

    //EFFECTS: prints the names of the participating swimmers
    public void printSwimmersGUI() {
        for (Swimmer s : ps.getParticipatingSwimmers()) {
            JLabel label = new JLabel(s.getSwimmerName());
            panel.add(label);
        }
    }

    // EFFECTS: initialize the main window with a title, close behaviour, size, and
    // location on screen
    private void initializeWindow() {
        window.setVisible(true);
        window.setTitle("All Swimmers");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(250, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }

    // EFFECTS: initializes the JPanel
    private void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        window.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
    }
}
