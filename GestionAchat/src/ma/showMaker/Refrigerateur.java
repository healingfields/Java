package ma.showMaker;

public class Refrigerateur extends Electromenager{

    int volume;

    public Refrigerateur(String nom, String marque, float prix, int tva, int puissance, int garantie,int volume) {
        super(nom, marque, prix, tva, puissance, garantie);
        this.volume = volume;
    }

    public Refrigerateur(Article article,Electromenager electromenager,int volume) {
        super(article,electromenager);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + " " +this.volume;
    }
}
