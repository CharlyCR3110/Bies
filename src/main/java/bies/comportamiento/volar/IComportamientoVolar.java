package bies.comportamiento.volar;

import bies.comportamiento.IComportamiento;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:19 AM
 */
/**
 * Interfaz que extiende {@link IComportamiento} para definir un comportamiento específico
 * relacionado con la capacidad de volar.
 * 
 * Esta interfaz no añade métodos adicionales a {@link IComportamiento}, sino que actúa
 * como una categoría específica para comportamientos de vuelo. Las clases que implementen
 * esta interfaz deberán proporcionar una implementación concreta del método {@link IComportamiento#ejecutar()}.
 */
public interface IComportamientoVolar extends IComportamiento {
}
