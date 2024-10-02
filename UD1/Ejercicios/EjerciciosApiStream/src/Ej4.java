// Generar una secuencia de números aleatorios: Utiliza un “Supplier” para generar e
// imprimir una secuencia de diez números aleatorios.

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ej4 {
    public static void main(String[] args) {

//        List<Integer> listaInteger = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        Random random = new Random();
//        listaInteger.forEach(integer -> System.out.println(random.nextInt(0,100)));


        // Crear una instancia de Random
        Random random = new Random();

        // Crear un Supplier que genera un número aleatorio
        Supplier<Integer> randomSupplier = () -> random.nextInt(100); // Números entre 0 y 99

        // Generar y mostrar 10 números aleatorios usando Stream
        Stream.generate(randomSupplier).limit(10) // Limitar a 10 números
                .forEach(System.out::println); // Imprimir cada número

    }
}
