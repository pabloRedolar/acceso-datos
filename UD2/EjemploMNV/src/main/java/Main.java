import Persona.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        Persona persona = Persona.builder().nombre("Juanma").apellidos("Moreno").edad(19).build();

        logger.debug("Prueba " + persona.getNombre());
        persona.setEdad(19);

        System.out.println(persona);
    }
}
