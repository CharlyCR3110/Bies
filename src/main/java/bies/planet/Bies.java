package bies.planet;

import bies.alimentacion.carronia.Carronia;
import bies.ente.SerVivoAbstracto;
import bies.ente.innombrable.InnombrableAbstracto;
import bies.ente.innombrable.cero.InnombrableCero;
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
public class Bies {
    private List<SerVivoAbstracto> seresVivos = new ArrayList<>();

    public Bies agregarSerVivo(SerVivoAbstracto ser) {
        seresVivos.add(ser);
        return this;
    }

    public List<SerVivoAbstracto> getSeresVivos() {
        return seresVivos;
    }

    public void mostrarSeres() {
        System.out.println("Mostrando los " + this.seresVivos.size()
                + " seres vivientes en el planeta Bies..");
        for (SerVivoAbstracto ser : seresVivos) {
            System.out.println("    -> " + ser.getNombre());
        }
    }

    public String getNombreSeres() {
        StringBuilder sb = new StringBuilder();
        for (SerVivoAbstracto ser : seresVivos) {
            sb.append(ser.getNombre()).append("\n");
        }
        return sb.toString();
    }

    public void aplicarDegradacion() {
        for (SerVivoAbstracto ser : seresVivos) {
            this.formateadorDeTitulo(ser.getNombre());
            this.formateadorDeSubtituloAcciones();
            if (ser instanceof InsectoAbstracto) {
                degradarInsecto((InsectoAbstracto) ser);
            } else if (ser instanceof InnombrableAbstracto) {
                InnombrableCero innombrable = (InnombrableCero) ser;
                innombrable.volar();
                innombrable.caminar();
            }
        }

        if (this.numeroDeCarronias() > 0) {
            mostrarCarronias();
            consumirCarronias();
        }
    }

    private void degradarInsecto(InsectoAbstracto insecto) {
        if (insecto instanceof Mariposa) {
            degradarMariposa((Mariposa) insecto);
        } else if (insecto instanceof Arana) {
            degradarArana((Arana) insecto);
        } else if (insecto instanceof Mosca) {
            degradarMosca((Mosca) insecto);
        }

    }

    private void degradarMariposa(Mariposa mariposa) {
        mariposa.volar();
        if (sePierdeParte(mariposa.getnAlas())) {
            mariposa.perderAla();
            mariposa.verificarEstado();
        }
    }

    private void degradarArana(Arana arana) {
        arana.caminar();
        if (sePierdeParte(arana.getnPatas())) {
            arana.perderPata();
            arana.verificarEstado();
        }
    }

    private void degradarMosca(Mosca mosca) {
        mosca.volar();
        if (sePierdeParte(mosca.getnAlas())) {
            mosca.perderAla();
        }
        mosca.caminar();
        if (sePierdeParte(mosca.getnPatas())) {
            mosca.perderPata();
        }
        mosca.verificarEstado();
    }

    private void formateadorDeTitulo(String nombre) {
        System.out.println("- - - - - - - - - " + nombre + " - - - - - - - - -");
    }

    private void formateadorDeSubtituloAcciones() {
        System.out.println("---> Acciones:");
    }

    public boolean sePierdeParte(int partes) {
        return new Random().nextDouble() > 1.0 / partes;
    }

    private int numeroDeCarronias() {
        int numeroDeCarronias = 0;
        for (SerVivoAbstracto ser : seresVivos) {
            if (ser instanceof InsectoAbstracto && ((InsectoAbstracto) ser).esCarronia()) {
                numeroDeCarronias++;
            }
        }
        return numeroDeCarronias;
    }

    private void mostrarCarronias() {
        formateadorDeTitulo(" - > Carroñas < - ");
        System.out.println("Luego de aplicar la degradación, se generaron "
                + this.numeroDeCarronias() + " carronias:");

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
     * Procesar el insecto
     * 
     * @param insecto
     * @param seresVivos
     * @param seresVivosConsumidos
     */
    private void procesarInsecto(InsectoAbstracto insecto, List<SerVivoAbstracto> seresVivos,
            List<SerVivoAbstracto> seresVivosConsumidos) {
        if (insecto.esCarronia()) {
            return;
        }

        boolean consumido = false;
        for (SerVivoAbstracto carroñaSer : seresVivos) {
            if (carroñaSer instanceof InsectoAbstracto
                    && ((InsectoAbstracto) carroñaSer).esCarronia()) {
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
     * @param insecto
     * @param carroñaSer
     * @return
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
     * @param seresVivos
     * @param seresVivosConsumidos
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
    private void informarFallido(InsectoAbstracto insecto, SerVivoAbstracto carroñaSer,
            Carronia carroña) {
        System.out.println(insecto.getNombre() + " trató de comer a " + carroñaSer.getNombre()
                + " pero no pudo.");
        System.out.println("    MOTIVO: " + ANSI_RED + insecto.getNombre() + " no come "
                + carroña.insectoOriginal().getNombre() + " :( " + ANSI_RESET);
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
