package bies.ente;

import bies.alimentacion.IAlimento;
import bies.comportamiento.comer.PosibleComer;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:23 AM
 */
public abstract class SerVivoAbstracto {
    private String nombre;
    private PosibleComer cComer;

    public SerVivoAbstracto(String nombre) {
        this.nombre = nombre;
        this.cComer = new PosibleComer();
    }

    public void comer(IAlimento alimento) {
        if (puedeComer(alimento)) {
            System.out.print(this.nombre + " ");
            cComer.ejecutar();
            System.out.printf(alimento.toString() + "\n");
        } else {
            System.out.println(this.nombre + " no puede comer este tipo de alimento. ("
                    + alimento.toString() + ")");
        }
    }

    public abstract boolean puedeComer(IAlimento alimento);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
