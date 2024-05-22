package src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomComponents {
    public static void styleButton(JButton button) {
        button.setBackground(new Color(30, 144, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255));
            }
        });
    }

    public static void styleTextField(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }

    public static void stylePasswordField(JPasswordField passwordField) {
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 2));
        passwordField.setBackground(Color.WHITE);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }
}
