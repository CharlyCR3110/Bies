import bies.ente.insecto.arana.Arana;
import bies.ente.insecto.mariposa.Mariposa;
import bies.ente.insecto.mosca.Mosca;
import bies.planet.Bies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de pruebas unitarias para la clase Bies.
 * Utiliza JUnit para verificar el comportamiento esperado de los métodos de la clase Bies.
 */
public class BiesTest {
    /**
     * Verifica que se puede agregar un SerVivo a una instancia de Bies.
     * 
     * Este test asegura que al agregar un objeto de tipo Arana a una instancia de Bies,
     * el tamaño de la lista de seres vivos en Bies aumenta a 1, indicando que el ser vivo
     * ha sido correctamente agregado.
     */
    @Test
    public void testAgregarSerVivo() {
        Bies bies = new Bies();
        Arana arana = new Arana("Viuda Negra");
        bies.agregarSerVivo(arana);
        assertEquals(1, bies.getSeresVivos().size());
    }

     /**
     * Verifica que los seres vivos en una instancia de Bies se muestran correctamente.
     * 
     * Este test asegura que al agregar objetos de tipo Mosca y Mariposa a una instancia de Bies,
     * el método getNombreSeres() devuelve una cadena de texto con los nombres de los seres vivos
     * separados por saltos de línea, en el orden en que fueron agregados.
     */
    @Test
    public void testMostrarSeres() {
        Bies bies = new Bies();
        Mosca mosca = new Mosca("Mosca domestica");
        Mariposa mariposa = new Mariposa("Morpho Azul");
        bies.agregarSerVivo(mosca).agregarSerVivo(mariposa);

        String expectedOutput = "Mosca domestica\nMorpho Azul\n";
        assertEquals(expectedOutput, bies.getNombreSeres());
    }
}
