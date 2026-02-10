package com.emiliojimeno.daw.rpg;

import java.util.Scanner;

public class MainTest {
    static PersonajeTest[] personajes = new PersonajeTest[5];
    static PersonajeTest jugador;
    static String nombreJugador = "player1";
    static Scanner sc = new Scanner(System.in);
    public static int contadorCiclos;
    public static final int CANTIDAD_TEST = 500;
    static int veces0 = 0;
    static int veces1 = 0;
    static int veces2 = 0;
    static int veces3 = 0;
    static int veces4 = 0;
    static int veces5 = 0;


    //creación de los personajes y monstruos y se añaden al array
    public static void crearPersonajes(String nombreJugador) {
        jugador = new PersonajeTest(nombreJugador, 100, 1.1f);

        PersonajeTest monstruo1 = new PersonajeTest("Esqueleto");
        PersonajeTest monstruo2 = new PersonajeTest("Sireno");
        PersonajeTest monstruo3 = new PersonajeTest("Dragón");
        PersonajeTest monstruo4 = new PersonajeTest("Parca");
        PersonajeTest monstruo5 = new PersonajeTest("Arpía");

        personajes[0] = monstruo1;
        personajes[1] = monstruo2;
        personajes[2] = monstruo3;
        personajes[3] = monstruo4;
        personajes[4] = monstruo5;
    }

    public static void main(String[] args) {
        for(int z = 0; z < CANTIDAD_TEST; z++) { //veces que queremos que se repita el test
            contadorCiclos = 0; //reseteo cada ejecución
            crearPersonajes(nombreJugador); //crear personajes
            boolean victoria = true; //esta variable evalúa si al salir del bucle hemos ganado o perdido
            for (int i = 0; i < personajes.length; i++) {

                do {

                    jugador.atacar(personajes[i]);
                    if(personajes[i].getVidaActual() <= 0){
                        break;
                    }

                    personajes[i].atacar(jugador);

                    if (!jugador.comprobarVida()) break;

                } while (personajes[i].comprobarVida() || jugador.comprobarVida());



                if (!jugador.comprobarVida()) {
                    victoria = false;
                    break;
                }
                jugador.curarTrasCadaCombate(); //tras derrotar a cada enemigo, existe una pequeña posibilidad de recuperar algo de salud
            }

            switch (contadorCiclos){
                case 0:
                    veces0++;
                    break;
                case 1:
                    veces1++;
                    break;
                case 2:
                    veces2++;
                    break;
                case 3:
                    veces3++;
                    break;
                case 4:
                    veces4++;
                    break;
                case 5:
                    veces5++;
                    break;

            }

            if(z % 50 == 0) { //filas de 50 resultados para mejor legibilidad
                System.out.println(contadorCiclos);
            }else{
                System.out.print(contadorCiclos + ", ");
            }
        }
        System.out.println("\n\nSe han realizado " + CANTIDAD_TEST +  " ejecuciones del juego. Esto son los resultados: ");
        System.out.println("Veces que el jugador ha perdido contra el primer monstruo: " + veces0 + " (" + ((double)veces0/(double)CANTIDAD_TEST)*100 + "%)");
        System.out.println("Veces que el jugador ha perdido contra el segundo monstruo: " + veces1 + " (" + ((double)veces1/(double)CANTIDAD_TEST)*100 + "%)");
        System.out.println("Veces que el jugador ha perdido contra el tercer monstruo: " + veces2 + " (" + ((double)veces2/(double)CANTIDAD_TEST)*100 + "%)");
        System.out.println("Veces que el jugador ha perdido contra el cuarto monstruo: " + veces3 + " (" + ((double)veces3/(double)CANTIDAD_TEST)*100 + "%)");
        System.out.println("Veces que el jugador ha perdido contra el quinto monstruo: " + veces4 + " (" + ((double)veces4/(double)CANTIDAD_TEST)*100 + "%)");
        System.out.println("Veces que el jugador se ha pasado el juego: " + veces5 + " (" + ((double)veces5/(double)CANTIDAD_TEST)*100 + "%)");

    }
}
