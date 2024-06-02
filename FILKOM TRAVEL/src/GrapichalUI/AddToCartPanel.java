package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class AddToCartPanel extends JPanel {
    public AddToCartPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Add to Cart", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel productIdLabel = new JLabel("Product ID:");
        productIdLabel.setBounds(200, 100, 100, 30);
        add(productIdLabel);

        JTextField productIdField = new JTextField();
        productIdField.setBounds(300, 100, 200, 30);
        add(productIdField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(200, 150, 100, 30);
        add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(300, 150, 200, 30);
        add(quantityField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(350, 200, 100, 30);
        addButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(addButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 200, 100, 30);
        backButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(backButton);
    }
}
