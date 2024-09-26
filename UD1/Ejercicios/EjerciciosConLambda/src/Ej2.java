//2. Filtrado de lista con funciones lambda: Crea una lista de Strings que contenga varios
//nombres. Luego, utiliza una función lambda para filtrar esta lista y crear una nueva lista
//que solo contenga los nombres que comienzan con una letra específica (por ejemplo,
//"A"). Para hacer esto, puedes utilizar el método “removeIf()” de “ArrayList”, que toma un
//“Predicate” (que es una interfaz funcional que puedes implementar con una función
//lambda).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej2 {
    public static void main(String[] args) {
        List<String> listaNombres = new ArrayList<>(Arrays.asList("Juan", "Manue", "Antonio", "Pablo", "Mario", "Diego", "Ana", "Ana"));
        List<String> listaSinNombresConLetra = new ArrayList<>(listaNombres);

        listaSinNombresConLetra.removeIf(s -> !s.startsWith("A"));

        System.out.println(listaNombres);
        System.out.println(listaSinNombresConLetra);
    }
}
