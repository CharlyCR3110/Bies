package bies.ente.insecto;

import bies.alimentacion.Alimento;
import bies.ente.SerVivoAbstracto;
import bies.ente.insecto.estado.IEstadoInsecto;
import bies.ente.insecto.estado.noCarronia.EstadoNoCarronia;


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

    /**
     * Constructor para crear un insecto con un nombre específico.
     * Cabe recalcar que el insecto nuevo cuenta con todas sus partes.. es decir, NO es carroña.
     * 
     * @param nombre El nombre del insecto.
     */
    public InsectoAbstracto(String nombre) {
        super(nombre);
        estadoInsecto = new EstadoNoCarronia();
    }

    /**
     * Método abstracto que las subclases deben implementar para verificar el estado del insecto.
     * No se implementa ya que su estado varia por las partes de cada insecto.. (tiene o no; alas o patas)
     */
    public abstract void verificarEstado();

    /**
     * Verifica si el insecto es considerado carroña.
     * 
     * @return true si el insecto es carroña, false en caso contrario.
     */
    public boolean esCarronia() {
        return estadoInsecto.esCarronia();
    }

    /**
     * Cambia el estado actual del insecto.
     * 
     * @param estado El nuevo estado que se asignará al insecto.
     */
    public void cambiarEstado(IEstadoInsecto estado) {
        this.estadoInsecto = estado;
    }

    /**
     * Obtiene la representación de carroña del insecto si es que está en ese estado.
     * 
     * @return Un objeto de tipo Carronia si el insecto es carroña, null en caso contrario.
     */
    public Alimento obtenerCarronia() {
        if(esCarronia()) {
            return new Alimento("Carronia");
        }
        return null;
    }

    /**
     * Método que simula la degradación del insecto.
     *
     * @return true si el insecto se degradó, false en caso contrario.
     * @throws IllegalStateException si el insecto ya es carroña.
     */
    public abstract boolean degradar();
}
