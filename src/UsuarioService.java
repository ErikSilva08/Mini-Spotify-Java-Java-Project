public class UsuarioService {
    public Usuario cadastrarUsuario(String name, String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        return new Usuario(name, email);
    }
}