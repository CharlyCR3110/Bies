package bies.comportamiento.comer;

import bies.comportamiento.IComportamiento;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:19 AM
 */
public class PosibleComer implements IComportamiento {
    @Override
    public void ejecutar() {
        System.out.print("está comiendo -> ");
    }
}
