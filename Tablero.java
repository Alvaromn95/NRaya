import java.util.Scanner;

public class Tablero extends Juego {
    private int empate = 0;
    protected char tablero[][];
    protected boolean turno1;
    protected boolean turno2;
    String nom1;
    String nom2;

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
        if (turno1 == true) {
            System.out.println("Jugador " + nom1 + " es tu turno ");
        } else {
            System.out.println("Jugador " + nom2 + " es tu turno ");
        }
        System.out.println("Introduce fila");
        fila = leer.nextInt();
        System.out.println("Introduce columna");
        columna = leer.nextInt();
        if ((tablero[fila][columna] == 'X') || (tablero[fila][columna] == 'O')) {
            System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
            introducir();
        } else {
            if (turno1 == true) {
                tablero[fila][columna] = j1.getFichas();
            } else {
                tablero[fila][columna] = j2.getFichas();
            }
            empate++;
        }
    }

    // Metodo para cambiar de turno
    public boolean CambiarTurno() {
        if (turno1 == false) {
            turno1 = true;
            turno2 = false;
        } else {
            turno1 = false;
            turno2 = true;
        }
        return turno1;
    }

    // Metodo para elegir quien empieza
    public boolean ElegirComiezo() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Jugador 1,introduzca su nombre");
        
        nom1=leer.next();
        System.out.println("El jugador 1 es " + nom1);
        System.out.println("Jugador 2,introduzca su nombre");
      
        nom2=leer.next();
        System.out.println("El jugador 2 es " + nom2);
        System.out.println("Quien quiere comenzar,el 1 o el 2?");
        int num = leer.nextInt();
        if (num > 2) {
            System.out.println("Error, introduce un numero entre 1 y 2");
            ElegirComiezo();
        } else {
            if (num == 1) {
                turno1 = true;
                turno2 = false;
                return turno1;
            } else {
                turno2 = true;
                turno1 = false;
                return turno2;
            }
        }
        return false;
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

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == 'X') {
                contXDiagonalPrincipal++;
            } else if (tablero[i][i] == 'O') {
                contODiagonalPrincipal++;
            }
            if (tablero[i][tablero.length - 1 - i] == 'X') {
                contXDiagonalSecundaria++;
            } else if (tablero[i][tablero.length - 1 - i] == 'O') {
                contODiagonalSecundaria++;
            }
        }

        if (contODiagonalPrincipal == tablero.length || contODiagonalSecundaria == tablero.length) {
            System.out.println("Jugador O gana!");
            return true;
        } else if (contXDiagonalPrincipal == tablero.length || contXDiagonalSecundaria == tablero.length) {
            System.out.println("Jugador X gana!");
            return true;
        }

        return false;
    }

    public boolean Fin() {
        if (ComprobarCol() == true || ComprobarFilas() == true || Empate() == true || comprobarDiagonales() == true) {
            return true;
        }
        return false;
    }
}
