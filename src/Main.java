import Calc.Gestion;
import Entity.*;
import java.io.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner Clavier = new Scanner(System.in);
/*
        Window frame = new Window();

        User U1 = Creation.createUser();
        if(U1.getProfil().getStatut().equals("Chauffeur") ){

            Chauffeur C1 = Creation.createChauffeur(U1);
            System.out.println(C1);
        }

        Clavier.close();*/

        System.out.println("Que Voulez vous faire ? :\n");
        System.out.println("1 - Créer un Utilisateur :\n");
        System.out.println("2 - Se Connecter a un Utilisateur :\n");
        User U1;
        switch (Clavier.nextInt()){
            case 1 :
                 U1 = Gestion.createUser();
                break;

            case 2 :
                System.out.println("Entrer Votre Matricule et Mot de passe");
        }


        String[] test ="oui et".split(" ");
        System.out.println(test[0]);

        Clavier.close();
    }
}