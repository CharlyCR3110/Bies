package bies.ente.insecto;

import bies.alimentacion.carronia.Carronia;
import bies.ente.SerVivoAbstracto;
import bies.ente.insecto.estado.IEstadoInsecto;
import bies.ente.insecto.estado.carronia.EstadoCarronia;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0 
 * @since 8/7/2024 - 11:25 AM
 */
public abstract class InsectoAbstracto extends SerVivoAbstracto {
    private IEstadoInsecto estadoInsecto;

    public InsectoAbstracto(String nombre) {
        super(nombre);
    }

    public abstract void verificarEstado();

    public boolean esCarronia() {
        return estadoInsecto instanceof EstadoCarronia;
    }

    public void cambiarEstado(IEstadoInsecto estado) {
        this.estadoInsecto = estado;
    }

    public Carronia obtenerCarronia() {
        if (esCarronia()) {
            return ((EstadoCarronia) estadoInsecto).getCarronia();
        }
        return null;
    }
}
