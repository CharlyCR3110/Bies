package bies.ente.insecto.mosca;

import bies.alimentacion.Alimento;
import bies.comportamiento.caminar.IComportamientoCaminar;
import bies.comportamiento.caminar.imposibleCaminar.ImposibleCaminar;
import bies.comportamiento.caminar.posibleCaminar.PosibleCaminar;
import bies.comportamiento.volar.IComportamientoVolar;
import bies.comportamiento.volar.imposibleVolar.ImposibleVolar;
import bies.comportamiento.volar.posibleVolar.PosibleVolar;
import bies.ente.insecto.InsectoAbstracto;
import bies.ente.insecto.estado.carronia.EstadoCarronia;

import java.util.Random;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:25 AM
 */

/**
 * Clase que representa una mosca, extendiendo {@link InsectoAbstracto}.
 * <p>
 * Esta clase concreta implementa el comportamiento específico de una mosca,
 * incluyendo el número de patas y alas, así como la capacidad de caminar y volar.
 * También gestiona el cambio de estado en caso de pérdida de patas o alas y la
 * verificación de alimentos que puede consumir.
 */
public class Mosca extends InsectoAbstracto {

    // Número inicial de patas de la mosca.
    private int nPatas = 2;

    // Número inicial de alas de la mosca.
    private int nAlas = 2;

    // Comportamiento de caminar asociado a la mosca.
    private IComportamientoCaminar cCaminar;

    // Comportamiento de volar asociado a la mosca.
    private IComportamientoVolar cVolar;

    /**
     * Constructor que inicializa el nombre de la mosca y asigna los comportamientos
     * de caminar y volar posibles.
     *
     * @param nombre El nombre de la mosca.
     */
    public Mosca(String nombre) {
        super(nombre);
        this.cCaminar = new PosibleCaminar();
        this.cVolar = new PosibleVolar();
    }

    /**
     * Método que permite a la mosca volar, ejecutando el comportamiento de volar
     * asociado.
     */
    public void volar() {
        this.cVolar.ejecutar();
    }

    /**
     * Método que permite a la mosca caminar, ejecutando el comportamiento de caminar
     * asociado.
     */
    public void caminar() {
        this.cCaminar.ejecutar();
    }

    /**
     * Método para verificar el estado de la mosca. Si el número de alas es menor que 2,
     * o el número de patas es menor que 2, la mosca se convierte en carroña y cambia su
     * estado a {@link EstadoCarronia}. Además, el comportamiento de volar o caminar se
     * actualiza a {@link ImposibleVolar} o {@link ImposibleCaminar} según corresponda.
     */
    @Override
    public void verificarEstado() {
        if (nAlas < 2) {
            Alimento nuevaCarronia = new Alimento("Mosca");
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cVolar = new ImposibleVolar();
            System.out.println(this.getNombre() + " se ha convertido en carroña y no podrá volar.");
        }
        if (nPatas < 2) {
            Alimento nuevaCarronia = new Alimento("Mosca");
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cCaminar = new ImposibleCaminar();
            System.out.println(this.getNombre() + " se ha convertido en carroña y no podrá caminar.");
        }
    }

    /**
     * Método que determina si la mosca puede comer el alimento proporcionado.
     *
     * @param alimento El alimento a verificar.
     * @return true si el nombre del alimento es "Carronia", false en caso contrario.
     */
    @Override
    public boolean puedeComer(Alimento alimento) {
        return alimento.nombre() == "Carronia";
    }

    /**
     * Método que simula la pérdida de una pata de la mosca, decrementando el número
     * de patas y verificando el estado actual de la mosca.
     */
    public void perderPata() {
        this.nPatas--;
        System.out.println(this.getNombre() + " ha perdido una pata, ahora tiene: " + nPatas);
        this.verificarEstado();
    }

    /**
     * Método que simula la pérdida de un ala de la mosca, decrementando el número
     * de alas y verificando el estado actual de la mosca.
     */
    public void perderAla() {
        this.nAlas--;
        System.out.println(this.getNombre() + " ha perdido un ala, ahora tiene: " + nAlas);
        this.verificarEstado();
    }

    /**
     * Getter para obtener el número actual de patas de la mosca.
     *
     * @return El número de patas.
     */
    public int getnPatas() {
        return this.nPatas;
    }

    /**
     * Getter para obtener el número actual de alas de la mosca.
     *
     * @return El número de alas.
     */
    public int getnAlas() {
        return this.nAlas;
    }

    /**
     * Método que simula la degradación del insecto.
     *
     * @return true si el insecto se degradó, false en caso contrario.
     * @throws IllegalStateException si el insecto ya es carroña.
     */
    @Override
    public boolean degradar() {
        if (this.esCarronia()) {
            throw new IllegalStateException("La mariposa ya es carroña.");
        }
        int pieza = new Random().nextInt(3);

        if (pieza == 0) {
            this.perderPata();
            return true;
        } else if (pieza == 1) {
            this.perderAla();
            return true;
        }

        return false;
    }
}