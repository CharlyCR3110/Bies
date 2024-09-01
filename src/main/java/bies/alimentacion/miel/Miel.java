package bies.alimentacion.miel;

import bies.alimentacion.IAlimento;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 3:08 PM
 */

 /**
 * Representa la miel como un tipo de alimento.
 * Este registro implementa la interfaz {@link IAlimento}.
 */
public record Miel() implements IAlimento {
    /**
     * Devuelve una representación en forma de cadena de la miel.
     *
     * @return el nombre del alimento, que es "Miel".
     */
    @Override
    public String toString() {
        return "Miel";
    }
}