package GrapichalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends ImagePanel {
    public WelcomePanel(MainWindow mainWindow) {
        super("background.jpg"); // Just specify the image file name

        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("FILKOM TRAVEL", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(Color.WHITE); // Set the text color to be visible on the background
        add(welcomeLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 24));
        add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.showPanel("StartPanel");
            }
        });
    }
}
