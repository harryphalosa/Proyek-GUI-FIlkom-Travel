package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CheckoutPanel extends JPanel {
    public CheckoutPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Checkout", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel cartIdLabel = new JLabel("Cart ID:");
        cartIdLabel.setBounds(200, 100, 100, 30);
        add(cartIdLabel);

        JTextField cartIdField = new JTextField();
        cartIdField.setBounds(300, 100, 200, 30);
        add(cartIdField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 150, 100, 30);
        submitButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 150, 100, 30);
        backButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(backButton);
    }
}
