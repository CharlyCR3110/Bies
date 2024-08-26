package bies.ente.innombrable.cero;

import bies.ente.innombrable.InnombrableAbstracto;
import bies.comportamiento.caminar.PosibleCaminar;
import bies.comportamiento.volar.PosibleVolar;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 12:02 PM
 */
public class InnombrableCero extends InnombrableAbstracto {
    public InnombrableCero(String nombre) {
        super(nombre);
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
