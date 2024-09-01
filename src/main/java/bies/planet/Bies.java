package bies.planet;

import bies.alimentacion.carronia.Carronia;
import bies.ente.SerVivoAbstracto;
import bies.ente.innombrable.InnombrableAbstracto;
import bies.ente.innombrable.cero.Innombrable;
import bies.ente.insecto.arana.Arana;
import bies.ente.insecto.InsectoAbstracto;
import bies.ente.insecto.mariposa.Mariposa;
import bies.ente.insecto.mosca.Mosca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 11:20 AM
 */

 /**
 * Clase principal que representa el planeta Bies, un lugar habitado por 
 * diferentes tipos de seres vivos. Esta clase se encarga de gestionar 
 * los seres vivos presentes, aplicar degradación a los mismos, y 
 * manejar la interacción entre ellos, como el consumo de carroñas.
 */
public class Bies {

    private List<SerVivoAbstracto> seresVivos = new ArrayList<>();

    /**
     * Agrega un nuevo ser vivo a la lista de seres vivos del planeta Bies.
     *
     * @param ser El ser vivo a agregar.
     * @return La instancia actual de Bies, permitiendo encadenamiento de métodos.
     */
    public Bies agregarSerVivo(SerVivoAbstracto ser) {
        seresVivos.add(ser);
        return this;
    }

    /**
     * Devuelve la lista de todos los seres vivos presentes en el planeta Bies.
     *
     * @return Lista de seres vivos.
     */
    public List<SerVivoAbstracto> getSeresVivos() {
        return seresVivos;
    }

    /**
     * Muestra en la consola la lista de todos los seres vivos presentes en 
     * el planeta Bies, junto con la cantidad total de seres.
     */
    public void mostrarSeres() {
        System.out.println("Mostrando los " + this.seresVivos.size()
                + " seres vivientes en el planeta Bies..");
        for (SerVivoAbstracto ser : seresVivos) {
            System.out.println("    -> " + ser.getNombre());
        }
    }

