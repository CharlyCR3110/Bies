package bies.ente.insecto.estado.carronia;

import bies.alimentacion.carronia.Carronia;
import bies.ente.insecto.estado.IEstadoInsecto;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 3:26 PM
 */
public class EstadoCarronia implements IEstadoInsecto {
    private Carronia carronia;

    public EstadoCarronia(Carronia carronia) {
        this.carronia = carronia;
    }

    public Carronia getCarronia() {
        return carronia;
    }
}
