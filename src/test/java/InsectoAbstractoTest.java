import bies.alimentacion.Alimento;
import bies.ente.insecto.estado.carronia.EstadoCarronia;
import bies.ente.insecto.arana.Arana;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Clase de pruebas unitarias para la clase InsectoAbstracto.
 * Utiliza JUnit para verificar el comportamiento esperado de los métodos relacionados con el estado de un insecto.
 */
public class InsectoAbstractoTest {

    /**
     * Verifica que un insecto puede cambiar su estado a `EstadoCarronia`.
     * 
     * Este test asegura que al cambiar el estado de un objeto `Arana` a una instancia de `EstadoCarronia`,
     * el método `esCarronia()` devuelve `true`, indicando que el insecto ahora se considera una carroña.
     */
    @Test
    public void testInsectoCambiaEstadoACarronia() {
        Arana arana = new Arana("Viuda Negra");

        EstadoCarronia estadoCarronia = new EstadoCarronia(new Alimento("Arana"));
        arana.cambiarEstado(estadoCarronia);

        assertTrue(arana.esCarronia());
    }

    /**
     * Verifica que el método `obtenerCarronia()` retorna una carroña no nula.
     * 
     * Este test asegura que después de reducir el número de patas del insecto a 1 (suponiendo que esto
     * representa una condición en la que el insecto debería convertirse en carroña), el método 
     * `obtenerCarronia()` devuelve una instancia de `Carronia` que no es nula.
     */
    @Test
    public void testObtenerCarronia() {
        Arana arana = new Arana("Viuda Negra");
        while (arana.getnPatas() > 1) {
            arana.perderPata();
        }

        Alimento carronia = arana.obtenerCarronia();
        assertNotNull(carronia);
    }
}
