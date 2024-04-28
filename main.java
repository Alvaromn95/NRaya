public class main {

    public static void main(String[] args) {
        Tablero t1 = new Tablero(3);
        Jugadores j1 = new Jugadores("israel", 'X');
        Jugadores j2 = new Jugadores("pepe", 'O');
        Juego juego1 = new Juego();
        int turno=0;
        juego1.ElegirComiezo();
        do {
            t1.rellenar();
            if(turno%2==0){
                System.out.println(j1.getNombre() + " es tu turno");
                j1.getFichas();
            }else{
                System.out.println(j2.getNombre() +" es tu turno");
                j2.getFichas();
            }
            t1.introducir();
            turno++;
         
        } while (!t1.Fin());
    }
}
