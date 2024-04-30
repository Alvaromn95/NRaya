import java.util.Scanner;

public class Juego {
    // Declaracion de las variables y objetos
    Jugadores j1 = new Jugadores("", 'X');
    Jugadores j2 = new Jugadores("", 'O');
    Tablero [] numeroJuegos;

    private void numeroJuegos(){
        Scanner leer=new Scanner(System.in);
        System.out.println("Cuantos juegos quieres jugar?");
        int num = leer.nextInt();
        numeroJuegos = new Tablero[num];
        int cont=1;
        for (int i = 0; i < numeroJuegos.length; i++) {
            System.out.println("De cuanto quieres que sea el "+ cont + " tablero?");
            cont++;
            int numTab = leer.nextInt();
            numeroJuegos[i]=new Tablero(numTab);
            numeroJuegos[i].ElegirComiezo();
        }
    }

    private boolean finJuego(){
        int cont=0;
        for (int i = 0; i < numeroJuegos.length; i++){
            if(numeroJuegos[i].Fin()){
                cont++;
            }
        }
        if (cont==numeroJuegos.length){
            return true;
        }
        return false;
    }

    public void partida(){
        numeroJuegos();
        do{
            for (int i = 0; i < numeroJuegos.length; i++){
                numeroJuegos[i].rellenar();
                numeroJuegos[i].introducir();
                numeroJuegos[i].CambiarTurno();
            }
        }while (!finJuego());
    }
}