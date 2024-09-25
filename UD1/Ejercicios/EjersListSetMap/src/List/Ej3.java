//Dada una lista de Strings, escribir una función que devuelva la longitud del
//string más largo en la lista.

package List;

import java.util.Arrays;
import java.util.List;

public class Ej3 {
    public static void stringMasLargo(List<String> listaStrings) {

        for (String i : listaStrings) {
            System.out.println(i.length());

        }
    }

    public static void main(String[] args) {
        List<String> listaPalabra = Arrays.asList("Hola", "Diego", "Lula", "Lula", "Patata");
        stringMasLargo(listaPalabra);
    }
}
