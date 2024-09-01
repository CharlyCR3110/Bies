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
/**
 * Clase que representa una araña, extendiendo {@link InsectoAbstracto}.
 * 
 * Esta clase concreta implementa el comportamiento específico de una araña,
 * incluyendo el número de patas y la capacidad de caminar. También gestiona
 * el cambio de estado en caso de pérdida de patas y la verificación de alimentos
 * que puede consumir.
 */
public class Arana extends InsectoAbstracto {

    // Número inicial de patas de la araña.
    private int nPatas = 8;
    
    // Comportamiento de caminar asociado a la araña.
    private IComportamientoCaminar cCaminar;

    /**
     * Constructor que inicializa el nombre de la araña y asigna un comportamiento
     * de caminar posible.
     * 
     * @param nombre El nombre de la araña.
     */
    public Arana(String nombre) {
        super(nombre);
        this.cCaminar = new PosibleCaminar();
    }

    /**
     * Método que permite a la araña caminar, ejecutando el comportamiento de caminar
     * asociado.
     */
    public void caminar() {
        this.cCaminar.ejecutar();
    }

    /**
     * Método para verificar el estado de la araña. Si el número de patas es menor que 2,
     * la araña se convierte en carroña y cambia su estado a {@link EstadoCarronia}.
     * Además, el comportamiento de caminar se actualiza a {@link ImposibleCaminar}.
     */
    @Override
    public void verificarEstado() {
        if (nPatas < 2) {
            Carronia nuevaCarronia = new Carronia(this);
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cCaminar = new ImposibleCaminar();
            System.out.println(this.getNombre() + " se ha convertido en carroña y no podrá caminar.");
        }
    }

    /**
     * Método que determina si la araña puede comer el alimento proporcionado.
     * 
     * @param alimento El alimento a verificar.
     * @return true si el alimento es una instancia de {@link Hongo}, false en caso contrario.
     */
    @Override
    public boolean puedeComer(IAlimento alimento) {
        return (alimento instanceof Hongo);
    }

    /**
     * Método que simula la pérdida de una pata de la araña, decrementando el número
     * de patas y verificando el estado actual de la araña.
     */
    public void perderPata() {
        this.nPatas--;
        System.out.println(this.getNombre() + " ha perdido una pata, ahora tiene: " + nPatas);
        this.verificarEstado();
    }

    /**
     * Getter para obtener el número actual de patas de la araña.
     * 
     * @return El número de patas.
     */
    public int getnPatas() {
        return this.nPatas;
    }
}

