package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CreateCustomerPanel extends JPanel {
    public CreateCustomerPanel(MainWindow mainWindow) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create Customer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Name:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Register Date:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Initial Balance:"));
        formPanel.add(new JTextField());

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Add customer creation logic here
            mainWindow.showPanel("StartPanel");
        });

        formPanel.add(submitButton);
        add(formPanel, BorderLayout.CENTER);
    }
}
