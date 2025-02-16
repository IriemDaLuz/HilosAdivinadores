package hilosadivinadores;

public class main {

    private static final int NUM_HILOS = 10;

    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();


        Thread[] hilosAdivinadores = new Thread[NUM_HILOS];
        for (int i = 0; i < NUM_HILOS; i++) {
            Thread hilo = new Thread(new HiloAdivinador("Hilo " + (i + 1), numeroOculto));
            hilosAdivinadores[i] = hilo;
        }

        for (Thread hilo : hilosAdivinadores) {
            hilo.start();
        }

        for (Thread hilo : hilosAdivinadores) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
            }
        }
    }
}