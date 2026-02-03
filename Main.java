package TrabajoJuegoProgramacion;

public class Main {

    public static Personaje[] personajes = new Personaje[5];
    public static Personaje jugador;

    public static void crearPersonajes() {
        jugador = new Personaje("jugador1", 100);
        Personaje monstruo1 = new Personaje("orco");
        personajes[0] = monstruo1;
        Personaje monstruo2 = new Personaje("troll");
        personajes[1] = monstruo2;
        Personaje monstruo3 = new Personaje("vampiro");
        personajes[2] = monstruo3;
        Personaje monstruo4 = new Personaje("slime");
        personajes[3] = monstruo4;
        Personaje monstruo5 = new Personaje("bruja");
        personajes[4] = monstruo5;

    }

    static void main(String[] args) {

        crearPersonajes();
        System.out.println("Personajes creados");
        boolean victoria = true;

        for (int i = 0; i < personajes.length; i++) {
            do {
                System.out.println("Jugador ataca");
                System.out.println("");

                jugador.atacar(personajes[i]);

                if (!personajes[i].comprobarVida()) break;
                System.out.println("La vida ddl jugador es de " + jugador.getVidaActual());

                System.out.println("El monstruo contrataca");
                personajes[i].atacar(jugador);
                System.out.println("La vida ddl MONSTRUO es de " +  personajes[i].getVidaActual());
                if (!jugador.comprobarVida()) break;
            } while (personajes[i].comprobarVida() || jugador.comprobarVida());

            if (!jugador.comprobarVida()) {
                victoria = false;
                break;
            }
        }

        if (victoria) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("¡Has perdido!");
        }
    }
}
