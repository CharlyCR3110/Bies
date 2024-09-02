package bies.ente.innombrable;

import bies.alimentacion.Alimento;
import bies.comportamiento.IComportamiento;
import bies.ente.SerVivoAbstracto;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:25 AM
 */
/**
 * Clase abstracta que extiende {@link SerVivoAbstracto} y representa un tipo de ser vivo
 * que puede tener comportamientos específicos definidos por {@link IComportamiento}.
 * 
 * Esta clase proporciona una implementación parcial para los métodos relacionados con la
 * alimentación y define métodos abstractos para acciones como volar y caminar.
 */
public abstract class InnombrableAbstracto extends SerVivoAbstracto {
    
    /**
     * Comportamiento que puede ser utilizado por instancias de esta clase.
     */
    protected IComportamiento cCualquiera;

    /**
     * Constructor que inicializa el nombre del ser vivo.
     * 
     * @param nombre El nombre del ser vivo.
     */
    public InnombrableAbstracto(String nombre) {
        super(nombre);
    }

    /**
     * Método que determina si el ser vivo puede comer el alimento proporcionado.
     * 
     * En esta implementación, se asume que el ser vivo puede comer cualquier tipo de alimento,
     * por lo que siempre devuelve {@code true}.
     * 
     * @param alimento El alimento que se desea verificar.
     * @return {@code true} si el ser vivo puede comer el alimento, {@code false} en caso contrario.
     */
    @Override
    public boolean puedeComer(Alimento alimento) {
        return true;
    }
    
    /**
     * Método abstracto que debe ser implementado por las subclases para definir el comportamiento
     * específico de volar.
     */
    public abstract void volar();

    /**
     * Método abstracto que debe ser implementado por las subclases para definir el comportamiento
     * específico de caminar.
     */
    public abstract void caminar();
}
