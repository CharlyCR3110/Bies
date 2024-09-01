package bies.ente.insecto.estado; 

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 3:25 PM
 */

/**
 * Interfaz que define el comportamiento de un estado para un insecto.
 * 
 * Esta interfaz proporciona un método para verificar si el estado del insecto
 * es considerado como "carroña".
 */
public interface IEstadoInsecto {
    
    /**
     * Método que verifica si el estado del insecto es carroña.
     * 
     * @return true si el estado del insecto es carroña, false en caso contrario.
     */
    boolean esCarronia();
}