package bies.alimentacion.carronia;

import bies.alimentacion.IAlimento;
import bies.ente.insecto.InsectoAbstracto;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 3:09 PM
 */

 /**
 * Representa un tipo de alimento específico, conocido como carroña.
 * Implementa la interfaz {@link IAlimento}.
 * 
 * <p>Esta clase es una implementación concreta de {@link IAlimento} que 
 * representa un tipo de alimento que puede ser asociado con un insecto 
 * original.</p>
 * 
 * @param insectoOriginal El insecto asociado a este tipo de alimento.
 */
public record Carronia(InsectoAbstracto insectoOriginal) implements IAlimento {
    /**
     * Devuelve una representación en forma de cadena del tipo de alimento.
     * 
     * @return La cadena "Carroña" que representa este tipo de alimento.
     */
    @Override
    public String toString() {
        return "Carroña";
    }
}