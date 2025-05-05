import Calc.Creation;
import Entity.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Clavier = new Scanner(System.in);
/*        System.out.println("Création d'un nouveau Compte :");
        System.out.println("Entrer Votre Nom :");
        String nom = Clavier.nextLine();
        System.out.println("Entrer Votre Prénom :");
        String prenom = Clavier.nextLine();

        System.out.println("Entrer Votre Matricule :");
        String mat = Clavier.nextLine();

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

        Profil P = new Profil(status,dest, pref, dispo, type);

        User U1 = new User(nom,prenom,mat,0,"Masculin",P);
*/

        User U1 = Creation.createUser();
        if(U1.getProfil().getStatut().equals("Chauffeur") ){

            Chauffeur C1 = Creation.createChauffeur(U1);
            System.out.println(C1);
        }

        Clavier.close();


    }
}