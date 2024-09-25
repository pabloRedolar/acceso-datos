// Crear una lista de Strings y añadir elementos a ella. Luego, imprimir todos
// los elementos de la lista usando un bucle for-each.

package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        StringBuilder hola = new StringBuilder();

        list.forEach(hola::append);

        System.out.println(hola);
    }
}
