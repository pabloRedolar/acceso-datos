//Dada una lista de Strings, escribir una función que devuelva la longitud del
//string más largo en la lista.

package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej3 {
    public static void stringMasLargo(List<String> listaStrings) {

        List<Integer> listaLongitud = new ArrayList<>();

        int varLongitud = 0;
        for (String i : listaStrings) {
            if (i.length() > varLongitud) {
                varLongitud = i.length();
            }
            listaLongitud.add(i.length());
        }

        System.out.println("La palabra mas larga es: " + listaStrings.get(listaLongitud.indexOf(varLongitud)) + " con " + varLongitud + " carácteres");
    }

    public static void main(String[] args) {
        List<String> listaPalabra = Arrays.asList("Hola", "Diego", "Lula", "Lula", "Patata", "Esternocleidomastoideo");
        stringMasLargo(listaPalabra);
    }
}
