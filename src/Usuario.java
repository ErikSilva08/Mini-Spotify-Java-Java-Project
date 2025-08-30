import java.util.ArrayList;

public class Usuario {
    private String name;
    private String email;
    private ArrayList<Playlist> playlist;

    public Usuario(String name, String email) {
        this.name = name;
        this.email = email;
        this.playlist = new ArrayList<Playlist>();
    }

    public Usuario(String name, String email, ArrayList<Playlist> playlist) {
        this.name = name;
        this.email = email;
        this.playlist = playlist != null ? playlist : new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void adicionarPlaylist(Playlist p) {
        playlist.add(p);
    }


}