    /**
     * Obtiene una cadena de texto con los nombres de todos los seres vivos 
     * presentes en el planeta Bies.
     *
     * @return Una cadena de texto con los nombres de los seres vivos.
     */
    public String getNombreSeres() {
        StringBuilder sb = new StringBuilder();
        for (SerVivoAbstracto ser : seresVivos) {
            sb.append(ser.getNombre()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Aplica un proceso de degradación a cada ser vivo en el planeta Bies.
     * Este proceso incluye la posibilidad de perder partes del cuerpo y 
     * convierte algunos seres en carroña si corresponde. Luego, procesa 
     * el consumo de estas carroñas por otros seres.
     */
    public void aplicarDegradacion() {
        for (SerVivoAbstracto ser : seresVivos) {
            this.formateadorDeTitulo(ser.getNombre());
            this.formateadorDeSubtituloAcciones();
            if (ser instanceof InsectoAbstracto) {
                degradarInsecto((InsectoAbstracto) ser);
            } else if (ser instanceof InnombrableAbstracto) {
                Innombrable innombrable = (Innombrable) ser;
                innombrable.volar();
                innombrable.caminar();
            }
        }

        if (this.numeroDeCarronias() > 0) {
            mostrarCarronias();
            consumirCarronias();
        }
    }

    /**
     * Aplica el proceso de degradación a un insecto en particular, delegando 
     * a métodos específicos según el tipo de insecto.
     *
     * @param insecto El insecto a degradar.
     */
    private void degradarInsecto(InsectoAbstracto insecto) {
        if (insecto instanceof Mariposa) {
            degradarMariposa((Mariposa) insecto);
        } else if (insecto instanceof Arana) {
            degradarArana((Arana) insecto);
        } else if (insecto instanceof Mosca) {
            degradarMosca((Mosca) insecto);
        }

    }

    /**
     * Degrada una mariposa, permitiéndole volar y potencialmente perder 
     * un ala en el proceso.
     *
     * @param mariposa La mariposa a degradar.
     */
    private void degradarMariposa(Mariposa mariposa) {
        mariposa.volar();
        if (sePierdeParte(mariposa.getnAlas())) {
            mariposa.perderAla();
        }
    }

    /**
     * Degrada una araña, permitiéndole caminar y potencialmente perder 
     * una pata en el proceso.
     *
     * @param arana La araña a degradar.
     */
    private void degradarArana(Arana arana) {
        arana.caminar();
        if (sePierdeParte(arana.getnPatas())) {
            arana.perderPata();
        }
    }

    /**
     * Degrada una mosca, permitiéndole volar y caminar, y potencialmente 
     * perder alas y patas en el proceso.
     *
     * @param mosca La mosca a degradar.
     */
    private void degradarMosca(Mosca mosca) {
        mosca.volar();
        if (sePierdeParte(mosca.getnAlas())) {
            mosca.perderAla();
        }
        mosca.caminar();
        if (sePierdeParte(mosca.getnPatas())) {
            mosca.perderPata();
        }
    }

    /**
     * Imprime en consola un título formateado para indicar el inicio del 
     * procesamiento de un ser vivo en particular.
     *
     * @param nombre El nombre del ser vivo.
     */
    private void formateadorDeTitulo(String nombre) {
        System.out.println("- - - - - - - - - " + nombre + " - - - - - - - - -");
    }

    /**
     * Imprime en consola un subtítulo formateado para indicar el inicio de 
     * la lista de acciones realizadas por un ser vivo.
     */
    private void formateadorDeSubtituloAcciones() {
        System.out.println("---> Acciones:");
    }

    /**
     * Determina si una parte del cuerpo del ser vivo se pierde durante el 
     * proceso de degradación, basado en un cálculo aleatorio.
     *
     * @param partes El número total de partes que tiene el ser vivo.
     * @return true si una parte se pierde, false en caso contrario.
     */
    public boolean sePierdeParte(int partes) {
        return new Random().nextDouble() > 1.0 / partes;
    }

    /**
     * Cuenta el número de carroñas (seres vivos que han muerto y pueden 
     * ser consumidos) presentes en la lista de seres vivos del planeta Bies.
     *
     * @return El número de carroñas presentes.
     */
    private int numeroDeCarronias() {
        int numeroDeCarronias = 0;
        for (SerVivoAbstracto ser : seresVivos) {
            if (ser instanceof InsectoAbstracto && ((InsectoAbstracto) ser).esCarronia()) {
                numeroDeCarronias++;
            }
        }
        return numeroDeCarronias;
    }

    /**
     * Muestra en consola una lista de todos los seres vivos que han sido 
     * convertidos en carroñas después del proceso de degradación.
     */
    private void mostrarCarronias() {
        formateadorDeTitulo(" - > Carroñas < - ");
        System.out.println("Luego de aplicar la degradación, se generaron "
                + this.numeroDeCarronias() + " carroñas:");

        for (SerVivoAbstracto ser : seresVivos) {
            if (ser instanceof InsectoAbstracto && ((InsectoAbstracto) ser).esCarronia()) {
                System.out.println("    -> " + ser.getNombre());
            }
        }
    }

    private static final String ANSI_ORANGE = "\u001B[33m"; // Amarillo
    private static final String ANSI_BLUE = "\u001B[34m"; // Azul
    private static final String ANSI_RED = "\u001B[31m"; // Rojo
    private static final String ANSI_GREEN = "\u001B[32m"; // Verde
    private static final String ANSI_RESET = "\u001B[0m";

    /**
     * Procesa el consumo de carroñas por otros seres vivos, eliminando 
     * aquellos que han sido consumidos de la lista de seres vivos.
     */
    private void consumirCarronias() {
        formateadorDeTitulo(" - > Consumiendo las Carroñas < - ");
        List<SerVivoAbstracto> seresVivosConsumidos = new ArrayList<>();
        boolean hayCarroñasNoConsumidas = false;

        for (SerVivoAbstracto ser : seresVivos) {
            if (ser instanceof InsectoAbstracto) {
                procesarInsecto((InsectoAbstracto) ser, seresVivos, seresVivosConsumidos);
            }
        }

        eliminarSeresConsumidos(seresVivos, seresVivosConsumidos);
        hayCarroñasNoConsumidas = verificarCarroñasNoConsumidas(seresVivos);

        informarEstadoCarroñas(hayCarroñasNoConsumidas);
    }

    /**
     * Procesa un insecto en particular, intentando que este consuma una carroña 
     * si es posible, y añadiendo la carroña consumida a una lista de seres vivos 
     * eliminados.
     * 
     * @param insecto El insecto que intenta consumir una carroña.
     * @param seresVivos La lista de seres vivos actuales.
     * @param seresVivosConsumidos La lista de seres vivos que han sido consumidos.
     */
    private void procesarInsecto(InsectoAbstracto insecto, List<SerVivoAbstracto> seresVivos,
            List<SerVivoAbstracto> seresVivosConsumidos) {
        if (insecto.esCarronia()) {
            return;
        }

        boolean consumido = false;
        for (SerVivoAbstracto carroñaSer : seresVivos) {
            if (carroñaSer instanceof InsectoAbstracto && ((InsectoAbstracto) carroñaSer).esCarronia()) {
                if (intentarComerCarroña(insecto, (InsectoAbstracto) carroñaSer)) {
                    seresVivosConsumidos.add(carroñaSer);
                    consumido = true;
                    break;
                }
            }
        }
        if (!consumido) {
            informarNoEncontrado(insecto);
        }
    }

    /**
     * Intentar que el insecto coma la carroña
     * 
     * @param insecto El insecto que intentará comer la carroña.
     * @param carroñaSer El ser que representa la carroña.
     * @return true si el insecto comió la carroña, false en caso contrario.
     */
    private boolean intentarComerCarroña(InsectoAbstracto insecto, InsectoAbstracto carroñaSer) {
        Carronia carroña = carroñaSer.obtenerCarronia();
        if (insecto.puedeComer(carroña)) {
            insecto.comer(carroña);
            return true;
        } else {
            informarFallido(insecto, carroñaSer, carroña);
            return false;
        }
    }

    /**
     * Eliminar los seres vivos consumidos
     * 
     * @param seresVivos La lista de seres vivos presentes.
     * @param seresVivosConsumidos La lista de seres vivos que han sido consumidos y deben ser eliminados.
     */
    private void eliminarSeresConsumidos(List<SerVivoAbstracto> seresVivos,
            List<SerVivoAbstracto> seresVivosConsumidos) {
        seresVivos.removeAll(seresVivosConsumidos);
    }

    /**
     * Verificar si hay carroñas que no han sido consumidas
     * 
     * @param seresVivos
     * @return true si hay carroñas no consumidas false si no hay carroñas no consumidas
     */
    private boolean verificarCarroñasNoConsumidas(List<SerVivoAbstracto> seresVivos) {
        for (SerVivoAbstracto ser : seresVivos) {
            if (ser instanceof InsectoAbstracto && ((InsectoAbstracto) ser).esCarronia()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Informar el estado de las carroñas
     * 
     * @param hayCarroñasNoConsumidas
     */
    private void informarEstadoCarroñas(boolean hayCarroñasNoConsumidas) {
        if (hayCarroñasNoConsumidas) {
            System.out.println(
                    ANSI_BLUE + "Aún quedan carroñas que no han sido comidas." + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Todas las carroñas han sido comidas." + ANSI_RESET);
        }
    }

    /**
     * Informar que el insecto no pudo comer la carroña
     * 
     * @param insecto
     * @param carroñaSer
     * @param carroña
     */
    private void informarFallido(InsectoAbstracto insecto, SerVivoAbstracto carroñaSer, Carronia carroña) {
        System.out.println(insecto.getNombre() + " trató de comer a " + carroñaSer.getNombre()
                + " pero no quizo..");
        System.out.println("    MOTIVO: " + ANSI_RED + insecto.getNombre() + " no come "
                + carroña.insectoOriginal().getNombre() + " (carroña) :( " + ANSI_RESET);
    }

    /**
     * Informar que el insecto no encontró carroñas
     * 
     * @param insecto
     */
    private void informarNoEncontrado(InsectoAbstracto insecto) {
        System.out.println(ANSI_ORANGE + insecto.getNombre()
                + " no encontró carroñas que pueda comer." + ANSI_RESET);
    }

}
