import fr.ulille.but.sae_s2_2024.ModaliteTransport;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import e6.Arrete;
import e6.TypeCout;
import e6.Ville;

public class TestVoyageur {

    @Test
    public void testCalculerItineraire() {
        // Définir les villes
        Ville lille = new Ville("Lille");
        Ville paris = new Ville("Paris");
        Ville lyon = new Ville("Lyon");
        Ville marseille = new Ville("Marseille");

        // Définir les arêtes
        Map<TypeCout, Double> coutsTrain = new HashMap<>();
        coutsTrain.put(TypeCout.PRIX, 50.0);
        coutsTrain.put(TypeCout.CO2, 10.0);
        coutsTrain.put(TypeCout.TEMPS, 1.0);
        Arrete arreteTrainLilleParis = new Arrete(lille, paris, ModaliteTransport.TRAIN, coutsTrain);

        Map<TypeCout, Double> coutsAvion = new HashMap<>();
        coutsAvion.put(TypeCout.PRIX, 100.0);
        coutsAvion.put(TypeCout.CO2, 20.0);
        coutsAvion.put(TypeCout.TEMPS, 0.5);
        Arrete arreteAvionParisMarseille = new Arrete(paris, marseille, ModaliteTransport.AVION, coutsAvion);

        Map<TypeCout, Double> coutsBus = new HashMap<>();
        coutsBus.put(TypeCout.PRIX, 30.0);
        coutsBus.put(TypeCout.CO2, 5.0);
        coutsBus.put(TypeCout.TEMPS, 2.0);
        Arrete arreteBusLyonMarseille = new Arrete(lyon, marseille, ModaliteTransport.BUS, coutsBus);

        // Construire le graphe
        Map<Ville, Map<ModaliteTransport, Arrete>> graphe = new HashMap<>();
        graphe.put(lille, Map.of(ModaliteTransport.TRAIN, arreteTrainLilleParis));
        graphe.put(paris, Map.of(ModaliteTransport.AVION, arreteAvionParisMarseille));
        graphe.put(lyon, Map.of(ModaliteTransport.BUS, arreteBusLyonMarseille));
        graphe.put(marseille, Map.of());

        // Calculer l'itinéraire
        List<Arrete> itineraire = new ArrayList<>();
        itineraire.add(arreteTrainLilleParis);
        itineraire.add(arreteAvionParisMarseille);

        // Vérifier le résultat
        assertEquals(2, itineraire.size());
        assertEquals(arreteTrainLilleParis, itineraire.get(0));
        assertEquals(arreteAvionParisMarseille, itineraire.get(1));
        double prixTotal = arreteTrainLilleParis.getCout().get(TypeCout.PRIX) + arreteAvionParisMarseille.getCout().get(TypeCout.PRIX);
        double co2Total = arreteTrainLilleParis.getCout().get(TypeCout.CO2) + arreteAvionParisMarseille.getCout().get(TypeCout.CO2);
        double tempsTotal = arreteTrainLilleParis.getCout().get(TypeCout.TEMPS) + arreteAvionParisMarseille.getCout().get(TypeCout.TEMPS);
        assertTrue(150.0 == prixTotal);
        assertTrue(30.0 == co2Total);
        assertTrue(1.5 == tempsTotal);
    }
}