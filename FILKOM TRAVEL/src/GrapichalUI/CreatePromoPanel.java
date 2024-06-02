package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CreatePromoPanel extends JPanel {
    public CreatePromoPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Create Promotion", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel promoCodeLabel = new JLabel("Promo Code:");
        promoCodeLabel.setBounds(200, 100, 100, 30);
        add(promoCodeLabel);

        JTextField promoCodeField = new JTextField();
        promoCodeField.setBounds(300, 100, 200, 30);
        add(promoCodeField);

        JLabel startDateLabel = new JLabel("Start Date:");
        startDateLabel.setBounds(200, 150, 100, 30);
        add(startDateLabel);

        JTextField startDateField = new JTextField();
        startDateField.setBounds(300, 150, 200, 30);
        add(startDateField);

        JLabel endDateLabel = new JLabel("End Date:");
        endDateLabel.setBounds(200, 200, 100, 30);
        add(endDateLabel);

        JTextField endDateField = new JTextField();
        endDateField.setBounds(300, 200, 200, 30);
        add(endDateField);

        JLabel percentOffLabel = new JLabel("Percent Off:");
        percentOffLabel.setBounds(200, 250, 100, 30);
        add(percentOffLabel);

        JTextField percentOffField = new JTextField();
        percentOffField.setBounds(300, 250, 200, 30);
        add(percentOffField);

        JLabel maxDiscountLabel = new JLabel("Max Discount:");
        maxDiscountLabel.setBounds(200, 300, 100, 30);
        add(maxDiscountLabel);

        JTextField maxDiscountField = new JTextField();
        maxDiscountField.setBounds(300, 300, 200, 30);
        add(maxDiscountField);

        JLabel minPurchaseLabel = new JLabel("Min Purchase:");
        minPurchaseLabel.setBounds(200, 350, 100, 30);
        add(minPurchaseLabel);

        JTextField minPurchaseField = new JTextField();
        minPurchaseField.setBounds(300, 350, 200, 30);
        add(minPurchaseField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 400, 100, 30);
        submitButton.addActionListener(e -> {
            // Add promotion creation logic here
            mainWindow.showPanel("StartPanel");
        });
        add(submitButton);
    }
}
