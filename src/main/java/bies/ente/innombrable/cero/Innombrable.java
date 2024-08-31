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
public class Innombrable extends InnombrableAbstracto {
    public Innombrable(String nombre) {
        super(nombre);
        this.cCualquiera = new PosibleVolar();
        this.cCualquiera = new PosibleCaminar();
    }
    
    @Override
    public void volar() {
        this.cCualquiera.ejecutar();
    }

    @Override
    public void caminar() {
        this.cCualquiera.ejecutar();
    }
}
