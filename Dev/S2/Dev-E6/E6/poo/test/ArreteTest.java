import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import e6.Arrete;
import e6.TypeCout;
import e6.Ville;
import fr.ulille.but.sae_s2_2024.Lieu;
import fr.ulille.but.sae_s2_2024.ModaliteTransport;

/**
 * ArreteTest
 */
public class ArreteTest {
    private Arrete arrete;

    private Lieu depart = new Ville("Lille");
    private Lieu arrivee = new Ville("Paris");
    private ModaliteTransport modalite = ModaliteTransport.TRAIN;
    private Map<TypeCout, Double> cout = new HashMap<TypeCout, Double>();

    @BeforeEach
    public void initialization() {
        cout.put(TypeCout.CO2, 79.0);
        cout.put(TypeCout.PRIX, 68.0);
        cout.put(TypeCout.TEMPS, 62.0);
    }
    
    @Test
    public void test1() {
        arrete = new Arrete(depart, arrivee, modalite, cout);
        assertEquals(new Ville("Lille"), depart);
        assertEquals(new Ville("Paris"), arrivee);
        assertEquals(ModaliteTransport.TRAIN, modalite);
        assertEquals(arrete.getCout(), cout);
    }

    @Test
    public void test2() {
        arrete = new Arrete(depart, arrivee, modalite, cout);
        assertEquals(arrete.getDepart(), depart);
        assertEquals(arrete.getArrivee(), arrivee);
        assertEquals(arrete.getModalite(), modalite);
        assertEquals(arrete.getCout(), cout);
    }
}