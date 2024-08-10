package bies.comportamiento.volar;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:20 AM
 */
public class PosibleVolar implements IComportamientoVolar {
    @Override
    public void ejecutar() {
        System.out.println("está volando");
    }
}
