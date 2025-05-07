package Calc;

import Entity.*;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
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

        Profil P = Gestion.createProfil();

        return new User(nom,prenom,mat,"Masculin",P);
    }

    //(said)
    public static Profil createProfil(){

        Scanner Clavier = new Scanner(System.in);

        System.out.println("Entrer Votre Status (Passager/Chaffuer) :");
        String status = Clavier.nextLine();

        System.out.println("Entrer Votre Destination :");
        String dest = Clavier.nextLine();

        String[]  pref = new String[3];
        System.out.println("Choix des Préferences (1):");
        System.out.println("1 - Garcons Uniquement");
        System.out.println("2 - Filles Uniquement");
        System.out.println("3 - Indifferent");
        pref[0] = Clavier.nextLine();

        System.out.println("Choix des Préférences (2):");
        System.out.println("1 - Avec Musique");
        System.out.println("2 - Sans Musique");
        System.out.println("3 - Indifferent");
        pref[1] = Clavier.nextLine();

        System.out.println("Choix des Préférences (3):");
        System.out.println("1 - Avec Baggage Supplementary");
        System.out.println("2 - Sans Baggage Supplementary");
        System.out.println("3 - Indifferent");
        pref[2] = Clavier.nextLine();


        System.out.println("Entrer Votre Disponibilité (Journalier, Quotidien, Hebdomadaires) :");
        String dispo = Clavier.nextLine();

        System.out.println("Entrer Votre Type de Course (Aller, Retour , Aller - Retour) :");
        String type = Clavier.nextLine();

        return new Profil(status,dest, pref, dispo, type);
    }

    //(said)
    public static Passager createPassager(User U){
        Scanner Clavier = new Scanner(System.in);
        System.out.println("Enter Votre Point De Ramassage : ");
        String x1 = Clavier.nextLine();

        return new Passager(U,0.0,x1);
    }

    // (said)
    public static Chauffeur createChauffeur(){

        System.out.println("Creation d'un Chauffeur");

        User U = Gestion.createUser();

        Scanner Clavier = new Scanner(System.in);
        System.out.println("Enter Vos Point De Ramassage : ");
        String x1 = Clavier.nextLine();
        System.out.println("Enter Vos Point De Ramassage : ");
        String x2 = Clavier.nextLine();
        System.out.println("Enter Vos Point De Ramassage : ");
        String x3 = Clavier.nextLine();
        System.out.println("Enter le Nombre de De Places: ");
        int y = Clavier.nextInt();

        return new Chauffeur(U,y, new String[]{x1,x2,x3});
    }

    // (said)
    public static Chauffeur createChauffeur(User U){

        Scanner Clavier = new Scanner(System.in);
        System.out.println("Enter Vos Point De Ramassage : ");
        String x1 = Clavier.nextLine();
        System.out.println("Enter Vos Point De Ramassage : ");
        String x2 = Clavier.nextLine();
        System.out.println("Enter Vos Point De Ramassage : ");
        String x3 = Clavier.nextLine();
        System.out.println("Enter le Nombre de De Places: ");
        int y = Clavier.nextInt();

        return new Chauffeur(U,y, new String[]{x1,x2,x3});
    }

    // (said)
    public static String createMotDePasse(){
        Scanner Clavier = new Scanner(System.in);
        System.out.println("Entrer Votre Mot de Passe : ");
        return Clavier.nextLine();
    }

    /*
    Partie Gestion de La BDD :
     */

    // Insertion : (said) , peut étre a rajouter dans la creation de l'objet

    public static void addUser(User U) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/BDD/User.txt", true))) {
            writer.write(U.toFileString());
            writer.newLine(); // saut de ligne correct selon le système
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addChauffeur(Chauffeur C){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/BDD/Chauffeur.txt", true))) {

            writer.write(C.toFileString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPassager(Passager P){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/BDD/Passager.txt", true))) {

            writer.write(P.toFileString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMotDePasse(String matricule, String MotDePasse) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/BDD/MotDePasse.txt", true))) {
            writer.write(matricule + " " + MotDePasse);
            writer.newLine(); // saut de ligne correct selon le système
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recherche

    public static User findUser(String matricule){
        // les fichiers doivent etre initialisé, sinon problem
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/User.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");
                if(Temp[0].equals(matricule) ){
                    System.out.println("User Trouvé !");
                    return new User(Temp[1],Temp[2],Temp[0] ,Temp[3],
                            new Profil(Temp[5],Temp[6],new String[]{Temp[7],Temp[8],Temp[9]},Temp[10],Temp[11]),
                            Boolean.parseBoolean(Temp[4]));
                }
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Chauffeur findChauffeur(String matricule){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Chauffeur.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");

                if(Objects.equals(Temp[0], matricule)){

                    User U = Gestion.findUser(Temp[0]);
                    if(U == null){
                        System.out.println("User n'existe Pas...");
                        return null;
                    }
                    return new Chauffeur(U,Integer.parseInt(Temp[9]),new String[]{Temp[5],Temp[6],Temp[7]});
                }
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Chauffeur findChauffeur(String Destination,String pointDeRamassage, String[] pref){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Chauffeur.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");
                // Test Des Points De Ramassage de Chauffeur == Point De Ramassage De Passager
                boolean X = Objects.equals(Temp[5], pointDeRamassage) ||
                        Objects.equals(Temp[6], pointDeRamassage) ||
                        Objects.equals(Temp[7], pointDeRamassage);

                // Test Destination et Préference
                if(Objects.equals(Temp[1], pref[0]) && Objects.equals(Temp[2], pref[1]) && Objects.equals(Temp[3], pref[2])
                        && Objects.equals(Temp[4], Destination) && X)
                {
                    User U = Gestion.findUser(Temp[0]);
                    if(U == null){
                        System.out.println("User n'existe Pas...");
                        return null;
                    }
                    return new Chauffeur(U,Integer.parseInt(Temp[9]),new String[]{Temp[5],Temp[6],Temp[7]});
                }
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Passager findPassager(String matricule){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Passager.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");

                if(Objects.equals(Temp[0], matricule))
                {
                    User U = Gestion.findUser(Temp[0]);
                    if(U == null){ // Pour U != null
                        System.out.println("User n'existe Pas...");
                        return null;
                    }
                    return new Passager(U,Double.parseDouble(Temp[6]),Temp[5]);
                }
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Passager findPassager(String Destination,String[] pointDeRamassage, String[] pref){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Passager.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");
                // Test Des Points De Ramassage de Chauffeur == Point De Ramassage De Passager
                boolean X = Objects.equals(Temp[5], pointDeRamassage[0]) ||
                            Objects.equals(Temp[5], pointDeRamassage[1]) ||
                            Objects.equals(Temp[5], pointDeRamassage[2]);

                // Test Destination et Préference
                if(Objects.equals(Temp[1], pref[0]) && Objects.equals(Temp[2], pref[1]) && Objects.equals(Temp[3], pref[2])
                && Objects.equals(Temp[4], Destination) && X)
                {
                    User U = Gestion.findUser(Temp[0]);
                    if(U == null){
                        System.out.println("User n'existe Pas...");
                        return null;
                    }
                    return new Passager(U,Double.parseDouble(Temp[6]),Temp[5]);
                }
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Passager findPassager(String Destination,String[] pointDeRamassage, String[] pref,String[] mats){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Passager.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");

                if(Arrays.asList(mats).contains(Temp[0])){
                    continue;
                }

                // Test Des Points De Ramassage de Chauffeur == Point De Ramassage De Passager
                boolean X = Objects.equals(Temp[5], pointDeRamassage[0]) ||
                        Objects.equals(Temp[5], pointDeRamassage[1]) ||
                        Objects.equals(Temp[5], pointDeRamassage[2]);

                // Test Destination et Préference
                if(Objects.equals(Temp[1], pref[0]) && Objects.equals(Temp[2], pref[1]) && Objects.equals(Temp[3], pref[2])
                        && Objects.equals(Temp[4], Destination) && X)
                {
                    User U = Gestion.findUser(Temp[0]);
                    if(U == null){
                        System.out.println("User n'existe Pas...");
                        return null;
                    }
                    return new Passager(U,Double.parseDouble(Temp[6]),Temp[5]);
                }
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    // Update : Prend La Clé et Cherche la ligne avec la meme Clé Pour la Modifier

    private static void updateInFile(String fileName, String matricule, String updatedLine) {
        File file = new File("src/BDD/" + fileName + ".txt");
        File tempFile = new File("temp_" + fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains(matricule)) {
                    writer.write(updatedLine);
                    writer.newLine();
                    found = true;
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!found) {
                // Si l'objet n'existait pas, on l'ajoute
                writer.write(updatedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur de mise à jour du fichier : " + e.getMessage());
        }

        // Remplace l'ancien fichier par le nouveau
        if (!file.delete() || !tempFile.renameTo(file)) {
            System.out.println("Erreur lors de l'application de la mise à jour du fichier.");
        }
    }

    public static void updateUser(User user) {
        String ligne = user.toFileString();
        String matricule = user.getMatricule();
        updateInFile("User", matricule, ligne);
    }

    public static void updateChauffeur(Chauffeur chauffeur) {
        String ligne = chauffeur.toFileString();
        String matricule = chauffeur.getMatricule();
        updateInFile("Chauffeur", matricule, ligne);
    }

    public static void updatePassager(Passager passager) {
        String ligne = passager.toFileString();
        String matricule = passager.getMatricule();
        updateInFile("Passager", matricule, ligne);
    }

    public static void updateCourse(Course course) {
        String updatedLine = course.toFileString();
        String idCourse = String.valueOf(course.getIdCourse()); // ou Course.cptID si static
        String matChauffeur = course.getChauffeur().getMatricule();
        String matPassager1 = course.getPassagers()[0].getMatricule(); // on suppose au moins un passager

        File file = new File("src/BDD/Course.txt");
        File tempFile = new File("temp_courses.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                // clé = ID + chauffeur + premier passager
                if (line.contains(idCourse) && line.contains(matChauffeur) && line.contains(matPassager1)) {
                    writer.write(updatedLine);
                    writer.newLine();
                    found = true;
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!found) {
                writer.write(updatedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la mise à jour de la course : " + e.getMessage());
        }

        if (!file.delete() || !tempFile.renameTo(file)) {
            System.out.println("Erreur lors de l'application des modifications au fichier course.");
        }
    }


    // Suppression

    public static void deleteFromFile(String filePath, String matricule) {
        File inputFile = new File("src/BDD/" + filePath + ".txt");
        File tempFile = new File("temp_" + filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(matricule)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur de suppression dans " + filePath + " : " + e.getMessage());
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public static void deleteUser(String matricule) {
        deleteFromFile("User.txt", matricule);
        deleteFromFile("Passager.txt", matricule);
        deleteFromFile("Chauffeur.txt", matricule);
    }


    // Vérification

    public static boolean isMotDePasseExist(String mat, String mdp){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/MotDePasse.txt"))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");
                if(mat.equals(Temp[0]) && mdp.equals(Temp[1])){
                    return true;
                }
            }
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isUserActif(String mat){
        User U = Gestion.findUser(mat);
        if(U == null){
            return false;
        }
        return U.getActive();
    }

    public static boolean isExist(String matricule, String nomFichier){

        String fileName = "src/BDD/" + nomFichier + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String[] Temp;
            String Line;
            while((Line = reader.readLine()) != null){
                Temp = Line.split(" ");
                if(Temp[0].equals(matricule) ){
                    return true;
                }
            }
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void sleep(int sec){

        try {
            Thread.sleep(1000L *sec); // attendre 3 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
