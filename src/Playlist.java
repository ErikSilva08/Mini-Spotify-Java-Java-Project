import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private Usuario usuario;
    private List<Midia> midias;

    public Playlist(String nome, Usuario usuario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da playlist não pode ser vazio.");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("A playlist precisa ter um usuário dono.");
        }
        this.nome = nome;
        this.usuario = usuario;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da playlist não pode ser vazio.");
        }
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário dono não pode ser nulo.");
        }
        this.usuario = usuario;
    }

    public List<Midia> getMidias() {
        return new ArrayList<>(midias);
    }

    public void adicionarMidia(Midia m) {
        if (m == null) {
            throw new IllegalArgumentException("Mídia inválida.");
        }
        if (midias.contains(m)) {
            System.out.println("Essa mídia já está na playlist.");
            return;
        }
        midias.add(m);
        System.out.println("Mídia adicionada: " + m.getTitulo());
    }

    public void removerMidia(Midia m) {
        if (m == null) {
            throw new IllegalArgumentException("Mídia inválida.");
        }
        if (!midias.contains(m)) {
            System.out.println("Essa mídia não existe na playlist.");
            return;
        }
        midias.remove(m);
        System.out.println("Mídia removida: " + m.getTitulo());
    }

    public double calcularDuracaoTotal() {
        double total = 0;
        for (Midia m : midias) {
            total += m.getDuracao();
        }
        return total;
    }

    public void listarConteudos() {
        if (midias.isEmpty()) {
            System.out.println("A playlist está vazia.");
            return;
        }
        System.out.println("Conteúdo da playlist '" + nome + "':");
        for (Midia m : midias) {
            m.exibirDetalhes();
        }
    }
}
