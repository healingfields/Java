package ma.showMaker;

public class Article {
    String nom;
    String marque;
    float prix;
    int tva;


    public Article(){

    }
    public Article(String nom,String marque,float prix,int tva){
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.tva = tva;
    }

    public Article(Article article){
        this.nom = article.nom;
        this.marque = article.marque;
        this.prix = article.prix;
        this.tva = article.tva;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public String toString(){
        return this.nom + " " + this.marque + " " + this.prix + " " + this.tva;
     }

}
