import java.util.ArrayList;
import java.util.List;

public class PartiePoker {
    private List<Joueur> joueurs;
    private Paquet paquet;

    public PartiePoker() {
        this.joueurs = new ArrayList<>();
        this.paquet = new Paquet();
    }

    public void initialiserJoueurs(int nbJoueurs, String[] nomsJoueurs) {
        if (nbJoueurs < 2) {
            System.out.println("Il faut au moins 2 joueurs !");
            return;
        }

        if (nomsJoueurs.length != nbJoueurs) {
            System.out.println("Erreur : Le nombre de noms ne correspond pas au nombre de joueurs !");
            return;
        }

        for (int i = 0; i < nbJoueurs; i++) {
            joueurs.add(new Joueur(nomsJoueurs[i]));
        }

        System.out.println("Tous les joueurs ont été créés !");
    }

    public void jouer(int nbCartesParJoueur) {
        if (joueurs.size() < 2) {
            System.out.println("Pas assez de joueurs pour jouer !");
            return;
        }

        paquet.melanger();
        System.out.println("Distribution de " + nbCartesParJoueur + " cartes par joueur...");

        List<List<Carte>> mains = paquet.distribuer(joueurs.size(), nbCartesParJoueur);
        for (int i = 0; i < joueurs.size(); i++) {
            joueurs.get(i).setMain(mains.get(i));
        }

        System.out.println("\nMains des joueurs :");
        for (Joueur joueur : joueurs) {
            System.out.println(joueur);
        }
    }
}
