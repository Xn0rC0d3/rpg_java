package com.emiliojimeno.daw.rpg;

public class Personaje {
    private String nombre;
    private float vidaMaxima;
    private float vidaActual;
    private float ataque;

    //constructor para enemigos
    public Personaje(String nombre) {
        this.nombre = nombre;

        do {
            this.vidaMaxima = (int) (Math.random() * 100);
        } while (this.vidaMaxima < 60);

        this.vidaActual = vidaMaxima;
        this.ataque = 0.5f;
    }

    //constructor para el jugador
    public Personaje(String nombre, int vidaMaxima, float ataque) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ataque = ataque;
    }



    public void atacar(Personaje defensor) {
        float damage = (float) (Math.random() * 100) * this.ataque;
        System.out.println("El ataque ha generado " + damage + " puntos de daño.");
        recibirDano(damage, defensor);
    }

    public void recibirDano(float damage, Personaje defensor) {
        defensor.setVidaActual(defensor.getVidaActual() - damage);
        if(defensor.getVidaActual() <= 0){
            System.out.println(defensor.getNombre() + " ha sido derrotado.");
        }
    }

    public boolean comprobarVida() {
        boolean comprobar = true;

        if (this.vidaActual <= 0) {
            comprobar = false;
        }

        return comprobar;
    }
    public String getNombre(){
        return this.nombre;
    }

    public float getVidaActual() {
        return vidaActual;
    }

    private void setVidaActual(float vidaActual) {
        this.vidaActual = vidaActual;
    }
}
