import java.util.Random;

public class Personaje {
    private final Random rd = new Random();
    private final String NOMBRE;
    private float vidaMaxima;
    private float vidaActual;
    private final float ATAQUE;
    private final float ARMADURA;
    private final float PRECISION;

    //constructor para enemigos
    public Personaje(String nombre) {
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
    public Personaje(String nombre, int vidaMaxima, float ataque) {
        this.NOMBRE = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ATAQUE = ataque;
        this.ARMADURA = 3;
        this.PRECISION = 90;
    }


    // acción de atacar
    public void atacar(Personaje defensor) {
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
            System.out.println("La armadura ha detenido " + deflectado + " puntos de daño.");
            System.out.println("El ataque ha causado " + damage + " puntos de daño.");
        }else{
            damage = 0;
            System.out.println("El ataque falló!!");
        }


        recibirDamage(damage, defensor); //una vez calculado el daño, se le pasa al receptor para que lo aplique
    }

    //este metodo recibe una cantidad de daño y se lo resta a la vida del personaje en cuestión
    public void recibirDamage(float damage, Personaje defensor) {
        defensor.setVidaActual(defensor.getVidaActual() - damage);
        if(defensor.getVidaActual() <= 0){
            System.out.println(defensor.getNombre() + " ha sido derrotado.");
        }
    }


    //tras cada combate, el jugador tiene una pequeña posibilidad de curarse una porción de vida.
    //a menor probabilidad, mayor curación
    public void curarTrasCadaCombate(){
        final float POCION_MINIMA = 5;
        final float POCION_MEDIA = 10;
        final float POCION_GRANDE = 25;

        float num = rd.nextInt(100);

        if (num >= 50 && num < 80) {
            this.setVidaActual(vidaActual + POCION_MINIMA);
            System.out.println("El monstruo dejó caer lo que parece ser una pequeña y rudimentaria poción de salud.\n" +
                    " Tras beberla, recuperas " + POCION_MINIMA + " puntos de vida.");
        } else if (num >= 80 && num < 92) {
            this.setVidaActual(vidaActual + POCION_MEDIA);
            System.out.println("El monstruo dejó caer lo que parece un botellín de ambar que parece contener " +
                    "una poción de salud. \nTras beberla, recuperas " + POCION_MEDIA + " puntos de salud.");
        } else if (num >= 92 && num < 99) {
            setVidaActual(vidaActual + POCION_GRANDE);
            System.out.println("El monstruo dejó caer una especie de bota de vino llena de poción de salud.\n" +
                    "Tras beberla, recuperas " + POCION_GRANDE + " puntos de salud.");
        } else if (num >= 99) {
            setVidaActual(vidaActual = vidaMaxima);
            System.out.println("El monstruo dejó caer un precioso frasco de cristal lleno de " +
                    "un líquido de movimiento hipnotizante. \nParece ser una poción de salud muy avanzada." +
                    "Recuperas todos tus puntos de salud!");
        }
        if (this.vidaActual > this.vidaMaxima){ //la curación no puede exceder el máximo de vida
            this.vidaActual = this.vidaMaxima;
        }
        System.out.println("Tu vida actual es de: " + this.getVidaActual());
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
