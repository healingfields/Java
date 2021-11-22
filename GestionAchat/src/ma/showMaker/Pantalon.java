package ma.showMaker;

import java.awt.*;

public class Pantalon extends Vestimentaire{

    int longueur;

    public Pantalon(String nom, String marque, float prix, int tva, int taille, Color couleur, Categorie cible,int longueur) {
        super(nom, marque, prix, tva, taille, couleur, cible);
        this.longueur = longueur;
    }

    public Pantalon(Article article, Vestimentaire vestimentaire ,int longueur) {
        super(article,vestimentaire);
        this.longueur = longueur;
    }


    @Override
    public String toString() {
        return super.toString() + " " + this.longueur;
    }
}
