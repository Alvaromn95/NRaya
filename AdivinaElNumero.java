import java.util.Scanner;
import java.util.Random;

public class AdivinaElNumero extends Juegos {
    
        Random random = new Random();
        int numeroAdivinar = random.nextInt(100) + 1;
        Scanner leer = new Scanner(System.in);

        

        int intentos = 0;
        int num = 0;
        boolean terminarJuego = false;

    
        public void jugar(){
            System.out.println("¡Bienvenido al juego de adivinar el número!");
         System.out.println("Adivina un numero entre 1 y 100");
            System.out.print("Ingresa un numero del 1 al 100: ");
            num = leer.nextInt(); 
            intentos++;
            terminarJuego();

        }
        public boolean cambioJuego(){
            return terminarJuego;
        }
        public boolean terminarJuego(){ 
            if (num < numeroAdivinar) {
                System.out.println("Demasiado bajo. Intenta de nuevo.");
            } else if (num > numeroAdivinar) {
                System.out.println("Demasiado alto. Intenta de nuevo.");
            } else {
                System.out.println("¡Correcto! Adivinaste el número en " + intentos + " intentos.");
                
            terminarJuego= false;
            return true;

            }
            return false;
        }

    }

