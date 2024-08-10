import bies.ente.insecto.estado.carronia.EstadoCarronia;
import bies.ente.insecto.arana.Arana;
import bies.alimentacion.carronia.Carronia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsectoAbstractoTest {

    @Test
    public void testInsectoCambiaEstadoACarronia() {
        Arana arana = new Arana("Viuda Negra");

        EstadoCarronia estadoCarronia = new EstadoCarronia(new Carronia(arana));
        arana.cambiarEstado(estadoCarronia);

        assertTrue(arana.esCarronia());
    }

    @Test
    public void testObtenerCarronia() {
        Arana arana = new Arana("Viuda Negra");
        while (arana.getnPatas() > 1) {
            arana.perderPata();
        }

        Carronia carronia = arana.obtenerCarronia();
        assertNotNull(carronia);
    }
}
