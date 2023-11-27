/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import design.*;

/**
 *
 * @author Acer
 */
public class ValidationUtils {

    public static boolean checkisEmpty(MyTextField txt, String thongbao) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }

        return true;
    }

    public static boolean checkisEmpty(MyPasswordField txt, String thongbao) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }

        return true;
    }

    public static boolean checkisEmpty(MyTextField2 txt, String thongbao) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            txt.setLineColor(Color.RED);
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        } else {
            txt.setLineColor(new Color(3, 155, 216));
        }

        return true;
    }

    public static boolean checkisEmpty(MyPasswordField2 txt, String thongbao) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            txt.setLineColor(Color.RED);
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        } else {
            txt.setLineColor(new Color(3, 155, 216));
        }

        return true;
    }

    public static boolean checkisEmpty(JTextField txt, String thongbao) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }
        return true;
    }

    public static boolean checkisEmpty(JTextArea txt, String thongbao) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }
        return true;
    }

    public static boolean checkisEmpty(JDateChooser txt, String thongbao) {
        if (txt.getDate() == null) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }
        return true;
    }

    public static boolean checkMail(String mail) {
        boolean flag;
        String emailPattern = "\\w+@\\w+[.]\\w+([.]\\w+)?";
        flag = mail.matches(emailPattern);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "Nhập sai định dạng mail");
        }
        return flag;
    }

    public static boolean checkSdt(String sdt) {
        boolean flag;
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        flag = sdt.matches(reg);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "Nhập sai định dạng số điện thoại");
        }
        return flag;
    }

    public static boolean checkNgay(JDateChooser truoc, JDateChooser sau, String thongbao) {
        Date a = truoc.getDate();
        Date b = sau.getDate();
        if (a.compareTo(b) >= 0) {
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }
        return true;
    }

}
