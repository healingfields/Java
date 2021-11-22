package ma.showMaker;

import java.awt.*;

public class Vestimentaire extends Article{

    int taille;
    Color couleur;
    Categorie cible;

    public Vestimentaire(){

    }

    public Vestimentaire(String nom, String marque, float prix, int tva,int taille,Color couleur,Categorie cible) {
        super(nom, marque, prix, tva);
        this.taille = taille;
        this.couleur = couleur;
        this.cible = cible;
    }

    public Vestimentaire(Article article,int taille,Color couleur,Categorie cible) {
        super(article);
        this.taille = taille;
        this.couleur = couleur;
        this.cible = cible;
    }
    public Vestimentaire(Article article,Vestimentaire vestimentaire) {
        super(article);
        this.taille = vestimentaire.taille;
        this.couleur = vestimentaire.couleur;
        this.cible = vestimentaire.cible;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Categorie getCible() {
        return cible;
    }

    public void setCible(Categorie cible) {
        this.cible = cible;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.taille+ " " + this.couleur + " " + this.cible ;
    }
}
