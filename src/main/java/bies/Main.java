package bies;

import bies.ente.insecto.arana.Arana;
import bies.ente.insecto.mariposa.Mariposa;
import bies.ente.insecto.mosca.Mosca;
import bies.planet.Bies;

/**
 * @author Carlos G. G.
 * @author Isaac F. B. C.
 * @author Raquel A. B.
 * @author Samuel A. R.
 * @version 1.0
 * @since 8/7/2024 - 10:58 AM
 */

public class Main {
    public static void main(String[] args) {
        Bies bies = new Bies();

        Arana arana_1 = new Arana("Viuda Negra");
        Mosca mosca_1 = new Mosca("Mosca domestica");
        Mariposa mariposa_1 = new Mariposa("Morpho Azul");

        bies.agregarSerVivo(arana_1).agregarSerVivo(mosca_1).agregarSerVivo(mariposa_1);

        bies.mostrarSeres();

        bies.aplicarDegradacion();

        System.out.println("\n\n--> FIN ;) <--");

    }
}
