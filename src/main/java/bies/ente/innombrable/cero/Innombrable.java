package bies.ente.innombrable.cero;

import bies.ente.innombrable.InnombrableAbstracto;
import bies.comportamiento.caminar.posibleCaminar.PosibleCaminar;
import bies.comportamiento.volar.posibleVolar.PosibleVolar;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 12:02 PM
 */
/**
 * Clase concreta que extiende {@link InnombrableAbstracto} y proporciona
 * implementaciones específicas para los métodos abstractos definidos en
 * la clase base.
 * 
 * Esta clase permite la asignación de comportamientos de volar y caminar a
 * través de instancias de {@link PosibleVolar} y {@link PosibleCaminar},
 * respectivamente.
 */
public class Innombrable extends InnombrableAbstracto {

    /**
     * Constructor que inicializa el nombre del ser vivo utilizando el constructor
     * de la clase base {@link InnombrableAbstracto}.
     * 
     * @param nombre El nombre del ser vivo.
     */
    public Innombrable(String nombre) {
        super(nombre);
    }
    
    /**
     * Implementación del método {@link InnombrableAbstracto#volar()}. Este método
     * asigna un comportamiento de vuelo posible a la instancia y ejecuta la acción
     * correspondiente.
     */
    @Override
    public void volar() {
        this.cCualquiera = new PosibleVolar();
        this.cCualquiera.ejecutar();
    }

    /**
     * Implementación del método {@link InnombrableAbstracto#caminar()}. Este método
     * asigna un comportamiento de caminar posible a la instancia y ejecuta la acción
     * correspondiente.
     */
    @Override
    public void caminar() {
        this.cCualquiera = new PosibleCaminar();
        this.cCualquiera.ejecutar();
    }
}
