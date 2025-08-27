import java.util.ArrayList;

public class Usuario {
    private String name;
    private String email;
    private ArrayList playlist;

    public Usuario(String name, String email) {
    }

    public Usuario(String name, String email, ArrayList playlist) {
        this.name = name;
        this.email = email;
        this.playlist = playlist;
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

    public ArrayList getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList playlist) {
        this.playlist = playlist;
    }


}
