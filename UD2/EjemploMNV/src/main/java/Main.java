import Persona.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona = Persona.builder().nombre("Juanma").apellidos("Moreno").edad(19).build();
        System.out.println(persona);
    }
}
