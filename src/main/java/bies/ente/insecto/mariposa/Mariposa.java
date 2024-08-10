package bies.ente.insecto.mariposa;

import bies.alimentacion.Alimento;
import bies.alimentacion.carronia.Carronia;
import bies.alimentacion.miel.Miel;
import bies.comportamiento.volar.IComportamientoVolar;
import bies.comportamiento.volar.ImposibleVolar;
import bies.comportamiento.volar.PosibleVolar;
import bies.ente.insecto.InsectoAbstracto;
import bies.ente.insecto.estado.carronia.EstadoCarronia;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0 
 * @since 8/7/2024 - 11:25 AM
 */
public class Mariposa extends InsectoAbstracto {

    private int nAlas = 2;
    private IComportamientoVolar cVolar;

    public Mariposa(String nombre) {
        super(nombre);
        this.cVolar = new PosibleVolar();
    }

    public void volar() {
        this.cVolar.ejecutar();
    }

    @Override
    public void verificarEstado() {
        if (nAlas < 2) {
            Carronia nuevaCarronia = new Carronia(this);
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cVolar = new ImposibleVolar();
            System.out.println(this.getNombre() + " se ha convertido en carroña y no podrá volar.");
        }
    }

    @Override
    public boolean puedeComer(Alimento alimento) {
        return (alimento instanceof Miel);
    }

    public void perderAla() {
        this.nAlas--;
        System.out.println(this.getNombre() + " ha perdido un ala, ahora tiene: " + nAlas);
        this.verificarEstado();
    }

    public int getnAlas() {
        return nAlas;
    }
}
