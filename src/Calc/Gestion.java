package Calc;

import Entity.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {

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

        Profil P = Gestion.CreateProfil();

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

        User U = Gestion.createUser();

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

    /*
    Partie Gestion de La BDD :
     */

    // Insertion : (said) , peut étre a rajouter dans la creation de l'objet

    public static void addUser(User U){
        try(FileWriter file = new FileWriter("src/BDD/User.txt",true)) {

            file.write(" ");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addChauffeur(Chauffeur C){
        try(FileWriter file = new FileWriter("src/BDD/Chauffeur.txt",true)) {

            file.write(" ");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addPassager(Chauffeur C){
        try(FileWriter file = new FileWriter("src/BDD/Passager.txt",true)) {

            file.write(" ");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addMotDePasse(String matricule,String MotDePasse){
        try(FileWriter file = new FileWriter("src/BDD/MotDePasse.txt",true)) {

            file.write(matricule + " " + MotDePasse);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Recherche

    public static void findUser(String matricule){
        // les fichiers doivent etre initialisé, sinon problem
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/User.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");
                if(Temp[0].equals(matricule) ){

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }







}
