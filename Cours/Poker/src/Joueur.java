import java.util.List;

public class Joueur {
    private String nom;
    private List<Carte> main;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void setMain(List<Carte> main) {
        this.main = main;
    }

    public String getNom() {
        return nom;
    }

    public List<Carte> getMain() {
        return main;
    }

    @Override
    public String toString() {
        return nom + " : " + main;
    }
}
