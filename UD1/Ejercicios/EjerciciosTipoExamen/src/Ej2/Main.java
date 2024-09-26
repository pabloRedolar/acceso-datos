package Ej2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String origen = "texto.txt";
        String archivoRemplazo = "textoNuevo.txt";
        String cadenaBuscar = "Mancha";
        String cadenaRemplazar = "teruel";

        buscarYremplazar(origen, archivoRemplazo, cadenaBuscar, cadenaRemplazar);

    }

    public static void buscarYremplazar(String archivoOrigen, String archivoRemplazo, String cadenaBuscada, String cadenaremplazo){
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOrigen));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRemplazo));
        ){
            String linea;
            while ((linea = reader.readLine()) != null) {
                String lineaModificada = null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
