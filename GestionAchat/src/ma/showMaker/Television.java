package ma.showMaker;

public class Television extends Electromenager{

    int taille;

    public Television(String nom, String marque, float prix, int tva, int puissance, int garantie ,int taille) {
        super(nom, marque, prix, tva, puissance, garantie);
        this.taille = taille;
    }

    public Television(Article article, Electromenager electromenager ,int taille) {
        super(article,electromenager);
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.taille;
    }
}
