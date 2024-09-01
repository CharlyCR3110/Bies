package bies.comportamiento.caminar.posibleCaminar;

import bies.comportamiento.IComportamiento;
import bies.comportamiento.caminar.IComportamientoCaminar;

/**
 * @author Isaac F. B. C.
 * @since 8/7/2024 - 11:19 AM
 */

 /**
 * Implementación de {@link IComportamientoCaminar} que define un comportamiento específico
 * para caminar.
 * 
 * Esta clase proporciona una implementación concreta del método {@link IComportamiento#ejecutar()},
 * el cual imprime un mensaje en la consola indicando que el objeto está caminando.
 */
public class PosibleCaminar implements IComportamientoCaminar {
    /**
     * Implementación del método {@link IComportamiento#ejecutar()} que imprime el mensaje
     * "está caminando" en la consola.
     */
    @Override
    public void ejecutar() {
        System.out.println("está caminando"); 
    }
}
