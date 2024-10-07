package servicio;

import modelo.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

//CRUD
public class UsuarioServicio {
    private static final Logger logger = LogManager.getLogger(UsuarioServicio.class);
    private Map<Integer, Usuario> tablaUsuario = new HashMap<>();

    //Create
    public void crearUsuario(int id, String nombre, String correo){
        logger.trace("Entramos en le metodo crearUsuario ************************");
        if (tablaUsuario.containsKey(id)){
            logger.warn("Usuario con Id: {} ya existe", id);
            return;
        }
        Usuario usuario = Usuario.builder().nombre(nombre).email(correo).id(id).build();
        tablaUsuario.put(id, usuario);

        logger.info("Usuario creado: {}", usuario);

        logger.trace("Salimos del metodo crearUsuario *********************");
    }

    //read
    public Usuario getUsuario (int id){
        logger.trace("Entramos en getUser *************************");
        Usuario usuario = tablaUsuario.get(id);
        if (usuario == null){
            logger.error("Usuario con id: {} no encontrado", id);
        } else
            logger.trace("Usuario encontrado {}", usuario);

        logger.trace("Salimos de getUser *************************");
        return usuario;
    }

    //update

    public void updateUsuario(int id, String nombre, String correo){
        logger.trace("Entramos en le metodo updateUsuario ************************");

        Usuario usuarioId = tablaUsuario.get(id);
        if (usuarioId == null){
            logger.warn("Usuario con Id: {} no existe", id);
            logger.trace("Salimos de updateUser *************************");
            return;
        }

        tablaUsuario.put(id, Usuario.builder().id(id).email(correo).nombre(nombre).build());
        logger.info("Usuario updateado: {}", tablaUsuario.get(id));

        logger.trace("Salimos de updateUser *************************");
    }

    public void deleteUsuario(int id){
        logger.trace("Entramos en deleteUser ********************");

        Usuario usuario = tablaUsuario.remove(id);
        if (usuario == null){
            logger.error("Usuario con id: {} no encontrado", id);
        } else
            logger.info("Usuario con id: {} eliminado", usuario);

        logger.trace("Salimos de deleteUser ********************");
    }
}
