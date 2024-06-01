package GrapichalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends ImagePanel {
    public WelcomePanel(MainWindow mainWindow) {
        super("/GrapichalUI/SourcePicture/LOGOFILKOM.jpg"); // Pastikan path ke gambar benar

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar komponen

        // Tambahkan label "FILKOM TRAVEL"
        JLabel welcomeLabel = new JLabel("FILKOM TRAVEL", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 52));
        welcomeLabel.setForeground(Color.BLACK); // Warna teks agar terlihat pada background
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(welcomeLabel, gbc);

        // Tambahkan tombol "Start"
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran font lebih kecil
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(startButton, gbc);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.showPanel("StartPanel");
            }
        });
    }
}
