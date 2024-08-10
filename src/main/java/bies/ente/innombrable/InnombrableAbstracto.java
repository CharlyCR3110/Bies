package bies.ente.innombrable;

import bies.alimentacion.Alimento;
import bies.comportamiento.IComportamiento;
import bies.comportamiento.caminar.PosibleCaminar;
import bies.comportamiento.volar.PosibleVolar;
import bies.ente.SerVivoAbstracto;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:25 AM
 */
public class InnombrableAbstracto extends SerVivoAbstracto {
    private IComportamiento cCualquiera;

    public InnombrableAbstracto(String nombre) {
        super(nombre);
    }

    @Override
    public boolean puedeComer(Alimento alimento) {
        return true;
    }

    public void volar() {
        this.cCualquiera = new PosibleVolar();
        this.cCualquiera.ejecutar();
    }

    public void caminar() {
        this.cCualquiera = new PosibleCaminar();
        this.cCualquiera.ejecutar();
    }
}
