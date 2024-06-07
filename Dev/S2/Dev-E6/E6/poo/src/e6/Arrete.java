package e6;

import java.util.HashMap;
import java.util.Map;

import fr.ulille.but.sae_s2_2024.Lieu;
import fr.ulille.but.sae_s2_2024.ModaliteTransport;
import fr.ulille.but.sae_s2_2024.Trancon;

/**
 * Arrete
 * Implémente l'interface Trancon,
 * prend en paramètre 2 Objets "Lieu" (départ et arrivé) puis une "ModaliteTransport" (TRAIN/AVION/BUS)
 * et un Map<TypeCout, Double>, "TypeCout" (PRIX/CO2/TEMPS) & "Double" la valeur attribuer pour TypeCount
 */
public class Arrete implements Trancon
{
    private Lieu depart;
    private Lieu arrivee;
    private ModaliteTransport modalite;
    private Map<TypeCout, Double> cout = new HashMap<TypeCout, Double>();

    public Arrete(Lieu depart, Lieu arrivee, ModaliteTransport modalite, Map<TypeCout, Double> cout) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.modalite = modalite;
        this.cout = cout;
    }

    public Map<TypeCout, Double> getCout() {
        return this.cout;
    }

    @Override
    public Lieu getDepart() {
        return this.depart;
    }

    @Override
    public Lieu getArrivee() {
        return this.arrivee;
    }

    @Override
    public ModaliteTransport getModalite() {
        return this.modalite;
    }

    @Override
    public String toString() {
        return this.depart + " -> " + this.arrivee;
    }
}