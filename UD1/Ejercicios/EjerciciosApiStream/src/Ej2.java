// Imprimir todos los elementos de una lista: Crea una lista de cadenas. Utiliza un
// “Consumer” para imprimir cada cadena en la lista.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej2 {
    public static void main(String[] args) {
        List<String> listaCadenas = new ArrayList<>(Arrays.asList("Diego", "Juan", "Manue", "Antonio", "Movil"));

        listaCadenas.forEach(palabra -> System.out.println(palabra));
    }
}
