package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class ApplyPromoPanel extends JPanel {
    public ApplyPromoPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Apply Promo", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel promoCodeLabel = new JLabel("Promo Code:");
        promoCodeLabel.setBounds(200, 100, 100, 30);
        add(promoCodeLabel);

        JTextField promoCodeField = new JTextField();
        promoCodeField.setBounds(300, 100, 200, 30);
        add(promoCodeField);

        JButton applyButton = new JButton("Apply");
        applyButton.setBounds(350, 150, 100, 30);
        applyButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(applyButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 150, 100, 30);
        backButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(backButton);
    }
}
