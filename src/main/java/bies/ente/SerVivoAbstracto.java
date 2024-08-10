package bies.ente;

import bies.alimentacion.Alimento;
import bies.comportamiento.comer.IComportamientoComer;
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
    private IComportamientoComer cComer;

    public SerVivoAbstracto(String nombre) {
        this.nombre = nombre;
        this.cComer = new PosibleComer();
    }

    public void comer(Alimento alimento) {
        if (puedeComer(alimento)) {
            System.out.print(this.nombre + " ");
            cComer.ejecutar();
            System.out.printf(alimento.getTipo() + "\n");
        } else {
            System.out.println(this.nombre + " no puede comer este tipo de alimento. ("
                    + alimento.getTipo() + ")");
        }
    }

    public abstract boolean puedeComer(Alimento alimento);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
