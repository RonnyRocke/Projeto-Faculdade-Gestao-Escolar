package src.main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new LoginScreen();
        frame.setTitle("Cadastro de Usuários");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }
}
