public class Jugadores {
    private String nombre;
    private char fichas;

    public Jugadores(String nombre, char fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
    }

    public char getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFichas(char fichas) {
        this.fichas = fichas;
    }
}
 