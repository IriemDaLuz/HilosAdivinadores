package hilosadivinadores;

import java.util.Random;


public class HiloAdivinador implements Runnable {

    private final String nombreHilo;
    private final NumeroOculto numeroOculto;


    public HiloAdivinador(String nombreHilo, NumeroOculto numeroOculto) {
        this.nombreHilo = nombreHilo;
        this.numeroOculto = numeroOculto;
    }

    @Override
    public void run() {
        Random r = new Random();
        boolean acertado = false;

        while (!acertado) {
            int numPropuesto = r.nextInt(101); 
            int resultado = numeroOculto.propuestaNumero(numPropuesto);

            if (resultado == -1) {
                System.out.println(nombreHilo + " detenido. El número ya fue adivinado.");
                return;
            } else if (resultado == 1) {
                System.out.println(nombreHilo + " adivinó el número oculto. (" + numPropuesto + ")");
                acertado = true;
            } else {
                System.out.println(nombreHilo + " dice que es el " + numPropuesto + ". Incorrecto.");
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
