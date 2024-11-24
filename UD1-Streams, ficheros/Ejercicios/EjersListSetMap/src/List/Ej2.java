//Dada una lista de números enteros, escribir una función que devuelva una nueva
//lista que contenga solo los números pares de la lista original.

package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ej2 {
    public static List<Integer> obtenerPares(List<Integer> numeros){
        return numeros.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> paresList = obtenerPares(integerList);



//        for (int i : integerList) {
//            if (i % 2 == 0) {
//                paresList.add(i);
//            }
//        }

        //System.out.println(paresList);

        //Otra forma

        List<Integer> integerList2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> paresList2 = new ArrayList<>();

        integerList2.forEach(i -> {
            if (i % 2 == 0) {
                paresList2.add(i);
            }
        });

//        System.out.println(paresList2);
    }
}
