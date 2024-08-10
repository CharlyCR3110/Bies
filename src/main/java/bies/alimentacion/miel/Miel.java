package bies.alimentacion.miel;

import bies.alimentacion.Alimento;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 3:08 PM
 */
public record Miel() implements Alimento {
    @Override
    public String getTipo() {
        return "Miel";
    }
}