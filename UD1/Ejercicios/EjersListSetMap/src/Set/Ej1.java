//Crear un Set de Strings y añadir elementos a él. Luego, imprimir todos los
//elementos del Set. ¿Qué observas acerca del orden de los elementos?

package Set;

import java.util.HashSet;
import java.util.Set;

public class Ej1 {
    public static void main(String[] args) {
        // Crear un Set de Strings
        Set<String> conjunto = new HashSet<>();

        // Añadir elementos al Set
        conjunto.add("Manzana");
        conjunto.add("Naranja");
        conjunto.add("Banana");
        conjunto.add("Uva");
        conjunto.add("Manzana"); // Duplicado, no se añadirá

        // Imprimir todos los elementos del Set
        for (String fruta : conjunto) {
            System.out.println(fruta);
        }
    }
}
