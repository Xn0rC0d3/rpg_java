package com.emiliojimeno.daw.rpg;

public class PersonajeTest {
    private final String NOMBRE;
    private float vidaMaxima;
    private float vidaActual;
    private final float ATAQUE;
    private final float ARMADURA;
    private final float PRECISION;

    //constructor para enemigos
    public PersonajeTest(String nombre) {
        final float MAX_ATAQUE = 0.5f;
        final float MIN_ATAQUE = 0.4f;
        final float MAX_ARMADURA = 1;
        final float MIN_ARMADURA = 0.85f;
        final float MAX_PRECISION = 75;
        final float MIN_PRECISION = 70;

        this.NOMBRE = nombre;

        do {
            this.vidaMaxima = (int) (Math.random() * 100);
        } while (this.vidaMaxima < 60);

        this.vidaActual = vidaMaxima;
        //fórmula para aleatorio en un rango: Math.random() * (max - min) + min
        this.ATAQUE = (float)(Math.random() * (MAX_ATAQUE-MIN_ATAQUE)) + MIN_ATAQUE;
        this.ARMADURA = (float)(Math.random() * (MAX_ARMADURA-MIN_ARMADURA)) + MIN_ARMADURA;
        this.PRECISION = (float)(Math.random() * (MAX_PRECISION-MIN_PRECISION)) + MIN_PRECISION;
    }

    //constructor para el jugador
    public PersonajeTest(String nombre, int vidaMaxima, float ataque) {
        this.NOMBRE = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ATAQUE = ataque;
        this.ARMADURA = 3;
        this.PRECISION = 90;
    }


    // acción de atacar
    public void atacar(PersonajeTest defensor) {
        float damage;
        float tiradaDadosPrecision = (float) (Math.random() * this.PRECISION); //esto dará un valor entre 0 y el valor de PRECISIÓN
        //para calcular el daño se multiplica el valor base del personaje con un valor aleatorio entre 0 y 100
        float deflectado = (float) (Math.random() * this.ARMADURA);

        if(deflectado < 0){ //la armadura detiene daño, pero no puede "curar"
            deflectado = 0;
        }

        if(tiradaDadosPrecision >= 50){
            damage = (float) ((Math.random() * 100) * this.ATAQUE) - deflectado;
            if(damage < 0) {
                damage = 0;
            }
        }else{
            damage = 0;
        }


        recibirDamage(damage, defensor); //una vez calculado el daño, se le pasa al receptor para que lo aplique
    }

    //este metodo recibe una cantidad de daño y se lo resta a la vida del personaje en cuestión
    public void recibirDamage(float damage, PersonajeTest defensor) {
        defensor.setVidaActual(defensor.getVidaActual() - damage);
        if(defensor.getVidaActual() <= 0){
            if(defensor.getNombre() != "player1"){
                MainTest.contadorCiclos ++;
            }
        }
    }

    //comprueba si un personaje está vivo o muerto
    public boolean comprobarVida() {
        boolean comprobar = true;

        if (this.vidaActual <= 0) {
            comprobar = false;
        }
        return comprobar;
    }

    //getter de variable
    public String getNombre(){
        return this.NOMBRE;
    }

    //getter de variable
    public float getVidaActual() {
        return vidaActual;
    }

    // sirve para cambiar la vida a un personaje (sufrir daño, curarse...)
    private void setVidaActual(float vidaActual) {
        this.vidaActual = vidaActual;
    }
}
