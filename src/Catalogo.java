import java.util.ArrayList;
import java.util.List;



public class Catalogo {
    private List<Midia> midias;

    public Catalogo(){
        this.midias = new ArrayList<>();
    }

    public void AdicionarMidia(Midia m){
         midias.add(m);
    }
    public Midia BuscarPorTitulo(String titulo) throws Exception {
       for (Midia m : midias) {
           if (m.getTitulo().equalsIgnoreCase(titulo))
               return m;
       }
        return null;
    }

    public List<Midia>buscarPorArtista(String artista) {
        List<Midia> resultado = new ArrayList<>();
        for (Midia m: midias) {
            if (m.getArtista().equalsIgnoreCase(artista)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
    public List<Midia>buscarPorGenero(Genero genero){
        List<Midia> resultado = new ArrayList<>();
        for (Midia m: midias){
            if (m.getGenero() == genero){
                resultado.add(m);
            }
        }
        return resultado;
    }

}
