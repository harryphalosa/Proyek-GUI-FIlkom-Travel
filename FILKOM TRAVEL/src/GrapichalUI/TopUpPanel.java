package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class TopUpPanel extends JPanel {
    public TopUpPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Top Up", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel accountIdLabel = new JLabel("Account ID:");
        accountIdLabel.setBounds(200, 100, 100, 30);
        add(accountIdLabel);

        JTextField accountIdField = new JTextField();
        accountIdField.setBounds(300, 100, 200, 30);
        add(accountIdField);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(200, 150, 100, 30);
        add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(300, 150, 200, 30);
        add(amountField);

        JButton topUpButton = new JButton("Top Up");
        topUpButton.setBounds(350, 200, 100, 30);
        topUpButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(topUpButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 200, 100, 30);
        backButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(backButton);
    }
}
