package GrapichalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends ImagePanel {
    public WelcomePanel(MainWindow mainWindow) {
        super("/GrapichalUI/SourcePicture/LOGOFILKOM.jpg"); // Pastikan path ke gambar benar

        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("FILKOM TRAVEL", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(Color.BLACK); // Warna teks agar terlihat pada background
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
