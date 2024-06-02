package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    public StartPanel(MainWindow mainWindow) {
        setLayout(new GridLayout(0, 1));

        JButton createMemberButton = new JButton("Create Member");
        createMemberButton.addActionListener(e -> mainWindow.showPanel("CreateMemberPanel"));
        add(createMemberButton);

        JButton createGuestButton = new JButton("Create Guest");
        createGuestButton.addActionListener(e -> mainWindow.showPanel("CreateGuestPanel"));
        add(createGuestButton);

        JButton createMenuButton = new JButton("Create Menu");
        createMenuButton.addActionListener(e -> mainWindow.showPanel("CreateMenuPanel"));
        add(createMenuButton);

        JButton createPromoButton = new JButton("Create Promo");
        createPromoButton.addActionListener(e -> mainWindow.showPanel("CreatePromoPanel"));
        add(createPromoButton);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> mainWindow.showPanel("AddToCartPanel"));
        add(addToCartButton);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> mainWindow.showPanel("CheckoutPanel"));
        add(checkoutButton);

        JButton applyPromoButton = new JButton("Apply Promo");
        applyPromoButton.addActionListener(e -> mainWindow.showPanel("ApplyPromoPanel"));
        add(applyPromoButton);

        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.addActionListener(e -> mainWindow.showPanel("RemoveFromCartPanel"));
        add(removeFromCartButton);

        JButton topUpButton = new JButton("Top Up");
        topUpButton.addActionListener(e -> mainWindow.showPanel("TopUpPanel"));
        add(topUpButton);
    }
}
