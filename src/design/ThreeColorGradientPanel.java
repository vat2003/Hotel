/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design;

/**
 *
 * @author Acer
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeColorGradientPanel extends JPanel {

    private Color color1;
    private Color color2;
    private Color color3;

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

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    public ThreeColorGradientPanel() {
        color1 = new Color(51, 51, 255);
        color2 = new Color(0, 255, 204);
        color3 = new Color(255, 51, 51);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo mảng điểm, ở đây có 3 điểm tạo pha màu giữa 3 màu
        float[] fractions = {0.0f, 0.5f, 1.0f};
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(getWidth(), getHeight());
        Point2D[] points = {start, new Point2D.Float(getWidth() / 2, getHeight() / 2), end};

        // Tạo mảng màu tương ứng với mảng điểm
        Color[] colors = {getColor1(), getColor2(), getColor3()};

        // Tạo đối tượng MultipleGradientPaint với 3 điểm và 3 màu
        Paint paint = new LinearGradientPaint(start, end, fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        // Đặt đối tượng Paint làm màu nền của JPanel
        g2d.setPaint(paint);

        // Vẽ đối tượng của JPanel với đối tượng Paint
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
