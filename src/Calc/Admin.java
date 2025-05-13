package Calc;

import Entity.*;

import java.util.Scanner;

public class Admin {

    public static void mainAdmin(User U){

        Scanner Clavier = new Scanner(System.in);

        System.out.println("Que Voulez Vous ? : ");
        System.out.println("1 - Créer Un élement");
        System.out.println("2 - Bannir un élement");
        System.out.println("3 - Créer Une Course");
        System.out.println("4 - Affichage des Statistiques");

        int x = Clavier.nextInt();
        Clavier.nextLine();

        switch (x){
            case 1:
                System.out.println("Création d'un élement, Que Voulez vous ? :");
                System.out.println("0 - Retour");
                System.out.println("1 - User");
                System.out.println("2 - Passager");
                System.out.println("3 - Chauffeur");
                int y = Clavier.nextInt();    Clavier.nextLine();
                switch (y){
                    case 0 : break;
                    case 1:
                        User X = Gestion.createUser();
                        Gestion.addUser(X);
                        break;
                    case 2 :
                        System.out.println("A partir d'un user déja existant ? (y/n) : ");
                        String test = Clavier.nextLine();
                        if(test.toUpperCase().equals("Y")){

                            System.out.println("Entrer Son Matricule : ");

                        }
                        else{
                            User A = Gestion.createUser();
                            Gestion.createPassager(A);
                        }

                        break;
                    case 3 :

                        break;
                }

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("Que Voulez Vous Voir : ");
                System.out.println("1 - Top 10 de ... ");
                System.out.println("2 - Pires 10 de ... ");
                System.out.println("3 - Nombre de ...");
                System.out.println("4 - Quelles ... proposent le plus de ...");

                int a = Clavier.nextInt(); Clavier.nextLine();

                switch (a){
                    case 1 :
                        System.out.println("Top 10 de ? :");
                        System.out.println("0 - Retour");
                        System.out.println("1 - Chauffeur");
                        System.out.println("2 - Passager");
                        int b = Clavier.nextInt();   Clavier.nextLine();

                        switch (b){
                            case 0 : break;
                            case 1 :
                                Passager[] P = Gestion.getTop10Passagers();
                                System.out.println("Top 10 PASSAGERS : ");
                                for(int i = 0; i < P.length; i++){
                                    System.out.println(i + 1 + " - Matricule : "+ P[i].getMatricule() +",Nom : " + P[i].getNom() + ", Prénom : " + P[i].getPrenom() + ", Réputation : " + P[i].getReputation());
                                }
                                break;
                            case 2 :
                                Chauffeur[] C = Gestion.getTop10Chauffeurs();
                                System.out.println("Top 10 CHAUFFEURS : ");
                                for(int i = 0; i < C.length; i++){
                                    System.out.println(i + 1 + " - Matricule : "+ C[i].getMatricule() +", Nom : " + C[i].getNom() + ", Prénom : " + C[i].getPrenom() + ", Réputation : " + C[i].getReputation());
                                }
                                break;
                        }
                        break;
                    case 2 :
                        System.out.println("Pires 10 de ? :");
                        System.out.println("0 - Retour");
                        System.out.println("1 - Chauffeur");
                        System.out.println("2 - Passager");


                        int c = Clavier.nextInt();   Clavier.nextLine();

                        switch (c){
                            case 0 : break;
                            case 1 :
                                Passager[] P = Gestion.getWorst10Passagers();
                                System.out.println("Pires 10 PASSAGERS : ");
                                for(int i = 0; i < P.length; i++){
                                    System.out.println(i + 1 + " - Matricule : "+ P[i].getMatricule() + ", Nom : " + P[i].getNom() + ", Prénom : " + P[i].getPrenom() + ", Réputation : " + P[i].getReputation());
                                }
                                break;
                            case 2 :
                                Chauffeur[] C = Gestion.getWorst10Chauffeurs();
                                System.out.println("Pires 10 CHAUFFEURS : ");
                                for(int i = 0; i < C.length; i++){
                                    System.out.println(i + 1 + " - Matricule : " + C[i].getMatricule() + ", Nom : " + C[i].getNom() + ", Prénom : " + C[i].getPrenom() + ", Réputation : " + C[i].getReputation());
                                }
                                break;
                        }

                        break;
                    case 3 :
                        break;
                    case 4 :

                        break;
                }
                break;
        }

    }
}
