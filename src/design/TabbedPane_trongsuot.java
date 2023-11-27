/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Acer
 */
public class TabbedPane_trongsuot extends JTabbedPane {

    public TabbedPane_trongsuot() {


        for (int i = 0; i < this.getTabCount(); i++) {
            this.setTabComponentAt(i, new JLabel("  " + this.getTitleAt(i)));
            this.setBackgroundAt(i, new Color(0, 0, 0, 0));
        }

        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        g2.setColor(getBackground());
        Rectangle r = getBounds();
        g2.fillRect(0, 0, r.width, r.height);
        super.paintComponent(g2);
        g2.dispose();
    }

}
