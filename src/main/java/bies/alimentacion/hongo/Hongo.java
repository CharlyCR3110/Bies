package bies.alimentacion.hongo;

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
 * Representa un tipo de alimento específico, conocido como hongo.
 * Implementa la interfaz {@link IAlimento}.
 * 
 * <p>Esta clase es una implementación concreta de {@link IAlimento} que 
 * representa un tipo de alimento que se puede asociar con hongos.</p>
 */
public record Hongo() implements IAlimento {
    /**
     * Devuelve una representación en forma de cadena del tipo de alimento.
     * 
     * @return La cadena "Hongo" que representa este tipo de alimento.
     */
    @Override
    public String toString() {
        return "Hongo";
    }
}
