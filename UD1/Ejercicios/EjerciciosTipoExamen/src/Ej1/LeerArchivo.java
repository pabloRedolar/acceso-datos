package Ej1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerArchivo {
    public static void main(String[] args) {
        try (RandomAccessFile archivo = new RandomAccessFile("productos.dat", "r")) {
            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();                        // Leer id
                String nombre = archivo.readUTF();                 // Leer nombre (10 caracteres)
                double precio = archivo.readDouble();              // Leer precio
                boolean descuento = archivo.readBoolean();         // Leer descuento
                char tipo = archivo.readChar();                    // Leer tipo

                // Mostrar el producto
                System.out.println("ID: " + id + ", Nombre: " + nombre.trim() + ", Precio: " + precio +
                        ", Descuento: " + descuento + ", Tipo: " + tipo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
