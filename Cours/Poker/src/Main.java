public class Main {
    public static void main(String[] args) {
        PartiePoker partie = new PartiePoker();
        String[] nomsJoueurs = {"Alice", "Bob", "Charlie"};
        partie.initialiserJoueurs(3, nomsJoueurs);
        partie.jouer(5);
    }
}
