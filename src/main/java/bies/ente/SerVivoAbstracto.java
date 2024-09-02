package bies.ente;

import bies.alimentacion.Alimento;
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

    /**
     * Constructor para crear un ser vivo con un nombre específico.
     * Cabe reacalcar que todos ser Vivo se alimenta.. (Come)
     * 
     * @param nombre El nombre del ser vivo.
     */
    public SerVivoAbstracto(String nombre) {
        this.nombre = nombre;
        this.cComer = new PosibleComer();
    }

    /**
     * Método para que el ser vivo intente comer un alimento.
     * 
     * @param alimento El alimento que el ser vivo intentará comer.
     */
    public void comer(Alimento alimento) {
        if (puedeComer(alimento)) {
            System.out.print(this.nombre + " ");
            cComer.ejecutar();
            System.out.printf(alimento.toString() + "\n");
        } else {
            System.out.println(this.nombre + " no puede comer este tipo de alimento. ("
                    + alimento.toString() + ")");
        }
    }
    
    /**
     * Método abstracto que determina si el ser vivo puede comer un tipo de alimento.
     * 
     * @param alimento El alimento que se evaluará.
     * @return true si el ser vivo puede comer el alimento, false en caso contrario.
     */
    public abstract boolean puedeComer(Alimento alimento);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
