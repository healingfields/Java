package ma.showMaker;

public class Electromenager extends Article{

    int puissance,garantie;

    public Electromenager(){

    }

    public Electromenager(String nom, String marque, float prix, int tva, int puissance,int garantie) {
        super(nom, marque, prix, tva);
        this.puissance = puissance;
        this.garantie = garantie;
    }

    public Electromenager(Article article, int puissance,int garantie) {
        super(article);
        this.puissance = puissance;
        this.garantie = garantie;
    }

    public Electromenager(Article article,Electromenager electromenager) {
        super(article);
        this.puissance = electromenager.puissance;
        this.garantie = electromenager.garantie;
    }



    @Override
    public String toString() {
        return super.toString() + " " + this.puissance + " " + this.garantie;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }
}
