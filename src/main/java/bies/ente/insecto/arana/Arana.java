package bies.ente.insecto.arana;

import bies.alimentacion.IAlimento;
import bies.alimentacion.carronia.Carronia;
import bies.alimentacion.hongo.Hongo;
import bies.comportamiento.caminar.IComportamientoCaminar;
import bies.comportamiento.caminar.imposibleCaminar.ImposibleCaminar;
import bies.comportamiento.caminar.posibleCaminar.PosibleCaminar;
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
public class Arana extends InsectoAbstracto {

    private int nPatas = 8;
    private IComportamientoCaminar cCaminar;

    public Arana(String nombre) {
        super(nombre);
        this.cCaminar = new PosibleCaminar();
    }

    public void caminar() {
        this.cCaminar.ejecutar();
    }

    @Override
    public void verificarEstado() {
        if (nPatas < 2) {
            Carronia nuevaCarronia = new Carronia(this);
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cCaminar = new ImposibleCaminar();
            System.out
                    .println(this.getNombre() + " se ha convertido en carroña y no podrá caminar.");
        }
    }

    @Override
    public boolean puedeComer(IAlimento alimento) {
        return (alimento instanceof Hongo);
    }

    public void perderPata() {
        this.nPatas--;
        System.out.println(this.getNombre() + " ha perdido una pata, ahora tiene: " + nPatas);
        this.verificarEstado();
    }

    public int getnPatas() {
        return this.nPatas;
    }
}
