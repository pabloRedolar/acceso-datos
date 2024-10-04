import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropiedadesXML {
    public static void main(String[] args) {
        escribe();
        leer();

        Properties properties = new Properties();
        properties.setProperty("IP", "192.168.50.254");
    }

    private static void leer() {
        try (FileInputStream reader = new FileInputStream("configuracion.properties")) {
            Properties properties = new Properties();
            properties.loadFromXML(reader);
            String ip = properties.getProperty("IP");
            String dns = properties.getProperty("dns", "8.8.8.8");

            System.out.println(ip + " " + dns);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribe() {
        try (FileOutputStream outputStream = new FileOutputStream("configuracion.xml")) {
            Properties properties = new Properties();

            properties.setProperty("IP", "192.168.50.254");
            properties.setProperty("puerto", "6060");
            properties.setProperty("user", "root");
            properties.setProperty("pass", "1234");

            properties.storeToXML(outputStream, "Propiedades para la app de OSIGAS.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
