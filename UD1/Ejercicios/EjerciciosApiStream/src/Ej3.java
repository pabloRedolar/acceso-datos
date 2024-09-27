//  Transformar una lista de números: Crea una lista de números enteros. Utiliza una
// “Function” para transformar cada número en la lista a su cubo.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej3 {
    public static void main(String[] args) {
        List<Integer> listaEnteros = new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,9,10));

        listaEnteros.forEach(num -> System.out.println(num * num));
    }
}
