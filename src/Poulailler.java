import java.net.PortUnreachableException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Poulailler {
    private int tour;                             // Numéro de tour dans la simulation
    private LinkedList<Poule> poules = new LinkedList<>(); // Poules du poulailler
    private Random random = new Random();         // Générateur aléatoire

    public void ajouter(Poule p) {                // Ajout d’une poule dans le poulailler
        poules.add(p);
    }

    public void tour() {                          // Nouveau tour (ponte + eclosion)
        // incrémenter le compteur de tours
        System.out.println("-- Tour #" + ++tour);
        // création de la liste (vide) d'oeufs
        List<Oeuf> oeufs = new LinkedList<>();

        // ponte des oeufs
        for (Poule p : poules) {
            int count = random.nextInt(3);
            for (int i = 0; i < count; i++)
                oeufs.add(p.pondre());
        }

        // éclosion des oeufs
        for (Oeuf o : oeufs) {
            // ajout des nouvelles poules
            poules.add((Poule)o.eclore());
        }
    }

    public static void main(String[] args) {      // Démarrer la simulation
        Poulailler p = new Poulailler();            // d’un poulailler

        p.ajouter(new Poule("Cocotte"));            // possédeant au départ 2 poules
        p.ajouter(new Poule("Rosette"));

        for (int i = 0; i < 10; i++)                // sur 10 tours
            p.tour();
    }
}
