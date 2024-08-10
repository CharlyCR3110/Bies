package bies.ente.insecto.mosca;

import bies.alimentacion.Alimento;
import bies.alimentacion.carronia.Carronia;
import bies.comportamiento.caminar.IComportamientoCaminar;
import bies.comportamiento.caminar.ImposibleCaminar;
import bies.comportamiento.caminar.PosibleCaminar;
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
public class Mosca extends InsectoAbstracto {

    private int nPatas = 2;
    private int nAlas = 2;
    private IComportamientoCaminar cCaminar;
    private IComportamientoVolar cVolar;

    public Mosca(String nombre) {
        super(nombre);
        this.cCaminar = new PosibleCaminar();
        this.cVolar = new PosibleVolar();
    }

    public void volar() {
        this.cVolar.ejecutar();
    }

    public void caminar() {
        this.cCaminar.ejecutar();
    }

    @Override
    public void verificarEstado() {
        if (nAlas < 2) {
            Carronia nuevaCarronia = new Carronia(this);
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cVolar = new ImposibleVolar();
            System.out.println(this.getNombre() + " se ha convertido en carroña y no podrá volar.");
        }
        if (nPatas < 2) {
            Carronia nuevaCarronia = new Carronia(this);
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cCaminar = new ImposibleCaminar();
            System.out
                    .println(this.getNombre() + " se ha convertido en carroña y no podrá caminar.");
        }
    }

    @Override
    public boolean puedeComer(Alimento alimento) {
        return (alimento instanceof Carronia);
    }

    public void perderPata() {
        this.nPatas--;
        System.out.println(this.getNombre() + " ha perdido una pata, ahora tiene: " + nPatas);
        this.verificarEstado();
    }

    public void perderAla() {
        this.nAlas--;
        System.out.println(this.getNombre() + " ha perdido un ala, ahora tiene: " + nAlas);
        this.verificarEstado();
    }

    public int getnPatas() {
        return this.nPatas;
    }

    public int getnAlas() {
        return this.nAlas;
    }
}
