package ma.showMaker;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    //creation des articles
      Article a1 = new Article("a1","m1",10,5);
      Article a2 = new Article("a2","m2",10,5);

    //creation des articles de type vestimentaire
      Vestimentaire v1 = new Vestimentaire(a1,15, Color.red,Categorie.HOMME);
      Vestimentaire v2 = new Vestimentaire(a2,10, Color.black,Categorie.FEMME);

      //creation des articles de type electromenager
      Electromenager e1 = new Electromenager(a1,10,3);
      Electromenager e2 = new Electromenager(a1,25,4);

    //creation des pantalons
      Pantalon p1 = new Pantalon(a1,v1,20);
      Pantalon p2 = new Pantalon(a2,v2,15);

    //creation des chemises
        Chemise ch1 = new Chemise(a1,v1,true);
        Chemise ch2 = new Chemise(a2,v2,false);

    //creation des televisions
        Television tv1 = new Television(a1,e1,50);
        Television tv2 = new Television(a2,e2,23);

    //creation des refrigerateur
        Refrigerateur re1= new Refrigerateur(a1,e1,50);
        Refrigerateur re2= new Refrigerateur(a2,e2,54);

        System.out.println(a1);
        System.out.println(v1);
        System.out.println(e1);
        System.out.println(p1);
        System.out.println(ch1);
        System.out.println(tv1);
        System.out.println(re1);

        Client client= new Client("idriss",23,new ArrayList<Article>());
        client.ajouterArticleAuPanier(a1);
        client.ajouterArticleAuPanier(a2);
        System.out.println(client.panier.toString());
        client.supprimerArticleDuPanier(a1);
        System.out.println(client.panier.toString());
      client.ajouterArticleAuPanier(a2);
      System.out.println(client.panier.toString());






    }
}
