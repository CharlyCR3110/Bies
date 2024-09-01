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
/**
 * Clase que representa el estado de un insecto cuando se convierte en carroña.
 * 
 * Esta clase implementa la interfaz `IEstadoInsecto` y define el comportamiento específico
 * para el estado de carroña. Contiene una referencia a un objeto de tipo `Carronia`, que
 * representa el estado de carroña del insecto.
 */
public class EstadoCarronia implements IEstadoInsecto {

    /** Referencia al objeto `Carronia` que representa el estado de carroña del insecto. */
    private Carronia carronia;

    /**
     * Constructor que inicializa el estado de carroña con un objeto `Carronia`.
     * 
     * @param carronia El objeto `Carronia` que representa el estado de carroña.
     */
    public EstadoCarronia(Carronia carronia) {
        this.carronia = carronia;
    }

    /**
     * Obtiene el objeto `Carronia` asociado a este estado de carroña.
     * 
     * @return El objeto `Carronia` asociado a este estado.
     */
    public Carronia getCarronia() {
        return carronia;
    }

    /**
     * Verifica si el estado actual es carroña.
     * 
     * @return true, indicando que el estado es carroña.
     */
    @Override
    public boolean esCarronia() {
        return true;
    }
}
