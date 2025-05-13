import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaExibicao {
    private List<Avaliacao> avaliacoes;
    
    JFrame tela = new JFrame("Letterbox - Avaliações");
    JPanel painel = new JPanel(new BorderLayout());
    JTable tabela;
    DefaultTableModel modelo;
    
    JButton btExcluir = new JButton("Excluir");
    JButton btVoltar = new JButton("Voltar");
    JPanel painelBotoes = new JPanel();
    
    public TelaExibicao(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    public void criarTela() {
        tela.setSize(600, 400);
        tela.setLocationRelativeTo(null);
        
        String[] colunas = {"Nome", "Sexo", "Filme", "Nota", "Comentário"};
        modelo = new DefaultTableModel(colunas, 0);
        
        for (Avaliacao av : avaliacoes) {
            Object[] linha = {
                av.getNomeUsuario(),
                av.getSexo(),
                av.getFilme().getTitulo(),
                av.getNota(),
                av.getComentario()
            };
            modelo.addRow(linha);
        }
        
        tabela = new JTable(modelo);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        painelBotoes.add(btExcluir);
        painelBotoes.add(btVoltar);
        
        btExcluir.addActionListener(e -> excluirAvaliacao());
        btVoltar.addActionListener(e -> tela.dispose());
        
        painel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);
        
        tela.add(painel);
        tela.setVisible(true);
    }
    
    private void excluirAvaliacao() {
        int linha = tabela.getSelectedRow();
        if (linha >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(tela, 
                "Deseja excluir esta avaliação?", "Confirmação", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirmar == JOptionPane.YES_OPTION) {
                avaliacoes.remove(linha);
                modelo.removeRow(linha);
                JOptionPane.showMessageDialog(tela, "Avaliação excluída!");
            }
        } else {
            JOptionPane.showMessageDialog(tela, "Selecione uma avaliação para excluir.");
        }
    }
}