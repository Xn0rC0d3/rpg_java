package TrabajoJuegoProgramacion;

public class Personaje {
    private String nombre;
    private float vidaMaxima;
    private float vidaActual;
    private float ataque;

    public Personaje(String nombre) {
        this.nombre = nombre;

        do {
            this.vidaMaxima = (int) (Math.random() * 100);
        } while (this.vidaMaxima < 60);

        this.vidaActual = vidaMaxima;
        this.ataque = 0.5f;
    }

    public Personaje(String nombre, int vidaMaxima) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.ataque = (float) 10 / vidaMaxima;
    }

    public void atacar(Personaje defensor) {
        float damage = (float) (Math.random() * 100) * this.ataque;

        recibirDaño(damage, defensor);
    }

    public void recibirDaño(float damage, Personaje defensor) {
        defensor.setVidaActual(defensor.getVidaActual() - damage);
    }

    public boolean comprobarVida() {
        boolean comprobar = true;

        if (this.vidaActual <= 0) {
            comprobar = false;
        }

        return comprobar;
    }

    public float getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(float vidaActual) {
        this.vidaActual = vidaActual;
    }
}



