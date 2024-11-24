//Crear un Map que asocie nombres de países con sus capitales. Luego, imprimir
//todos los pares de clave-valor del Map.

package Map;

import java.util.HashMap;
import java.util.Map;

public class Ej1 {
    public static void main(String[] args) {
        // Crear un Map que asocie países con sus capitales
        Map<String, String> paisCapital = new HashMap<>();

        // Añadir países y sus capitales al Map
        paisCapital.put("España", "Madrid");
        paisCapital.put("Francia", "París");
        paisCapital.put("Italia", "Roma");
        paisCapital.put("Alemania", "Berlín");
        paisCapital.put("Argentina", "Buenos Aires");

        // Imprimir todos los pares de clave-valor del Map
        for (Map.Entry<String, String> entry : paisCapital.entrySet()) {
            System.out.println("País: " + entry.getKey() + " - Capital: " + entry.getValue());
        }
    }
}
