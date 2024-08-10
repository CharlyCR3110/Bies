package bies.comportamiento.caminar;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:18 AM
 */
public class ImposibleCaminar implements IComportamientoCaminar{
    @Override
    public void ejecutar() {
        System.out.println("no puede caminar");
    }
}
