package ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment for consol based UI
        // new SwimMeetOrganizerApp();

        // GUI comment below for consol based UI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
