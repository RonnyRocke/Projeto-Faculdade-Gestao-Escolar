package src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;
    private UserManager userManager;

    public LoginScreen() {
        // Configure o gerenciador de usuários
        userManager = new UserManager("users.txt");

        // Configure o fundo
        getContentPane().setBackground(new Color(0, 0, 139)); // Azul escuro
        setLayout(null);

        // Carregar e redimensionar a imagem da logo
        BufferedImage logoImage = null;
        try {
            logoImage = ImageIO.read(new File("resources/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Image scaledLogoImage = logoImage.getScaledInstance(160,125, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogoImage));
        logoLabel.setBounds(230, 5, 150, 130);
        add(logoLabel);

        // Campo de login
        JLabel usernameLabel = new JLabel("Login:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(150, 120, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField(20);
        CustomComponents.styleTextField(usernameField);
        usernameField.setBounds(230, 120, 160, 25);
        add(usernameField);

        // Campo de senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(150, 160, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        CustomComponents.stylePasswordField(passwordField);
        passwordField.setBounds(230, 160, 160, 25);
        add(passwordField);

        // Botão de cadastro
        JButton registerButton = new JButton("Cadastrar");
        CustomComponents.styleButton(registerButton);
        registerButton.setBounds(150, 200, 120, 25);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        add(registerButton);

        // Botão de login
        JButton loginButton = new JButton("Login");
        CustomComponents.styleButton(loginButton);
        loginButton.setBounds(270, 200, 120, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        add(loginButton);

        // Mensagem
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(150, 240, 300, 25);
        add(messageLabel);

        // Desenvolvedores
        JLabel developersLabel = new JLabel("Desenvolvedores: Ronald Soares - Guilherme - Gabriel");
        developersLabel.setForeground(Color.WHITE);
        developersLabel.setBounds(100, 300, 400, 25);
        add(developersLabel);

        // Centralizar a janela
        setLocationRelativeTo(null);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userManager.userExists(username)) {
            messageLabel.setText("Usuário já existe!");
        } else {
            userManager.addUser(username, password);
            messageLabel.setText("Usuário cadastrado com sucesso!");
        }
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userManager.validateUser(username, password)) {
            messageLabel.setText("Login bem-sucedido!");
            // Transição para a MainScreen
            JFrame mainScreen = new MainScreen();
            mainScreen.setTitle("Sistema de Gerenciamento de Alunos");
            mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainScreen.setSize(800, 600);
            mainScreen.setLocationRelativeTo(null); // Centraliza a janela
            mainScreen.setVisible(true);
            this.dispose(); // Fechar a tela de login
        } else {
            messageLabel.setText("Usuário ou senha inválidos!");
        }
    }
}
