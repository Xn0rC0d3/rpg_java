package com.emiliojimeno.daw.rpg;

public class Main {
    public static Personaje[] personajes = new Personaje[5];
    public static Personaje jugador;

    public static void crearPersonajes() {
        jugador = new Personaje("jugador1", 100, 1.1f);

        Personaje monstruo1 = new Personaje("Esqueleto");
        Personaje monstruo2 = new Personaje("Sireno");
        Personaje monstruo3 = new Personaje("Dragón");
        Personaje monstruo4 = new Personaje("Parca");
        Personaje monstruo5 = new Personaje("Arpía");

        personajes[0] = monstruo1;
        personajes[1] = monstruo2;
        personajes[2] = monstruo3;
        personajes[3] = monstruo4;
        personajes[4] = monstruo5;
    }

    static void main(String[] args) {
        crearPersonajes();
        System.out.println("Personajes creados");
        boolean victoria = true;

        for (int i = 0; i < personajes.length; i++) {
            System.out.println("\n=======================================================================");
            System.out.println("Comienza el encuentro contra " + personajes[i].getNombre());
            System.out.println("Este monstruo tiene " + personajes[i].getVidaActual() + " puntos de vida.");
            Arte.dibujarEnemigo(i);
            System.out.println("=======================================================================");
            System.out.println("Te quedan " + jugador.getVidaActual() + " puntos de vida.");

            do {
                System.out.println("---------------------------------");
                System.out.println("Jugador ataca");
                jugador.atacar(personajes[i]);
                if(personajes[i].getVidaActual() > 0){
                    System.out.println("Al monstruo le quedan " +  personajes[i].getVidaActual());
                }

                if (!personajes[i].comprobarVida()) break;

                System.out.println("El monstruo contrataca");
                personajes[i].atacar(jugador);
                if(jugador.getVidaActual() > 0){
                    System.out.println("Te quedan " + jugador.getVidaActual() + " puntos de vida");
                }
                System.out.println("---------------------------------");

                if (!jugador.comprobarVida()) break;

            } while (personajes[i].comprobarVida() || jugador.comprobarVida());

            if (!jugador.comprobarVida()) {
                victoria = false;
                break;
            }
        }

        if (victoria) {
            Arte.printVictoria();
        } else {
            Arte.printDerrota();
        }
    }
}
