package src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    public MainScreen() {
        // Configure o fundo
        getContentPane().setBackground(new Color(0, 0, 139)); // Azul escuro
        setLayout(null);

        // Título
        JLabel titleLabel = new JLabel("SELECIONE UMA OPÇÃO");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBounds(275, 20, 300, 30);
        add(titleLabel);

        // Botões
        String[] buttonLabels = {
            "CADASTRAR ALUNO NO SISTEMA",
            "ADICIONAR NOTAS PARA ALUNOS",
            "ATUALIZAR NOTAS REGISTRADAS OU APAGAR",
            "VERIFICAR NOTAS DE ALUNOS",
            "SAIR DO PROGRAMA"
        };

        int yPosition = 80;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            CustomComponents.styleButton(button);
            button.setBounds(250, yPosition, 300, 40);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(e);
                }
            });
            add(button);
            yPosition += 60;
        }

        // Centralizar a janela
        setLocationRelativeTo(null);
    }

    private void handleButtonClick(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "CADASTRAR ALUNO NO SISTEMA":
                // Implementar ação para cadastrar aluno
                break;
            case "ADICIONAR NOTAS PARA ALUNOS":
                // Implementar ação para adicionar notas
                break;
            case "ATUALIZAR NOTAS REGISTRADAS OU APAGAR":
                // Implementar ação para atualizar ou apagar notas
                break;
            case "VERIFICAR NOTAS DE ALUNOS":
                // Implementar ação para verificar notas
                break;
            case "SAIR DO PROGRAMA":
                System.exit(0);
                break;
        }
    }
}
