package bies.comportamiento.volar.posibleVolar;

import bies.comportamiento.IComportamiento;
import bies.comportamiento.volar.IComportamientoVolar;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:20 AM
 */

 /**
 * Clase que implementa la interfaz {@link IComportamientoVolar} para definir un comportamiento
 * específico cuando un objeto puede volar.
 * 
 * Esta implementación concreta del método {@link IComportamiento#ejecutar()} proporciona
 * una acción que indica que el objeto no tiene la capacidad de volar.
 */
public class PosibleVolar implements IComportamientoVolar {
    @Override
    public void ejecutar() {
        System.out.println("está volando");
    }
}
