import java.util.ArrayList;
import java.util.List;

public class ControlePlaylist {

    private List<Midia> playlist; // lista de mídias do usuário

    public ControlePlaylist() {
        playlist = new ArrayList<>(); // inicializa a lista vazia
    }

    public void criar(Midia m) {
        if (m == null) {
            System.out.println("Mídia inválida!");
            return;
        }
        playlist.add(m);
        System.out.println("Mídia adicionada: " + m.getTitulo());
    }

    public void visualizar() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist vazia");
            return;
        }
        System.out.println("Playlist:");
        for (Midia m : playlist) {
            System.out.println("Título: " + m.getTitulo());
            System.out.println("Artista/Autor: " + m.getArtista());
            System.out.println("Duração: " + m.getDuracao());
            System.out.println("Gênero: " + m.getGenero());
            System.out.println("------------------------------");
        }
    }

    public void remover(String titulo) {
        boolean achou = false;
        int i = 0;

        while (i < playlist.size()) {
            Midia m = playlist.get(i);
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                playlist.remove(i);
                achou = true;
                System.out.println("Mídia removida: " + titulo);
                break;
            }
            i++;
        }

        if (!achou) {
            System.out.println("Mídia não encontrada: " + titulo);
        }
    }
}
