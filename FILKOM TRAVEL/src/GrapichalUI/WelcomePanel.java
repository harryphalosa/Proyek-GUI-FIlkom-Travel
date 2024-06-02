package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    public WelcomePanel(MainWindow mainWindow) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("FILKOM TRAVEL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(startButton, BorderLayout.SOUTH);
    }
}
