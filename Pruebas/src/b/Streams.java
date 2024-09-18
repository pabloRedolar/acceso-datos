package b;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        //Predicate

//        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
//        Predicate<Integer> esPar = n -> n % 2 == 0;
//
//        numeros.removeIf(esPar);
//
//        System.out.println(numeros);

        //Consumer

//        List<String> nombres = Arrays.asList("Manuel", "Juan", "Remon", "Pepe", "Carlos");
//        Consumer<String> mostrarNombres = s -> System.out.println(s);
//
//        nombres.forEach(mostrarNombres);

        //Suppliers

//        Supplier<Integer> aleatorio = () -> new Random().nextInt(1000);
//        for (int i = 0; i < 50; i++) {
//            System.out.println(aleatorio.get());
//        }

        //Functions

        List<Integer> numeros2 = Arrays.asList(8,15,25,3,50);
        Function<Integer, Integer> cuadrados = n -> n * n;

        List<Integer> numcuadrados = numeros2.stream().map(cuadrados).toList();
        System.out.println(numcuadrados);


    }
}
