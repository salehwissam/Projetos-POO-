import javax.swing.*;
import java.awt.*;

public class TelaInicial {
    JFrame tela = new JFrame("Letterbox - Início");
    JPanel painel = new JPanel();
    JLabel lbTitulo = new JLabel("Bem-vindo ao sistema de cadastro de avaliações!");
    JButton btEntrar = new JButton("Entrar");

    public void criarTela() {
        tela.setSize(400, 250);
        tela.setLocationRelativeTo(null);
        painel.setLayout(null);

        lbTitulo.setBounds(30, 50, 350, 30);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        
        btEntrar.setBounds(140, 120, 100, 30);
        btEntrar.addActionListener(e -> {
            tela.dispose();
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.criarTela();
        });

        painel.add(lbTitulo);
        painel.add(btEntrar);
        tela.add(painel);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}