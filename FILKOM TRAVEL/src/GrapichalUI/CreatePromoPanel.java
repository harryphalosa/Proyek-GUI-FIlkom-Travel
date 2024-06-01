package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CreatePromoPanel extends JPanel {
    public CreatePromoPanel(MainWindow mainWindow) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Create Promotion", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.add(new JLabel("Promo Code:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Start Date:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("End Date:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Percent Off:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Max Discount:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Min Purchase:"));
        formPanel.add(new JTextField());

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Add promotion creation logic here
            mainWindow.showPanel("StartPanel");
        });

        formPanel.add(submitButton);
        add(formPanel, BorderLayout.CENTER);
        formPanel.setVisible(true);
    }
}
