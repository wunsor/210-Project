package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Represents an Error Window for when errors occur
public class ErrorWindow {
    private JFrame window;
    private JPanel panel;
    private JLabel errorMessage;

    //EFFECTS: creates a new window to add a new swimmer
    public ErrorWindow() {
        window = new JFrame();
        initializeWindow();
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        errorMessage = new JLabel("Something Went Wrong Please Try Again!");

        window.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);

        panel.add(errorMessage);

    }

    //EFFECTS: initializes the window
    private void initializeWindow() {
        window.setVisible(true);
        window.setTitle("Error Message");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(275, 75);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}
