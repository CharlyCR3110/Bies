package bies.comportamiento.caminar.imposibleCaminar;

import bies.comportamiento.IComportamiento;
import bies.comportamiento.caminar.IComportamientoCaminar;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:18 AM
 */

 /**
 * Implementación de {@link IComportamientoCaminar} que define un comportamiento específico
 * para el caso en que no es posible caminar.
 * 
 * Esta clase proporciona una implementación concreta del método {@link IComportamiento#ejecutar()},
 * el cual imprime un mensaje en la consola indicando que el objeto no puede caminar.
 */
public class ImposibleCaminar implements IComportamientoCaminar{
    /**
     * Implementación del método {@link IComportamiento#ejecutar()} que imprime el mensaje
     * "no puede caminar" en la consola.
     */
    @Override
    public void ejecutar() {
        System.out.println("no puede caminar");
    }
}
