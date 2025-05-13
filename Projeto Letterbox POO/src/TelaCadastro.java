import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastro {
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private Filme minecraft = new Filme("Minecraft: O Filme");
    private Filme barbie = new Filme("Barbie Castelo Mágico");

    JFrame tela = new JFrame("Letterbox - Cadastro");
    JPanel painel = new JPanel();
    
    JLabel lbTitulo = new JLabel("Cadastro de Avaliação de Filmes");
    JLabel lbNome = new JLabel("Nome:");
    JLabel lbSexo = new JLabel("Sexo:");
    JLabel lbFilme = new JLabel("Filme:");
    JLabel lbNota = new JLabel("Nota (1-10):");
    JLabel lbComentario = new JLabel("Comentário:");
    
    JTextField txtNome = new JTextField();
    JComboBox<String> cbSexo = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
    JCheckBox cbMinecraft = new JCheckBox(minecraft.getTitulo());
    JCheckBox cbBarbie = new JCheckBox(barbie.getTitulo());
    JSpinner spNota = new JSpinner(new SpinnerNumberModel(5, 1, 10, 1));
    JTextArea taComentario = new JTextArea(5, 20);
    JScrollPane scrollComentario = new JScrollPane(taComentario);
    
    JButton btSalvar = new JButton("Salvar");
    JButton btExibir = new JButton("Exibir");

    public void criarTela() {
        tela.setSize(500, 420);
        tela.setLocationRelativeTo(null);
        painel.setLayout(null);
        
        lbTitulo.setBounds(120, 10, 250, 30);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        
        lbNome.setBounds(50, 60, 100, 20);
        txtNome.setBounds(150, 60, 200, 20);
        
        lbSexo.setBounds(50, 90, 100, 20);
        cbSexo.setBounds(150, 90, 200, 20);
        
        lbFilme.setBounds(50, 120, 100, 20);
        cbMinecraft.setBounds(150, 120, 200, 20);
        cbBarbie.setBounds(150, 140, 200, 20);
        
        ButtonGroup grupoFilmes = new ButtonGroup();
        grupoFilmes.add(cbMinecraft);
        grupoFilmes.add(cbBarbie);
        
        lbNota.setBounds(50, 170, 100, 20);
        spNota.setBounds(150, 170, 50, 20);
        
        lbComentario.setBounds(50, 200, 100, 20);
        scrollComentario.setBounds(150, 200, 250, 100);
        
        btSalvar.setBounds(120, 320, 100, 30);
        btExibir.setBounds(240, 320, 100, 30);
        
        painel.add(lbTitulo);
        painel.add(lbNome);
        painel.add(txtNome);
        painel.add(lbSexo);
        painel.add(cbSexo);
        painel.add(lbFilme);
        painel.add(cbMinecraft);
        painel.add(cbBarbie);
        painel.add(lbNota);
        painel.add(spNota);
        painel.add(lbComentario);
        painel.add(scrollComentario);
        painel.add(btSalvar);
        painel.add(btExibir);
        
        btSalvar.addActionListener(e -> salvarAvaliacao());
        btExibir.addActionListener(e -> exibirAvaliacoes());
        
        tela.add(painel);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void salvarAvaliacao() {
        String nome = txtNome.getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Informe seu nome.");
            return;
        }
        
        String sexo = (String) cbSexo.getSelectedItem();
        Filme filme = null;
        
        if (cbMinecraft.isSelected()) {
            filme = minecraft;
        } else if (cbBarbie.isSelected()) {
            filme = barbie;
        } else {
            JOptionPane.showMessageDialog(tela, "Selecione um filme.");
            return;
        }
        
        int nota = (int) spNota.getValue();
        String comentario = taComentario.getText();
        
        Avaliacao av = new Avaliacao(nome, sexo, filme, nota, comentario);
        avaliacoes.add(av);
        
        JOptionPane.showMessageDialog(tela, "Avaliação salva!");
        limparCampos();
    }
    
    private void limparCampos() {
        txtNome.setText("");
        cbSexo.setSelectedIndex(0);
        cbMinecraft.setSelected(false);
        cbBarbie.setSelected(false);
        spNota.setValue(5);
        taComentario.setText("");
    }
    
    private void exibirAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Nenhuma avaliação cadastrada.");
            return;
        }
        
        TelaExibicao telaExibicao = new TelaExibicao(avaliacoes);
        telaExibicao.criarTela();
    }
}