class Poule {
    private String nom;        // Nom de la poule
    private int nbOeufs;       // Nombre d’oeufs pondus

    public Poule(String s) {
        nom = s;
    }

    class OeufdePoule implements Oeuf {
        int oeufId = nbOeufs;
        public Object eclore() {
            Poule p = new Poule(nom + oeufId);
            System.out.println(p.nom + " sort de l'oeuf #" + oeufId + " de " + nom);
            return p;
        }
    }

    public Oeuf pondre() {     // Ponte d’un oeuf (de Poule)
        System.out.println(nom + " pond son oeuf #" + ++nbOeufs);
        return new OeufdePoule();
    }
}

