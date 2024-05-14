import java.util.Scanner;
import java.util.Random;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroAdivinar = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Adivina un numero entre 1 y 100");

        int intentos = 0;
        int num = 0;

        while (num != numeroAdivinar) {
            System.out.print("Ingresa tu adivinanza: ");
            num = scanner.nextInt(); 
            intentos++; 

            if (num < numeroAdivinar) {
                System.out.println("Demasiado bajo. Intenta de nuevo.");
            } else if (num > numeroAdivinar) {
                System.out.println("Demasiado alto. Intenta de nuevo.");
            } else {
                System.out.println("¡Correcto! Adivinaste el número en " + intentos + " intentos.");
            }
        }

    }
}
