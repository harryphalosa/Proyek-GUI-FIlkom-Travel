package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    public StartPanel(MainWindow mainWindow) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("FILKOM TRAVEL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton createCustomerButton = new JButton("Create Customer");
        JButton createMenuButton = new JButton("Create Menu");
        JButton createPromoButton = new JButton("Create Promo");
        JButton topUpButton = new JButton("Top Up");

        createCustomerButton.addActionListener(e -> mainWindow.showPanel("CreateCustomerPanel"));
        createMenuButton.addActionListener(e -> mainWindow.showPanel("CreateMenuPanel"));
        createPromoButton.addActionListener(e -> mainWindow.showPanel("CreatePromoPanel"));
        topUpButton.addActionListener(e -> mainWindow.showPanel("TopUpPanel"));

        buttonPanel.add(createCustomerButton);
        buttonPanel.add(createMenuButton);
        buttonPanel.add(createPromoButton);
        buttonPanel.add(topUpButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}
