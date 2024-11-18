package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// Represents and facilititates the Remove Swimmer function in the GUI
public class RemoveSwimmerWindow {
    private String swimmerToRemove;
    private MainWindow mainWindow;

    private JFrame window;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;

    //EFFECTS: creates a new window to remove a new swimmer
    public RemoveSwimmerWindow(MainWindow mw) {
        mainWindow = mw;
        window = new JFrame();
        initializeWindow();
        initializePanel();
        initializeLabelAndText();

    }

    //EFFECTS: initialize the label and text field
    private void initializeLabelAndText() {
        label = new JLabel("Swimmer's name to be removed:");
        textField = new JTextField();
        panel.add(label);
        panel.add(textField);
        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    swimmerToRemove = textField.getText();
                    updateMainWindow();
                } catch (Exception e1) {
                    new ErrorWindow();
                } finally {
                    window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                }
            }
            
        });
    }

    //MODIFIES: this
    //EFFECTS: updates ps in main window
    private void updateMainWindow() {
        mainWindow.getParticipatingSwimmers().removeSwimmer(swimmerToRemove);
    }

    //EFFECTS: initializes the window
    private void initializeWindow() {
        window.setVisible(true);
        window.setTitle("Remove Swimmer");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(250, 100);
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
