public class Avaliacao {
    private String nomeUsuario;
    private String sexo;
    private Filme filme;
    private int nota;
    private String comentario;

    public Avaliacao(String nomeUsuario, String sexo, Filme filme, int nota, String comentario) {
        this.nomeUsuario = nomeUsuario;
        this.sexo = sexo;
        this.filme = filme;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getNomeUsuario() { return nomeUsuario; }
    public String getSexo() { return sexo; }
    public Filme getFilme() { return filme; }
    public int getNota() { return nota; }
    public String getComentario() { return comentario; }
}