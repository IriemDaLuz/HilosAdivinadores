package hilosadivinadores;

import java.util.Random;


public class NumeroOculto {
    private final int numeroOculto;
    private boolean adivinado = false;

    
    public NumeroOculto() {
        Random r = new Random();
        this.numeroOculto = r.nextInt(101);
        System.out.println("Número secreto: " + this.numeroOculto);
    }

 
    synchronized public int propuestaNumero(int num) {
        if (adivinado) {
            return -1; 
        } else if (num == numeroOculto) {
            adivinado = true;
            return 1;
        } else {
            return 0;
        }
    }
}