package Ej1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("1", "producto1", 2.5, false, 'A');
        Producto producto2 = new Producto("2", "producto2", 2.5, false, 'B');
        Producto producto3 = new Producto("3", "producto3", 2.5, false, 'C');
        Producto producto4 = new Producto("4", "producto4", 2.5, false, 'E');
        Producto producto5 = new Producto("5", "producto5", 2.5, false, 'F');

        List<Producto> listaProductos = Arrays.asList(producto1, producto2, producto3, producto4, producto5);

        listaProductos.forEach(System.out::println);
    }
}
