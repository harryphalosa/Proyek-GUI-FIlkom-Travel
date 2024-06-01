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

        // Add panels
        mainPanel.add(new WelcomePanel(this), "WelcomePanel");
        mainPanel.add(new StartPanel(this), "StartPanel");
        mainPanel.add(new CreateCustomerPanel(this), "CreateCustomerPanel");
        mainPanel.add(new CreateMenuPanel(this), "CreateMenuPanel");
        mainPanel.add(new CreatePromoPanel(this), "CreatePromoPanel");
        mainPanel.add(new TopUpPanel(this), "TopUpPanel");

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
