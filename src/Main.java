import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        List<Usuario> usuarios = new ArrayList<>();
        List<Musica> catalogoMusica = new ArrayList<>();
        List<Podcast> catalogoPodcast = new ArrayList<>();


        System.out.println("MENU PRINCIPAL");
        do {
            System.out.println("1. Criar conta\n2. Fazer login\n3. Explorar catálogo de mídias\n4. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome de usuário: ");
                    String newName = sc.nextLine();

                    System.out.println("Email de usuário: ");
                    String newEmail = sc.nextLine();

                    try {
                        if (newEmail == null || !newEmail.contains("@")) {
                            throw new IllegalArgumentException("E-mail inválido!");
                        }
                        usuarios.add(new Usuario(newName, newEmail));
                        System.out.println("Conta criada com sucesso!");
                    } catch (IllegalArgumentException e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("Digite seu email para realizar o login: ");
                    String loginEmail = sc.nextLine();
                    Usuario usuarioLogado = null;
                    boolean logged = false;

                    if (usuarios.isEmpty()){
                        System.out.println("Nenhum usuário cadastrado no sistema.");
                    }

                    for (Usuario user: usuarios){
                        if (user.getEmail().equalsIgnoreCase(loginEmail)){
                            usuarioLogado = user;
                            logged = true;
                            System.out.println("Login realizado com sucesso! Bem vindo, " + usuarioLogado.getName());
                        }
                    }

                    if (!logged){
                        System.out.println("Nenhum usuário encontrado com o endereço de email fornecido");
                        break;
                    }

                    int opcao_;

                    while (logged){
                        System.out.println("1. Criar Playlist\n2. Minhas Playlists\n3. Adicionar mídia à uma playlist\n4. Remover mídia de uma playlist\n5. Excluir Playlist\n6. Logout");
                        opcao_ = sc.nextInt();
                        sc.nextLine();

                        switch (opcao_){
                            case 1:
                                System.out.println("Digite o nome da nova playlist: ");
                                String nomePlaylist = sc.nextLine();

                                try {
                                    Playlist nova = new Playlist(nomePlaylist, usuarioLogado);
                                    usuarioLogado.adicionarPlaylist(nova);
                                    System.out.println("Playlist '" + nomePlaylist + "' criada com sucesso!");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Erro ao criar playlist: " + e.getMessage());
                                }
                                break;

                            case 2:
                                if (usuarioLogado.getPlaylist().isEmpty()){
                                    System.out.println("Usuário não tem nenhuma playlist criada");
                                }
                                int i = 1;
                                for (Playlist p : usuarioLogado.getPlaylist()){
                                    System.out.println(i + "- " + p.getNome());
                                    i++;
                                }
                                break;
                            case 3:
                                if (usuarioLogado.getPlaylist().isEmpty()){
                                    System.out.println("Você não tem nenhuma playlist criada.");
                                }
                                System.out.println("Escolha a playlist para adicionar a mídia:");
                                for (int ii = 0; ii < usuarioLogado.getPlaylist().size(); ii++) {
                                    System.out.println((ii + 1) + ". " + usuarioLogado.getPlaylist().get(ii).getNome());
                                }

                                int escolha = sc.nextInt();
                                sc.nextLine();
                                if (escolha < 1 || escolha > usuarioLogado.getPlaylist().size()) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                Playlist playlistEscolhida = usuarioLogado.getPlaylist().get(escolha - 1);

                                System.out.println("Título da mídia:");
                                String titulo = sc.nextLine();
                                System.out.println("Artista:");
                                String artista = sc.nextLine();
                                System.out.println("Duração (em minutos):");
                                double duracao = sc.nextDouble();
                                sc.nextLine();
                                System.out.println("Gênero de mídia\n1- Rock\n2- Funk\n3- Eletronica\n4- POP\n5- MPB\n6- Jazz\n7- Clássica");
                                int generoEscolhido = sc.nextInt();
                                Genero genero = null;

                                switch (generoEscolhido){
                                    case 1:
                                        genero = Genero.ROCK;
                                        break;
                                    case 2:
                                        genero = Genero.FUNK;
                                        break;
                                    case 3:
                                        genero = Genero.ELETRONICA;
                                        break;
                                    case 4:
                                        genero = Genero.POP;
                                        break;
                                    case 5:
                                        genero = Genero.MPB;
                                        break;
                                    case 6:
                                        genero = Genero.JAZZ;
                                        break;
                                    case 7:
                                        genero = Genero.CLASSICA;
                                        break;
                                    default:
                                        System.out.println("Insira uma opção válida");
                                        break;
                                }

                                System.out.println("Tipo de mídia\n1- Música\n2- Podcast");
                                int tipoMidia = sc.nextInt();

                                if (tipoMidia == 1){
                                    Musica novaMusica = new Musica(titulo, artista, duracao, genero);
                                    playlistEscolhida.adicionarMidia(novaMusica);
                                    catalogoMusica.add(novaMusica);
                                } else if (tipoMidia == 2) {
                                    Podcast novoPodcast = new Podcast(titulo, artista, duracao, genero);
                                    playlistEscolhida.adicionarMidia(novoPodcast);
                                    catalogoPodcast.add(novoPodcast);
                                }

                                break;

                            case 4:
                                if (usuarioLogado.getPlaylist().isEmpty()) {
                                    System.out.println("Você não tem nenhuma playlist.");
                                    break;
                                }

                                System.out.println("Escolha a playlist da qual deseja remover uma mídia:");
                                for (int iii = 0; iii < usuarioLogado.getPlaylist().size(); iii++) {
                                    System.out.println((iii + 1) + ". " + usuarioLogado.getPlaylist().get(iii).getNome());
                                }

                                int escolhaPlaylist = sc.nextInt();
                                sc.nextLine();
                                if (escolhaPlaylist < 1 || escolhaPlaylist > usuarioLogado.getPlaylist().size()) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                Playlist playlistParaRemoverMidia = usuarioLogado.getPlaylist().get(escolhaPlaylist - 1);

                                if (playlistParaRemoverMidia.getMidias().isEmpty()) {
                                    System.out.println("Essa playlist está vazia.");
                                    break;
                                }

                                System.out.println("Escolha a mídia que deseja remover:");
                                for (int iv = 0; iv < playlistParaRemoverMidia.getMidias().size(); iv++) {
                                    System.out.println((iv + 1) + ". " + playlistParaRemoverMidia.getMidias().get(iv).getTitulo());
                                }

                                int escolhaMidia = sc.nextInt();
                                sc.nextLine();
                                if (escolhaMidia < 1 || escolhaMidia > playlistParaRemoverMidia.getMidias().size()) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                Midia midiaParaRemover = playlistParaRemoverMidia.getMidias().get(escolhaMidia - 1);
                                playlistParaRemoverMidia.removerMidia(midiaParaRemover);
                                break;
                            case 5:
                                if (usuarioLogado.getPlaylist().isEmpty()) {
                                    System.out.println("Você não tem nenhuma playlist.");
                                    break;
                                }

                                System.out.println("Escolha a playlist que deseja excluir:");
                                for (int v = 0; v < usuarioLogado.getPlaylist().size(); v++) {
                                    System.out.println((v + 1) + ". " + usuarioLogado.getPlaylist().get(v).getNome());
                                }

                                int escolhaExcluir = sc.nextInt();
                                sc.nextLine();
                                if (escolhaExcluir < 1 || escolhaExcluir > usuarioLogado.getPlaylist().size()) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                Playlist playlistParaExcluir = usuarioLogado.getPlaylist().get(escolhaExcluir - 1);
                                usuarioLogado.getPlaylist().remove(playlistParaExcluir);
                                System.out.println("Playlist '" + playlistParaExcluir.getNome() + "' excluída com sucesso!");

                                break;
                            case 6:
                                logged = false;
                                break;
                            default:
                                System.out.println("Digite uma opção válida.");
                                break;
                    }}

                    break;
                case 3:
                    if (catalogoMusica.isEmpty() && catalogoPodcast.isEmpty()){
                        System.out.println("Nenhuma mídia disponível no sistema.");
                    } else {
                        System.out.println("Mostrar qual tipo de mídia:\n1-Músicas\n2-Podcasts");
                        int mostrarCatalogo = sc.nextInt();

                        switch (mostrarCatalogo){
                            case 1:
                                if (catalogoMusica.isEmpty()){
                                    System.out.println("Nenhuma música disponível no catálogo");
                                } else {
                                    System.out.println("Catálogo de mídias disponíveis:");
                                    for (Musica musicas : catalogoMusica) {
                                        musicas.exibirDetalhes();
                                    }
                                }
                                break;

                            case 2:
                                if (catalogoPodcast.isEmpty()){
                                    System.out.println("Nenhum podcast disponível no catálogo");
                                } else {
                                    System.out.println("Catálogo de mídias disponíveis:");
                                    for (Podcast podcast : catalogoPodcast) {
                                        podcast.exibirDetalhes();
                                    }
                                }
                                break;
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while(opcao != 4 );

        System.out.println("Sessão finalizada.");
    }
}