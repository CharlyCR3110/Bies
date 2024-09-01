package bies.ente.insecto.estado.noCarronia;

import bies.ente.insecto.estado.IEstadoInsecto;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 3:25 PM
 */

/**
 * Clase que representa el estado de un insecto cuando no es carroña.
 * 
 * Esta clase implementa la interfaz `IEstadoInsecto` y define el comportamiento específico
 * para el estado en el que el insecto no está en estado de carroña.
 */
public class EstadoNoCarronia implements IEstadoInsecto {

    /**
     * Verifica si el estado actual es carroña.
     * 
     * @return false, indicando que el estado no es carroña.
     */
    @Override
    public boolean esCarronia() {
        return false;
    }
}
