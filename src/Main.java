import Entity.*;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        JFrame Window = new JFrame("Mini Projet POO");
        Window.setSize(500,500);
        JTextField Text1 = new JTextField("Nom",3);
        //Window.add(Text1);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // marges entre composants


        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(new JTextField(10), gbc);


        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(new JTextField(10), gbc);

        Window.add(panel);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setVisible(true);
*/

        Scanner Clavier = new Scanner(System.in);
        System.out.println("Création d'un nouveau Compte :");
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

        if(U1.getProfil().getStatut().equals("Chauffeur") ){
            System.out.println("Vous étes un chauffeur, Enter le Nombre de Course Max : ");
            int x = Clavier.nextInt();
            System.out.println("Vous étes un chauffeur, Enter le Nombre de De Places: ");
            int y = Clavier.nextInt();

            Chauffeur C1 = new Chauffeur(U1,x,y);

            System.out.println(C1);
        }

        Clavier.close();


    }
}