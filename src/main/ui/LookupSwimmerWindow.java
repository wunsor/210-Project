package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;

// Represents and facilitates the function of the lookupfunction
public class LookupSwimmerWindow {
    private ParticipatingSwimmers ps;
    private JFrame window;
    private JPanel panel;
    private JTextField textField;
    private JLabel labelInput;
    private JLabel blankLabel;

    //EFFECTS: creates an instance of the lookup swimmer popup
    public LookupSwimmerWindow(ParticipatingSwimmers ps) {
        this.ps = ps;
        window = new JFrame();
        initializeWindow();
        initializePanel();
        initializeTextFieldAndLabel();
    }

    // EFFECTS: initializes the textfield and labels
    private void initializeTextFieldAndLabel() {
        labelInput = new JLabel("Swimmer's name:");
        blankLabel = new JLabel("Swimmer's events are:");
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 10));
        panel.add(labelInput);
        panel.add(textField);
        panel.add(blankLabel);

        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String swimmerName = textField.getText();
                if (!ps.isSwimmerParticipating(swimmerName)) {
                    new ErrorWindow();
                    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                } else {
                    ArrayList<String> events = ps.lookupSwimmersEvents(swimmerName);
                    String toAdd = String.join(", ", events);
                    blankLabel.setText("Swimmer's events are: " + toAdd);
                }

            }

        });
    }

    // EFFECTS: initializes the JPanel
    private void initializePanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        window.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
    }

    // EFFECTS: initialize the main window with a title, close behaviour, size, and
    // location on screen
    private void initializeWindow() {
        window.setVisible(true);
        window.setTitle("Swimmer Lookup");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(325, 100);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}
