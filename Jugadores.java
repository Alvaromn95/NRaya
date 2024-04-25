public class Jugadores {
    private String nombre;
    private enum Fichas{X,O};
    Fichas fichas;
    public Jugadores(String nombre, String fichas) {
        this.nombre = nombre;
        this.fichas = Fichas.valueOf(fichas);
    }

    public Jugadores(Jugadores.Fichas fichas) {
        this.fichas = fichas;
    }

    public Fichas getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
