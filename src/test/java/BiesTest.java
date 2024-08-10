import bies.ente.insecto.arana.Arana;
import bies.ente.insecto.mariposa.Mariposa;
import bies.ente.insecto.mosca.Mosca;
import bies.planet.Bies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiesTest {

  @Test
  public void testAgregarSerVivo() {
    Bies bies = new Bies();
    Arana arana = new Arana("Viuda Negra");
    bies.agregarSerVivo(arana);
    assertEquals(1, bies.getSeresVivos().size());
  }

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
