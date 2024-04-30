/*import java.util.Scanner;

public class tresenraya {
    public static void main(String[] args) {
        int turno = 0;
        int fila = 0;
        int columna = 0;
        int dimension = 0;

        System.out.println("Introduce la dimension del tablero");
        Scanner leer=new Scanner(System.in);
        dimension=leer.nextInt();

        char juego [][] = new char[dimension][dimension];

        do {
            rellenar(juego);
            introducir(turno, fila, columna, juego);
            turno++;
        } while (!ComprobarFilas(juego));
        System.out.println();
        rellenar(juego);
    }

    // Metodo para mostrar el tablero del juego
    public static void rellenar(char juego[][]) {
        for (int i = 0; i < juego.length; i++) {
            for (int j = 0; j < juego.length; j++) {
                if ((juego[i][j] == 'X') || (juego[i][j] == 'O')) {
                    System.out.print(juego[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Metodo introducir casillas en el tablero
    public static void introducir(int turno, int fila, int columna, char juego[][]) {
        Scanner leer = new Scanner(System.in);
        if (turno % 2 == 0) {
            System.out.println("Jugador 1 es tu turno");
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((juego[fila][columna] == 'X') || (juego[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir(turno, fila, columna, juego);
            } else {
                juego[fila][columna] = 'X';
            }
        } else {
            System.out.println("Jugador 2 es tu turno");
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((juego[fila][columna] == 'X') || (juego[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir(turno, fila, columna, juego);
            } else {
                juego[fila][columna] = 'O';
            }
        }
    }

    public static boolean Empate(int dimension, int turno) {
        // Mira el empate
        if (turno == dimension * dimension) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }
    public static boolean ComprobarFilas(char juego[][]){
        for (int i=0; i<juego.length; i++){
            int contX=0;
            int contO=0;
            for (int j=0; j<juego.length; j++){
                if (juego[i][j]=='X'){
                    contX++;
                }else if (juego[i][j]=='O'){
                    contO++;
                }
            }
            if (contO==juego.length){
                System.out.println("Jugador O gana!"); 
                return true;
            }else if (contX==juego.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    public static boolean ComprobarCol(char juego[][]){
        for (int i=0; i<juego.length; i++){
            int contX=0;
            int contO=0;
            for (int j=0; j<juego.length; j++){
                if (juego[j][i]=='X'){
                    contX++;
                }else if (juego[j][i]=='O'){
                    contO++;
                }
            }
            if (contO==juego.length){
                System.out.println("Jugador O gana!"); 
                return true;
            }else if (contX==juego.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    public static boolean ComprobarDiagonal(char juego[][]){
        for (int i=0; i<juego.length; i++){
            int contX=0;
            int contO=0;
            for (int j=0; j<juego.length; j++){
                if (juego[i+1][j+1]=='X'){
                    contX++;
                }else if (juego[i+1][j+1]=='O'){
                    contO++;
                }
            }
            if (contO==juego.length){
                System.out.println("Jugador O gana!"); 
                return true;
            }else if (contX==juego.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    
}
*/