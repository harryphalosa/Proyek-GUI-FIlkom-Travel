package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CreateMenuPanel extends JPanel {
    public CreateMenuPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Create Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel menuIdLabel = new JLabel("Menu ID:");
        menuIdLabel.setBounds(200, 100, 100, 30);
        add(menuIdLabel);

        JTextField menuIdField = new JTextField();
        menuIdField.setBounds(300, 100, 200, 30);
        add(menuIdField);

        JLabel menuNameLabel = new JLabel("Menu Name:");
        menuNameLabel.setBounds(200, 150, 100, 30);
        add(menuNameLabel);

        JTextField menuNameField = new JTextField();
        menuNameField.setBounds(300, 150, 200, 30);
        add(menuNameField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(200, 200, 100, 30);
        add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(300, 200, 200, 30);
        add(priceField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 250, 100, 30);
        submitButton.addActionListener(e -> {
            // Add menu creation logic here
            mainWindow.showPanel("StartPanel");
        });
        add(submitButton);
    }
}
