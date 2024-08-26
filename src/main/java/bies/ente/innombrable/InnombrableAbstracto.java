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
public abstract class InnombrableAbstracto extends SerVivoAbstracto {
    protected IComportamiento cCualquiera;

    public InnombrableAbstracto(String nombre) {
        super(nombre);
    }

    @Override
    public boolean puedeComer(Alimento alimento) {
        return true;
    }
    public abstract void volar();
    public abstract void caminar();

    
}
