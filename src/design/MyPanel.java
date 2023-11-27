/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design;

/**
 *
 * @author Acer
 */
import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
    private Image backgroundImage;
    String tenAnh;

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }
    
    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    
    
    public MyPanel() {
  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//       tenAnh = "nenXanh.jpg";
        backgroundImage = new ImageIcon("./src/img/"+tenAnh).getImage();
        // Draw background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}


//import java.awt.*;
//import javax.swing.*;
//
//public class MyPanel extends JPanel {
//    private Image backgroundImage;
//    private String imagePath;
//
//    public MyPanel(String imagePath) {
//        // Load background image
//        this.imagePath = imagePath;
//        backgroundImage = new ImageIcon(imagePath).getImage();
//    }
//
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//        backgroundImage = new ImageIcon(imagePath).getImage();
//        repaint(); // Refresh the panel
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        // Draw background image
//        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//    }
//}
