class Carte {
    private Valeur valeur;
    private Couleur couleur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}