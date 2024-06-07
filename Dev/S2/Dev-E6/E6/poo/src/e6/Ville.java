package e6;

import fr.ulille.but.sae_s2_2024.Lieu;

/**
 * Ville
 * Implémente l'interface Lieu, 
 * prend en paramètre le nom de la ville
 * Possède une méthode toString() et equals()
 */
public class Ville implements Lieu {
    private String nom;

    public Ville(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Ville other = (Ville) obj;

        if (nom == null) {
            if (other.nom != null) return false;
        } else if (!nom.equals(other.nom)) {
            return false;
        }

        return true;
    }
}