package Ej1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creación de los productos
        Producto producto1 = new Producto("1", "producto1", 2.5, false, 'A');
        Producto producto2 = new Producto("2", "producto2", 2.5, false, 'B');
        Producto producto3 = new Producto("3", "producto3", 2.5, false, 'C');
        Producto producto4 = new Producto("4", "producto4", 2.5, false, 'E');
        Producto producto5 = new Producto("5", "producto5", 2.5, false, 'F');

        List<Producto> listaProductos = Arrays.asList(producto1, producto2, producto3, producto4, producto5);

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("src/Ej1/productos.dat", "rw")) {
            for (Producto producto : listaProductos) {
                randomAccessFile.writeUTF(producto.getId());
                randomAccessFile.writeUTF(producto.getNombre());
                randomAccessFile.writeBoolean(producto.getDescuento());
                randomAccessFile.writeDouble(producto.getPrecio());
                randomAccessFile.writeChar(producto.getTipo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        leerArchivo("src/Ej1/productos.dat");
    }

    public static void leerArchivo(String archivoRuta) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(archivoRuta, "rw")) {
            Producto producto1 = new Producto("1", "producto1", 2.5, false, 'A');
            Producto producto2 = new Producto("2", "producto2", 2.5, false, 'B');
            Producto producto3 = new Producto("3", "producto3", 2.5, false, 'C');
            Producto producto4 = new Producto("4", "producto4", 2.5, false, 'E');
            Producto producto5 = new Producto("5", "producto5", 2.5, false, 'F');

            List<Producto> listaProductos = Arrays.asList(producto1, producto2, producto3, producto4, producto5);

            List<Producto> lista2 = new ArrayList<>();
            while (lista2.size() < listaProductos.size()){
                Producto producto = new Producto();
                producto.setId(randomAccessFile.readUTF());
                producto.setNombre(randomAccessFile.readUTF());
                producto.setPrecio(randomAccessFile.readDouble());
                producto.setDescuento(randomAccessFile.readBoolean());
                producto.setTipo(randomAccessFile.readChar());

                lista2.add(producto);
            }

            System.out.printf(lista2.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

