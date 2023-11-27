package design;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

    private Color color1;
    private Color color2;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public GradientPanel() {
        color1 = new Color(51,51,255);
        color2 = new Color(0,255,204);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo GradientPaint object với hai điểm
        GradientPaint gradient = new GradientPaint(0, 0, getColor1(), getWidth(), getHeight(), getColor2());
        GradientPaint gradient2 = new GradientPaint(0, 0, getColor1(), getWidth(), getHeight(), getColor2(), false);

        // Đặt GradientPaint làm màu nền của JPanel
        g2d.setPaint(gradient2);

        // Vẽ đối tượng của JPanel với GradientPaint
        g2d.fillRect(0, 0, getWidth(), getHeight());
//         g2d.draw(new Rectangle(20,20,200,200)); //Tạo viền hình chữ nhật
    }

}
