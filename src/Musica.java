public class Musica extends Midia{
    public Musica(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }
    @Override
    public void exibirDetalhes(){
        System.out.println("-".repeat(40));
        System.out.println("🎶 Músicas 🎶");
        System.out.println("Título: " + titulo);
        System.out.println("Artista: " + artista);
        System.out.println("Duração: " + duracao);
        System.out.println("Gênero: " + genero);
        System.out.println("-".repeat(40));

    }
}
