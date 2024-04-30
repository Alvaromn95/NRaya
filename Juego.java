import java.util.Scanner;

public class Juego {

    /*Jugadores j1 = new Jugadores();
    Jugadores j2 = new Jugadores();
    Tablero[] numeroJuegos;
    String nombre;
    */
    //Jugadores [] arrayJugadores;

/* 
    private void cantJugadores (){
        Scanner leer=new Scanner(System.in);
        System.out.println("Cuantos jugadores van a jugar?");
        int num = leer.nextInt();
        arrayJugadores = new Jugadores[num];
        int cont=1;
        for (int i = 0; i < arrayJugadores.length; i++) {
            System.out.println("Jugador "+ cont + " ,introduzca su nombre");
            nombre = leer.next();
            System.out.println("Indique cual quiere que sea su ficha");
            ficha = leer.next().charAt(0);
            arrayJugadores[i] = new Jugadores (nombre, ficha);
            System.out.println("El jugador "+ cont + " es " + arrayJugadores[i].getNombre() + " y su ficha es " + arrayJugadores[i].getFichas());
            cont++;
        }
    }*/
    Tablero[] numeroJuegos;

    private void numeroJuegos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuantos juegos quieres jugar?");
        int num = leer.nextInt();
        numeroJuegos = new Tablero[num];
        int cont = 1;
        for (int i = 0; i < numeroJuegos.length; i++) {
            System.out.println("De cuanto quieres que sea el " + cont + " tablero?");
            cont++;
            int numTab = leer.nextInt();
            numeroJuegos[i] = new Tablero(numTab);
            numeroJuegos[i].ElegirComiezo();
        }
    }

    private boolean finJuego() {
        int cont = 0;
        for (int i = 0; i < numeroJuegos.length; i++) {
            if (numeroJuegos[i].Fin()) {
                cont++;
            }
        }
        if (cont == numeroJuegos.length) {
            return true;
        }
        return false;
    }

    public void partida() {
        numeroJuegos();
        do {
            for (int i = 0; i < numeroJuegos.length; i++) {
                numeroJuegos[i].rellenar();
                numeroJuegos[i].introducirFichas();
                numeroJuegos[i].CambiarTurno();
            }
        } while (!finJuego());
    }
}