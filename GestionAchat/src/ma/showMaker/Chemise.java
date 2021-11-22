package ma.showMaker;

import java.awt.*;

public class Chemise extends Vestimentaire{

    Boolean manche;

    public Chemise(){
        super();

    }

    public Chemise(String nom, String marque, float prix, int tva, int taille, Color couleur, Categorie cible,boolean manche) {
        super(nom, marque, prix, tva, taille, couleur, cible);
        this.manche = manche;
    }

    public Chemise(Article article, Vestimentaire vestimentaire,boolean manche) {
        super(article,vestimentaire);
        this.manche = manche;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.manche;
    }
}
