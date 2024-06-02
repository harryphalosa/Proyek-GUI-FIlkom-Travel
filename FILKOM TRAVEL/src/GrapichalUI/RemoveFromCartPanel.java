package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class RemoveFromCartPanel extends JPanel {
    public RemoveFromCartPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Remove from Cart", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel productIdLabel = new JLabel("Product ID:");
        productIdLabel.setBounds(200, 100, 100, 30);
        add(productIdLabel);

        JTextField productIdField = new JTextField();
        productIdField.setBounds(300, 100, 200, 30);
        add(productIdField);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(350, 150, 100, 30);
        removeButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(removeButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 150, 100, 30);
        backButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(backButton);
    }
}
