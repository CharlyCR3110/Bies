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
public class EstadoNoCarronia implements IEstadoInsecto {
    @Override
    public boolean esCarronia() {
        return false;
    }
}