package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CreateMenuPanel extends JPanel {
    public CreateMenuPanel(MainWindow mainWindow) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Menu ID:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Menu Name:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Price:"));
        formPanel.add(new JTextField());

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Add menu creation logic here
            mainWindow.showPanel("StartPanel");
        });

        formPanel.add(submitButton);
        add(formPanel, BorderLayout.CENTER);
        formPanel.setVisible(true); 
    }
}
