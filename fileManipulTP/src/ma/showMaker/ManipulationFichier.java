package ma.showMaker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipulationFichier {

    void afficherContenuRep(String nomRep){
        File doc = new File(nomRep);
        if(doc.isDirectory()){
            File T[];
            T=doc.listFiles();
            ArrayList<File> repList = new ArrayList<File>();
            ArrayList<File> fileList = new ArrayList<File>();
            System.out.println("------> le dossier "+nomRep+ " contient "+T.length+" documents :");
            System.out.println("************************************");
            for(File x : T){
                if(x.isDirectory())
                repList.add(x);
//                System.out.println("-Rep :"+x.getName() );
                if(x.isFile()){
                    fileList.add(x);
//                    System.out.println("-File :"+x.getName());
                }
            }
//            System.out.println("le dossier "+nomRep+ " contient "+T.length+" documents :");
            System.out.println("------> il y a "+repList.size()+ " dossier :");
            System.out.println("************************************");
            for(File r :repList){
                System.out.println(r.getName());
            }
            System.out.println("------> il y a "+fileList.size()+ " files :");
            System.out.println("************************************");
            for(File f:fileList){
                System.out.println(f.getName());
            }

        }
        else {
            System.out.println(nomRep + "n'est pas un repertoire");
        }
    }
    public void afficherContenuRep(){
        String dirPath;
        File f;
        do{
            System.out.println("veuillez saisir le nom du rep ");
            Scanner scanner=new Scanner(System.in);
            dirPath = scanner.nextLine();
            f = new File(dirPath);
        }
        while(!f.isDirectory());
        afficherContenuRep(dirPath);
    }
    public void creerFichier(){
        try {
            FileWriter fr = new FileWriter("/home/idriss/DevSection/Java/FormationTPs/fileManipulTP/src/file.txt");
            PrintWriter pw = new PrintWriter(fr);
            pw.println("Hii folks");
            pw.println("i'm idriss");
            pw.close();
            fr.close();
        }
        catch (Exception e) {
            System.out.println("creation impossible " + e.getMessage());
        }
    }
    public void afficherContenuFichier(String filePath){
        String message;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            do {
                message = br.readLine();
                System.out.println(message);
            }
            while (message!=null);
        }
        catch(Exception e){
            System.out.println("impossible de lire le fichier" + e.getMessage());
        }
    }
    public void ecrireMultipleDe5(){

    }
}
