import java.util.Scanner;

public class Juego {

    Juegos[] numeroJuegos;

    public void numeroJuegos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuantos juegos quieres jugar?");
        int num = leer.nextInt();
        numeroJuegos = new Juegos[num];

        for (int i = 0; i < numeroJuegos.length; i++) {
            System.out.println("Si introduce el numero 1,comenzara un juego de adivinar un numero aleatorio.Si introduces el numero 2,comenzará una partida de NenRaya");
            int numElegirJuego = leer.nextInt();
            if (numElegirJuego == 1) {
                numeroJuegos[i] = new AdivinaElNumero();
            } else if (numElegirJuego == 2) {
                System.out.println("Introduce el tamaño del tablero");
                int tamTab = leer.nextInt();              
                numeroJuegos[i] = new NRaya(tamTab);

        
        }
    }
}
    public void comenzarJuegos(){
        numeroJuegos();
        for (int i = 0; i < numeroJuegos.length; i++) {
            if(!numeroJuegos[i].cambioJuego()){
                numeroJuegos[i].jugar();
            }
            if(i==numeroJuegos.length-1 && !finalizarJuegos()){
                i=-1;
            }
    }
    }
    

    public boolean finalizarJuegos() {
        int cont = 0;
        for (int i = 0; i < numeroJuegos.length; i++) {
            if (numeroJuegos[i].terminarJuego()) {
                cont++;
            }
        }
        if (cont == numeroJuegos.length) {
            return true;
        }
        return false;
    }

}
