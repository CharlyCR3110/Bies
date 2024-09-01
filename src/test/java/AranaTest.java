import bies.alimentacion.carronia.Carronia;
import bies.alimentacion.miel.Miel;
import bies.ente.insecto.arana.Arana;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la clase AranaTest.
 * Utiliza JUnit para verificar el comportamiento esperado de los métodos de la clase Arana.
 */
public class AranaTest {
    /**
     * Verifica que una instancia de Arana no es carroña y, por lo tanto, puede caminar.
     * 
     * Este test asegura que el método esCarronia() de la clase Arana devuelve false,
     * indicando que el objeto Arana no está en el estado de carroña y puede caminar.
     */
    @Test
    public void testAranaPuedeCaminar() {
        Arana arana = new Arana("Viuda Negra");
        assertTrue(!arana.esCarronia());
    }

    /**
     * Verifica que una instancia de Arana no puede comer miel.
     * 
     * Este test asegura que el método puedeComer() de la clase Arana devuelve false
     * cuando se le pasa un objeto de tipo Miel, indicando que la araña no puede consumir miel.
     */
    @Test
    public void testAranaNoPuedeComerMiel() {
        Arana arana = new Arana("Viuda Negra");
        Miel miel = new Miel();
        assertFalse(arana.puedeComer(miel));
    }

    /**
     * Verifica que una instancia de Arana no puede comer carroña.
     * 
     * Este test asegura que el método puedeComer() de la clase Arana devuelve false
     * cuando se le pasa un objeto de tipo Carronia, indicando que la araña no puede consumir carroña.
     */
    @Test
    public void testAranaPuedeComerCarronia() {
        Arana arana = new Arana("Viuda Negra");
        Carronia carronia = new Carronia(arana);
        assertFalse(arana.puedeComer(carronia));
    }
}
