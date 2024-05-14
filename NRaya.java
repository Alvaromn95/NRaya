import java.util.Scanner;

public class NRaya extends Juegos {
    private int empate = 0;
    protected char tablero[][];
    String nom1;
    String nom2;
    char ficha1;
    char ficha2;
    protected boolean turno1;
    protected boolean turno2;
    boolean terminarJuego = false;
    
    public NRaya(int tamTab){
        tablero = new char[tamTab][tamTab];
    }

    public void rellenar() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if ((tablero[i][j] == ficha1) || (tablero[i][j] == ficha2)) {
                    System.out.print(tablero[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void introducirFichas() { 
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
        if ((tablero[fila][columna] == ficha1) || (tablero[fila][columna] == ficha2)) {
            System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
            introducirFichas();
        } else {
            if (turno1 == true) {
                tablero[fila][columna] = ficha1;
            } else {
                tablero[fila][columna] = ficha2;
            }
            empate++;
        }
    }

    public boolean ElegirComiezo() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Jugador 1,introduzca su nombre");

        nom1 = leer.next();

        System.out.println("Indique cual quiere que sea su ficha");
        ficha1 = leer.next().charAt(0);
        System.out.println("El jugador 1 es " + nom1 + " y su ficha es " + ficha1);
        System.out.println("Jugador 2,introduzca su nombre");

        nom2 = leer.next();

        System.out.println("Indique cual quiere que sea su ficha");
        ficha2 = leer.next().charAt(0);
        System.out.println("El jugador 1 es " + nom2 + " y su ficha es " + ficha2);
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

    

    public boolean ComprobarFilas() {
        for (int i = 0; i < tablero.length; i++) {
            int contFicha1 = 0;
            int contFicha2 = 0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == ficha1) {
                    contFicha1++;
                } else if (tablero[i][j] == ficha2) {
                    contFicha2++;
                }
            }
            if (contFicha2 == tablero.length) {
                System.out.println(nom2 + "ha ganado");
                return true;
            } else if (contFicha1 == tablero.length) {
                System.out.println(nom1 + " ha ganado");
                return true;
            }
        }
        return false;
    }

    public boolean ComprobarCol() {
        for (int i = 0; i < tablero.length; i++) {
            int contFicha1 = 0;
            int contFicha2 = 0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i] == ficha1) {
                    contFicha1++;
                } else if (tablero[j][i] == ficha2) {
                    contFicha2++;
                }
            }
            if (contFicha2 == tablero.length) {
                System.out.println(nom2 + " ha ganado");
                return true;
            } else if (contFicha1 == tablero.length) {
                System.out.println(nom1 + " ha ganado");
                return true;
            }
        }
        return false;
    }

    public boolean comprobarDiagonales() {
        int contFicha1DiagonalPrincipal = 0;
        int contFicha2DiagonalPrincipal = 0;
        int contFicha1DiagonalSecundaria = 0;
        int contFicha2DiagonalSecundaria = 0;

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i] == ficha1) {
                contFicha1DiagonalPrincipal++;
            } else if (tablero[i][i] == ficha2) {
                contFicha2DiagonalPrincipal++;
            }
            if (tablero[i][tablero.length - 1 - i] == ficha1) {
                contFicha1DiagonalSecundaria++;
            } else if (tablero[i][tablero.length - 1 - i] == ficha2) {
                contFicha2DiagonalSecundaria++;
            }
        }

        if (contFicha2DiagonalPrincipal == tablero.length || contFicha2DiagonalSecundaria == tablero.length) {
            System.out.println(nom2 + "ha ganado");
            return true;
        } else if (contFicha1DiagonalPrincipal == tablero.length || contFicha1DiagonalSecundaria == tablero.length) {
            System.out.println(nom1 + " ha ganado");
            return true;
        }

        return false;
    }
    public boolean Empate() {
        if (empate == tablero.length * tablero.length) {
            System.out.println("Empate");
            return true;
        }
        return false;
    }

    int cont = 1;
    public void jugar() {
        
        
        if(cont == 0) {
            ElegirComiezo();
            cont++;
       
            }
            rellenar();
            introducirFichas();
            CambiarTurno();
            terminarJuego();
}
public boolean cambioJuego(){
    return terminarJuego;
}
public boolean terminarJuego() {
    if (ComprobarCol() == true || ComprobarFilas() == true || Empate() == true || comprobarDiagonales() == true) {
        terminarJuego=true;
        return true;
    }
    terminarJuego=false;
    return false;
}
}