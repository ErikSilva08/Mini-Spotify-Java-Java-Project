public abstract class Midia {
    protected String titulo;
    protected String artista;
    protected double duracao;
    protected Genero genero;

    public Midia(String titulo, String artista, double duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public double getDuracao() {
        return duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public abstract void exibirDetalhes();
}