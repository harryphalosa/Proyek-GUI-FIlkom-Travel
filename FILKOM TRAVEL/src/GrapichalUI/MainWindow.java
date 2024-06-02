package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainWindow() {
        setTitle("FILKOM TRAVEL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Menambahkan panel
        mainPanel.add("WelcomePanel", new WelcomePanel(this));
        mainPanel.add("StartPanel", new StartPanel(this));
        mainPanel.add("CreateMemberPanel", new CreateMemberPanel(this));
        mainPanel.add("CreateGuestPanel", new CreateGuestPanel(this));
        mainPanel.add("CreateMenuPanel", new CreateMenuPanel(this));
        mainPanel.add("CreatePromoPanel", new CreatePromoPanel(this));
        mainPanel.add("AddToCartPanel", new AddToCartPanel(this));
        mainPanel.add("CheckoutPanel", new CheckoutPanel(this));
        mainPanel.add("ApplyPromoPanel", new ApplyPromoPanel(this));
        mainPanel.add("RemoveFromCartPanel", new RemoveFromCartPanel(this));
        mainPanel.add("TopUpPanel", new TopUpPanel(this));

        add(mainPanel);
        cardLayout.show(mainPanel, "WelcomePanel");
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
}
