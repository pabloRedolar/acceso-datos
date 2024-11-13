import lombok.extern.log4j.Log4j2;
import modelo.Usuario;
import servicio.UsuarioServicio;

@Log4j2

public class Main {
    public static void main(String[] args) {
        log.info("************ Comienza la App *************");

        UsuarioServicio usuarioServicio = new UsuarioServicio();

        usuarioServicio.crearUsuario(1, "Pablo", "pablo@gmail.com");
        usuarioServicio.crearUsuario(2, "Juan", "juan@gmail.com");
        usuarioServicio.crearUsuario(3, "Manue", "manue@gmail.com");

        usuarioServicio.getUsuario(1);
        usuarioServicio.getUsuario(2);
        usuarioServicio.getUsuario(3);

        usuarioServicio.updateUsuario(1, "Pedro leon", "pl@gmail.com");
        usuarioServicio.updateUsuario(4, "revienta", "eami@gjdl.com");

        usuarioServicio.deleteUsuario(3);
        usuarioServicio.deleteUsuario(5);

        Usuario usuario = usuarioServicio.getUsuario(1);
        log.info("Cambio en {}", usuario);
        log.info("****************** App finalizada ******************");
    }
}
