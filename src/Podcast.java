public class Podcast extends Midia{
    public Podcast(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }
    @Override
    public void exibirDetalhes(){
        System.out.println("-".repeat(40));
        System.out.println("🎧 Podcasts 🎧");
        System.out.println("Título: " + titulo);
        System.out.println("Apresentador: " + artista);
        System.out.println("Duração: " + duracao);
        System.out.println("Gênero: " + genero);
        System.out.println("-".repeat(40));

    }
}
