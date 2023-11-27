/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ktn39
 */
public class msg {

    /**
     *
     * @param parent
     * @param message
     */
   public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, 
                "Hệ thống quản lý nhà trọ", 
                JOptionPane.INFORMATION_MESSAGE);
    }
   
   public static boolean confirm(Component parent, String mess){
       int rs = JOptionPane.showConfirmDialog(parent, mess,"Hệ thống quản lý nhà trọ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       return rs == JOptionPane.YES_OPTION;
   }
   
   public static String prompt(Component parent, String mess){
        return JOptionPane.showInputDialog(parent,mess, 
                "Hệ thống quản lý đào tạo", 
                JOptionPane.INFORMATION_MESSAGE);
    }
}
