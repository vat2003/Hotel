/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class PanelOpacity extends JPanel {
//    setOpaque(false);
//
//        // Đặt màu nền với độ mờ 50%
//        Color abc = new Color(160, 160, 160, 160);
////Color a = new Color(203,203,249, 255);
//
//    setBackground(abc);

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f); // Đặt opacity ở đây
        g2d.setComposite(alpha);
        super.paintComponent(g2d);

        //g2.dispose();
    }
}
