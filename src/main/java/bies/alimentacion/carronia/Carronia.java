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

public record Carronia(InsectoAbstracto insectoOriginal) implements IAlimento {
    @Override
    public String toString() {
        return "Carroña";
    }
}