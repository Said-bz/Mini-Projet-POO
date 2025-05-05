package Calc;
import Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Creation {

    /*
        Class Creation contient des methodes Static pour faciliter l'ecriture Du Main pour eviter
        les Grandes lignes de Saisie de Données, Améliorant sa lisibilité.

        En + si on veut modifier une donnée à saisir, on le modifie qu'une seule fois
     */

    //(said)
    public static User createUser(){

        System.out.println("Creation d'un User");

        Scanner Clavier = new Scanner(System.in);
        System.out.println("Création d'un nouveau Compte :");
        System.out.println("Entrer Votre Nom :");
        String nom = Clavier.nextLine();
        System.out.println("Entrer Votre Prénom :");
        String prenom = Clavier.nextLine();

        System.out.println("Entrer Votre Matricule :");
        String mat = Clavier.nextLine();

        Profil P = Creation.CreateProfil();

        return new User(nom,prenom,mat,0,"Masculin",P);
    }

    //(said)
    public static Profil CreateProfil(){

        Scanner Clavier = new Scanner(System.in);

        System.out.println("Entrer Votre Status (Passager/Chaffuer) :");
        String status = Clavier.nextLine();

        System.out.println("Entrer Votre Destination :");
        String dest = Clavier.nextLine();

        List<String> pref = new ArrayList<>();
        System.out.println("Entrer Vos Préférences (1):");
        pref.add(Clavier.nextLine());

        System.out.println("Entrer Vos Préférences (2):");
        pref.add(Clavier.nextLine());

        System.out.println("Entrer Vos Préférences (3):");
        pref.add(Clavier.nextLine());


        System.out.println("Entrer Votre Disponibilité (Journalier, Quotidien, Hebdomadaires) :");
        String dispo = Clavier.nextLine();

        System.out.println("Entrer Votre Type de Course (Aller, Retour , Aller - Retour) :");
        String type = Clavier.nextLine();

        return new Profil(status,dest, pref, dispo, type);
    }

    // (said)
    public static Chauffeur createChauffeur(){

        System.out.println("Creation d'un Chauffeur");

        User U = Creation.createUser();

        Scanner Clavier = new Scanner(System.in);
        System.out.println("Enter le Nombre de Course Max : ");
        int x = Clavier.nextInt();
        System.out.println("Enter le Nombre de De Places: ");
        int y = Clavier.nextInt();

        return new Chauffeur(U,x,y);
    }

    // (said)
    public static Chauffeur createChauffeur(User U){

        System.out.println("Creation d'un Chauffeur (à partir d'un User)");

        Scanner Clavier = new Scanner(System.in);
        System.out.println("Enter le Nombre de Course Max : ");
        int x = Clavier.nextInt();
        System.out.println("Enter le Nombre de De Places: ");
        int y = Clavier.nextInt();

        return new Chauffeur(U,x,y);
    }


}
