package bies.comportamiento.comer;

import bies.comportamiento.IComportamiento;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:19 AM
 */

 /**
 * Implementación de {@link IComportamiento} que define un comportamiento específico
 * para el caso en que es posible comer.
 * 
 * Esta clase proporciona una implementación concreta del método {@link IComportamiento#ejecutar()},
 * el cual imprime en la consola un mensaje indicando que el objeto está comiendo.
 */
public class PosibleComer implements IComportamiento {
    /**
     * Implementación del método {@link IComportamiento#ejecutar()} que imprime el mensaje
     * "está comiendo -> " en la consola.
     */
    @Override
    public void ejecutar() {
        System.out.print("está comiendo -> ");
    }
}
