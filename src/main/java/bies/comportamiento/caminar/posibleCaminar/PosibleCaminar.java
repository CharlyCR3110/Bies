package bies.comportamiento.caminar.posibleCaminar;

import bies.comportamiento.caminar.IComportamientoCaminar;

/**
 * @author Isaac F. B. C.
 * @since 8/7/2024 - 11:19 AM
 */
public class PosibleCaminar implements IComportamientoCaminar {
    @Override
    public void ejecutar() {
        System.out.println("está caminando"); 
    }
}
