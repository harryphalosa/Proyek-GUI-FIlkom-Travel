package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class TopUpPanel extends JPanel {
    public TopUpPanel(MainWindow mainWindow) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Top Up Balance", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Amount:"));
        formPanel.add(new JTextField());

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Add top-up logic here
            mainWindow.showPanel("StartPanel");
        });

        formPanel.add(submitButton);
        add(formPanel, BorderLayout.CENTER);
    }
}
