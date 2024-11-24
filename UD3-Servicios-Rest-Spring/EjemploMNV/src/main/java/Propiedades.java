import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
    public static void main(String[] args) {
        escribe();


        Properties properties = new Properties();
        properties.setProperty("IP", "192.168.50.254");

        leer();
    }

    private static void leer() {
        try (FileReader reader = new FileReader("configuracion.properties")){
            Properties properties = new Properties();
            properties.load(reader);
            String ip = properties.getProperty("IP");
            String dns = properties.getProperty("dns", "8.8.8.8");

            System.out.println(ip + " " + dns);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribe() {
        try {
            FileWriter writer = new FileWriter("configuracion.properties");
            Properties properties = new Properties();

            properties.setProperty("IP", "192.168.50.254");
            properties.setProperty("puerto", "6060");
            properties.setProperty("user", "root");
            properties.setProperty("pass", "1234");

            properties.store(writer, "Propiedades para la app de OSIGAS.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
