import java.util.Scanner;
public class Tablero extends Juego{
    private int empate=0;
    protected char tablero[][];

    
    public Tablero(int dimension) {
        tablero = new char[dimension][dimension];
    }
    
    // Metodo para mostrar el tablero del juego
    public void rellenar() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if ((tablero[i][j] == 'X') || (tablero[i][j] == 'O')) {
                    System.out.print(tablero[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Metodo introducir casillas en el tablero
    public void introducir() {
        Scanner leer = new Scanner(System.in);
        int fila = 0, columna = 0;
        if (turno1==true){
            System.out.println("Jugador " + j1.getNombre() + "es tu turno ");
        }else{
            System.out.println("Jugador " + j2.getNombre() + "es tu turno ");
        }
        System.out.println("Introduce fila");
        fila = leer.nextInt();
        System.out.println("Introduce columna");
        columna = leer.nextInt();
        if ((tablero[fila][columna] == 'X') || (tablero[fila][columna] == 'O')) {
            System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
            introducir();
        } else {
            if (turno1==true){
                tablero[fila][columna] = j1.getFichas();
            }else{
                tablero[fila][columna] = j2.getFichas();
            }
            empate++;
        }
    }
    private boolean Empate() {
        if (empate == tablero.length * tablero.length) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }
    private boolean ComprobarFilas() {
        for (int i = 0; i < tablero.length; i++) {
            int contX = 0;
            int contO = 0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 'X') {
                    contX++;
                } else if (tablero[i][j] == 'O') {
                    contO++;
                }
            }
            if (contO == tablero.length) {
                System.out.println("Jugador O gana!");
                return true;
            } else if (contX == tablero.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    private boolean ComprobarCol() {
        for (int i = 0; i < tablero.length; i++) {
            int contX = 0;
            int contO = 0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i] == 'X') {
                    contX++;
                } else if (tablero[j][i] == 'O') {
                    contO++;
                }
            }
            if (contO == tablero.length) {
                System.out.println("Jugador O gana!");
                return true;
            } else if (contX == tablero.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    
    private boolean comprobarDiagonales() {
    int contXDiagonalPrincipal = 0;
    int contODiagonalPrincipal = 0;
    int contXDiagonalSecundaria = 0;
    int contODiagonalSecundaria = 0;
    int n = tablero.length;

    for (int i = 0; i < n; i++) {
        if (tablero[i][i] == 'X') {
            contXDiagonalPrincipal++;
        } else if (tablero[i][i] == 'O') {
            contODiagonalPrincipal++;
        }
        if (tablero[i][n - 1 - i] == 'X') {
            contXDiagonalSecundaria++;
        } else if (tablero[i][n - 1 - i] == 'O') {
            contODiagonalSecundaria++;
        }
    }

    if (contODiagonalPrincipal == n || contODiagonalSecundaria == n) {
        System.out.println("Jugador O gana!");
        return true;
    } else if (contXDiagonalPrincipal == n || contXDiagonalSecundaria == n) {
        System.out.println("Jugador X gana!");
        return true;
    }

    return false;
}
 
    public boolean Fin (){
        if(ComprobarCol()==true||ComprobarFilas()==true||Empate()==true){
            return true;
        }
        return false;
    }
}
