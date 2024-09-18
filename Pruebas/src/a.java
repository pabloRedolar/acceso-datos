import java.util.Arrays;
import java.util.List;

public class a {
    public static void main(String[] args) {
        List<String> mensajes = Arrays.asList("Hola","Buenas","Chao","Taluego");

        mensajes.forEach(System.out::println);
    }
}
