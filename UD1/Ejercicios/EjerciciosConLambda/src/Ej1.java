//1. Calculadora con funciones lambda: Crea una interfaz funcional “Calculator” con un
//método “calculate()”. Este método debe tomar dos números enteros y devolver un
//número entero. Luego, en tu método “main()”, crea varias instancias de “Calculator”
//utilizando funciones lambda para implementar operaciones como suma, resta,
//multiplicación y división. Finalmente, prueba tus calculadoras con algunos números.

public class Ej1 {
    public interface Calculator {
        int calculate(int num1, int num2);
    }

    public static void main(String[] args) {
        Calculator suma = (num1, num2) -> num1 + num2;
        Calculator resta = (num1, num2) -> num1 - num2;
        Calculator multiplicacion = (num1, num2) -> num1 * num2;
        Calculator division = (num1, num2) -> num1 / num2;

        int num1 = 10;
        int num2 = 2;

        System.out.println(suma.calculate(num1, num2));
        System.out.println(resta.calculate(num1, num2));
        System.out.println(multiplicacion.calculate(num1, num2));
        System.out.println(division.calculate(num1, num2));

    }
}
