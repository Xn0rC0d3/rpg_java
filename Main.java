package com.emiliojimeno.daw.rpg;

import java.util.Scanner;

public class Main {
    static Personaje[] personajes = new Personaje[5];
    static Personaje jugador;
    static String nombreJugador;
    static Scanner sc = new Scanner(System.in);


    //creación de los personajes y monstruos y se añaden al array
    public static void crearPersonajes(String nombreJugador) {
        jugador = new Personaje(nombreJugador, 100, 1);

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

    public static void main(String[] args) {
        Lore.printPrologo();
        System.out.print("¿Cómo te llamas, héroe?: ");
        nombreJugador = sc.nextLine();
        System.out.println("\n\n");
        crearPersonajes(nombreJugador); //crear personajes
        //System.out.println("Personajes creados"); //feedback de desarrollo, quitar para versión final
        boolean victoria = true; //esta variable evalúa si al salir del bucle hemos ganado o perdido

        //recorremos el array de monstruos para zurrarnos contra ellos uno detrás de otro
        for (int i = 0; i < personajes.length; i++) {
            Lore.contarHistoria(i);
            sc.nextLine(); //detener ejecución para que el jugador pueda leer la historia antes de la pelea
            System.out.println("\n=======================================================================");
            System.out.println("Comienza el encuentro contra " + personajes[i].getNombre());
            System.out.println("Este monstruo tiene " + personajes[i].getVidaActual() + " puntos de vida.");
            Arte.dibujarEnemigo(i); //pintar monstruo
            System.out.println("=======================================================================");
            System.out.println("Comienzas el combate con " + jugador.getVidaActual() + " puntos de vida.");

            do {
                System.out.println("---------------------------------");
                System.out.println(nombreJugador + " ataca");
                jugador.atacar(personajes[i]);//ataque del jugador
                if(personajes[i].comprobarVida()){ //si el monstruo sobrevive se muestra su vida restante
                    System.out.println("Al monstruo le quedan " +  personajes[i].getVidaActual() + " puntos de vida.\n");
                }else{ //si no, combate ganado
                    break;
                }

                System.out.println(personajes[i].getNombre() + " contraataca");
                personajes[i].atacar(jugador); //contraataque del monstruo
                if(jugador.comprobarVida()){ //si el jugador sobrevive se muestra su vida restante
                    System.out.println("Te quedan " + jugador.getVidaActual() + " puntos de vida");
                }
                System.out.println("---------------------------------");

                if (!jugador.comprobarVida()) break; //si no, juego perdido

            } while (personajes[i].comprobarVida() || jugador.comprobarVida());

            if (!jugador.comprobarVida()) { //comprobar cuál ha sido la causa de salir del do-while
                victoria = false; //si el jugador ha muerto, indicamos que el jugador ha perdido
                break; //y salimos también del for
            }
            //tras derrotar a cada enemigo, existe una pequeña posibilidad de recuperar algo de salud
            jugador.curarTrasCadaCombate();//esto debe suceder lo último, o habría alguna posibilidad de "revivir"
        } //fin del bucle for

        System.out.println("\n\n");
        if (victoria) { //si al llegar aquí esta variable sigue como true, el jugador se ha pasado el juego
            System.out.println("Has vencido a todos tus enemigos");
            System.out.println("Has finalizado el juego con " + jugador.getVidaActual() + " puntos de vida.");
            Arte.printVictoria();
        } else { //si no, es que ha perdido
            Arte.printDerrota();
        }
    }
}
