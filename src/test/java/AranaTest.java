import bies.alimentacion.carronia.Carronia;
import bies.alimentacion.miel.Miel;
import bies.ente.insecto.arana.Arana;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class AranaTest {
  // si no es una carroña, entonces puede caminar
  @Test
  public void testAranaPuedeCaminar() {
    Arana arana = new Arana("Viuda Negra");
    assertTrue(!arana.esCarronia());
  }

  @Test
  public void testAranaNoPuedeComerMiel() {
    Arana arana = new Arana("Viuda Negra");
    Miel miel = new Miel();
    assertFalse(arana.puedeComer(miel));
  }

  @Test
  public void testAranaPuedeComerCarronia() {
    Arana arana = new Arana("Viuda Negra");
    Carronia carronia = new Carronia(arana);
    assertFalse(arana.puedeComer(carronia));
  }
}
