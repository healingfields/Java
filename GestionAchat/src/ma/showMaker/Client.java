package ma.showMaker;

import java.util.ArrayList;

public class Client {

    String nom;
    int age;
    ArrayList<Article> panier ;

    public Client(){

    }

    public Client(String nom, int age, ArrayList<Article> panier) {
        this.nom = nom;
        this.age = age;
        this.panier = panier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Article> getPanier() {
        return panier;
    }

    public void setPanier(ArrayList<Article> panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", panier=" + panier +
                '}';
    }

    public void ajouterArticleAuPanier(Article artAajouter){

        boolean exist = this.panier.stream()
                .anyMatch(article -> article.nom.equals(artAajouter.nom));
        if(exist){
            System.out.println("cet article fait partie du panier");
        }
        else{
            this.panier.add(artAajouter);
        }
    }

    public void supprimerArticleDuPanier(Article artAsupprimer){
        boolean exist = this.panier.stream()
                .anyMatch(article -> article.nom.equals(artAsupprimer.nom));
        if(exist){
           this.panier.remove(artAsupprimer);
        }
        else{
            System.out.println("article fait pas partie du panier");
        }
    }
}
