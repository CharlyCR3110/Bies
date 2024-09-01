package bies.comportamiento;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:18 AM
 */

/**
 * Interfaz que define un comportamiento que debe ser implementado por cualquier clase
 * que desee proporcionar una implementación específica para la operación `ejecutar`.
 */
public interface IComportamiento {
    
    /**
     * Método para ejecutar una acción específica.
     * Las clases que implementen esta interfaz deben proporcionar
     * una implementación concreta de este método.
     */
    void ejecutar();
}