package bies.ente.insecto.mariposa;

import bies.alimentacion.Alimento;
import bies.comportamiento.volar.IComportamientoVolar;
import bies.comportamiento.volar.imposibleVolar.ImposibleVolar;
import bies.comportamiento.volar.posibleVolar.PosibleVolar;
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
 * Clase que representa una mariposa, extendiendo {@link InsectoAbstracto}.
 * 
 * Esta clase concreta implementa el comportamiento específico de una mariposa,
 * incluyendo el número de alas y la capacidad de volar. También gestiona
 * el cambio de estado en caso de pérdida de alas y la verificación de alimentos
 * que puede consumir.
 */
public class Mariposa extends InsectoAbstracto {

    // Número inicial de alas de la mariposa.
    private int nAlas = 2;
    
    // Comportamiento de volar asociado a la mariposa.
    private IComportamientoVolar cVolar;

    /**
     * Constructor que inicializa el nombre de la mariposa y asigna un comportamiento
     * de volar posible.
     * 
     * @param nombre El nombre de la mariposa.
     */
    public Mariposa(String nombre) {
        super(nombre);
        this.cVolar = new PosibleVolar();
    }

    /**
     * Método que permite a la mariposa volar, ejecutando el comportamiento de volar
     * asociado.
     */
    public void volar() {
        this.cVolar.ejecutar();
    }

    /**
     * Método para verificar el estado de la mariposa. Si el número de alas es menor que 2,
     * la mariposa se convierte en carroña y cambia su estado a {@link EstadoCarronia}.
     * Además, el comportamiento de volar se actualiza a {@link ImposibleVolar}.
     */
    @Override
    public void verificarEstado() {
        if (nAlas < 2) {
            Alimento nuevaCarronia = new Alimento("Mariposa");
            this.cambiarEstado(new EstadoCarronia(nuevaCarronia));
            this.cVolar = new ImposibleVolar();
            System.out.println(this.getNombre() + " se ha convertido en carroña y no podrá volar.");
        }
    }

    /**
     * Método que determina si la mariposa puede comer el alimento proporcionado.
     * 
     * @param alimento El alimento a verificar.
     * @return true si el alimento es una instancia de {@link Alimento}, false en caso contrario.
     */
    @Override
    public boolean puedeComer(Alimento alimento) {
        return alimento.nombre() == "Miel";
    }

    /**
     * Método que simula la pérdida de un ala de la mariposa, decrementando el número
     * de alas y verificando el estado actual de la mariposa.
     */
    public void perderAla() {
        this.nAlas--;
        System.out.println(this.getNombre() + " ha perdido un ala, ahora tiene: " + nAlas);
        this.verificarEstado();
    }

    /**
     * Getter para obtener el número actual de alas de la mariposa.
     * 
     * @return El número de alas.
     */
    public int getnAlas() {
        return nAlas;
    }
}
