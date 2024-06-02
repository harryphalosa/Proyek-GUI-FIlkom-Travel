package GrapichalUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String fileName) {
        try {
            URL imageUrl = getClass().getResource(fileName);
            if (imageUrl == null) {
                System.out.println("Gambar tidak ditemukan: " + fileName);
            } else {
                backgroundImage = new ImageIcon(imageUrl).getImage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
