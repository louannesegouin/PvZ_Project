import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Paquet {
    private static final int NB_CARTES = 52;
    private ArrayList<Carte> paquet;

    public Paquet() {
        paquet = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                paquet.add(new Carte(Couleur.values()[i], Valeur.values()[j]));
            }
        }
    }

    public void trierParCouleur() {
        paquet.sort((c1, c2) -> c1.getCouleur().compareTo(c2.getCouleur()));
    }

    public List<Carte> melanger() {
        Collections.shuffle(paquet);
        return paquet;
    }

    public List<Carte> piocher(int nombre){
        List<Carte> cartesPiochees = new ArrayList<>();
        for (int i = 0; i < nombre && !paquet.isEmpty(); i++) { // empêche de piocher si le paquet est vide
            cartesPiochees.add(paquet.remove(0));
        }
        return cartesPiochees;
    }

    public List<List<Carte>> distribuer(int nbJoueurs, int nbCartesParJoueur) {
        List<List<Carte>> mains = new ArrayList<>();
        if (nbJoueurs * nbCartesParJoueur > paquet.size()) {
            throw new IllegalArgumentException("Pas assez de cartes pour distribuer à " + nbJoueurs + " joueurs.");
        }
        for (int i = 0; i < nbJoueurs; i++) {
            mains.add(new ArrayList<>());
        }
        for (int i = 0; i < nbCartesParJoueur; i++) {
            for (int j = 0; j < nbJoueurs; j++) {
                mains.get(j).add(paquet.remove(0));
            }
        }
        return mains;
    }

}


