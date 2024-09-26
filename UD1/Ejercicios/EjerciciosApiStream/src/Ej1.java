// Filtrar números impares: Crea una lista de números enteros. Utiliza un “Predicate”
// para filtrar la lista y eliminar todos los números impares.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej1 {
    public static void main(String[] args) {
        List<Integer> listaEnteros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        listaEnteros.removeIf(integer -> integer % 2 != 0);
        System.out.println(listaEnteros);
    }
}
