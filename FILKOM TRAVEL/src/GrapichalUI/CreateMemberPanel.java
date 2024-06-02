package GrapichalUI;

import javax.swing.*;
import java.awt.*;

public class CreateMemberPanel extends JPanel {
    public CreateMemberPanel(MainWindow mainWindow) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Create Member", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(200, 100, 100, 30);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(300, 100, 200, 30);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(200, 150, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(300, 150, 200, 30);
        add(nameField);

        JLabel dateLabel = new JLabel("Register Date:");
        dateLabel.setBounds(200, 200, 100, 30);
        add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(300, 200, 200, 30);
        add(dateField);

        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setBounds(200, 250, 100, 30);
        add(balanceLabel);

        JTextField balanceField = new JTextField();
        balanceField.setBounds(300, 250, 200, 30);
        add(balanceField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 300, 100, 30);
        submitButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 300, 100, 30);
        backButton.addActionListener(e -> mainWindow.showPanel("StartPanel"));
        add(backButton);
    }
}
