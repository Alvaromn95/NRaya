public class Jugadores {
    private String nombre;
    private char fichas;

    protected boolean turno1;
    protected boolean turno2;

    public Jugadores(String nombre, char ficha) {
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

    public void setFicha(char fichas) {
        this.fichas = fichas;
    }

}
