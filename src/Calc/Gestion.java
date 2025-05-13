package Calc;

import Entity.*;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Gestion {

    static Scanner Clavier = new Scanner(System.in);

    /*
        Class Creation contient des methodes Static pour faciliter l'ecriture Du Main pour eviter
        les Grandes lignes de Saisie de Données, Améliorant sa lisibilité.

        En + si on veut modifier une donnée à saisir, on le modifie qu'une seule fois
     */

    //(said)

        public static User createUser() {
            System.out.println("Creation d'un User");

            System.out.println("Création d'un nouveau Compte :");

            // Vérification du nom
            String nom = "";
            while (nom == null || nom.isEmpty()) {
                System.out.println("Entrer Votre Nom :");
                nom = Clavier.nextLine();
                if (nom == null || nom.isEmpty()) {
                    System.out.println("Erreur : Le nom ne peut pas être vide.");
                }
            }



            // Vérification du prénom
            String prenom = "";
            while (prenom == null || prenom.isEmpty()) {
                System.out.println("Entrer Votre Prénom :");
                prenom = Clavier.nextLine();
                if (prenom == null || prenom.isEmpty()) {
                    System.out.println("Erreur : Le prénom ne peut pas être vide.");
                }
            }

            // Vérification du matricule
            String mat = "";
            while (mat == null || mat.isEmpty()) {
                System.out.println("Entrer Votre Matricule :");
                mat = Clavier.nextLine();
                if (mat == null || mat.isEmpty()) {
                    System.out.println("Erreur : Le matricule ne peut pas être vide.");
                }
            }

            // Vérification du sexe
            String sexe = "";
            while (!(sexe.equals("Masculin") || sexe.equals("Féminin"))) {
                System.out.println("Entrer Votre Sexe (Masculin/Féminin) :");
                sexe = Clavier.nextLine();
                if (!(sexe.equals("Masculin") || sexe.equals("Féminin"))) {
                    System.out.println("Erreur : Le sexe doit être 'Masculin' ou 'Féminin'.");
                }
            }

            // Création du profil
            Profil P = createProfil();

            boolean validPref = false;
            while (!validPref) {

                System.out.println("Vous étes ? :");

                System.out.println("1 - Étudiant");
                System.out.println("2 - Enseignant ");
                System.out.println("3 - ATS");
                int i = Clavier.nextInt(); Clavier.nextLine();

                if (i == 1 || i == 2 || i == 0) {
                    validPref = true;
                } else {
                    System.out.println("Erreur : Choix invalide.");
                }
                // UPCASTING donc ca passe créme
                switch (i) {
                    case 0:
                        return createEtudiant(new User(nom, prenom, mat, sexe, P));
                    case 1:
                        return createEnseignant(new User(nom, prenom, mat, sexe, P));
                    case 2:
                        return createATS(new User(nom, prenom, mat, sexe, P));
                }
            }

            return new User(nom, prenom, mat, sexe, P);
        }

        public static Profil createProfil() {

            // Vérification du statut
            String status = "";
            while (!status.equals("Passager") && !status.equals("Chauffeur")) {
                System.out.println("Entrer Votre Status (Passager/Chauffeur) :");
                status = Clavier.nextLine();
                if (!status.equals("Passager") && !status.equals("Chauffeur")) {
                    System.out.println("Erreur : Le statut doit être 'Passager' ou 'Chauffeur'.");
                }
            }

            // Vérification de la destination
            String dest = "";
            while (dest == null || dest.isEmpty()) {
                System.out.println("Entrer Votre Destination :");
                dest = Clavier.nextLine();
                if (dest == null || dest.isEmpty()) {
                    System.out.println("Erreur : La destination ne peut pas être vide.");
                }
            }

            // Préférences : choix multiple
            String[] pref = new String[3];
            for (int i = 0; i < 3; i++) {
                boolean validPref = false;
                while (!validPref) {
                    System.out.println("Choix des Préférences (" + (i + 1) + "):");
                    switch (i) {
                        case 0:
                            System.out.println("1 - Garçons Uniquement");
                            System.out.println("2 - Filles Uniquement ");
                            System.out.println("3 - Indifferent");
                            break;
                        case 1:
                            System.out.println("1 - Avec Musique");
                            System.out.println("2 - Sans Musique");
                            System.out.println("3 - Indifférent");
                            break;
                        case 2:
                            System.out.println("1 - Avec Baggage Supplementary");
                            System.out.println("1 - Sans Baggage Supplementary");
                            System.out.println("1 - Indifférent");
                            break;
                    }
                    pref[i] = Clavier.nextLine();
                    if (pref[i].matches("[1-3]")) {
                        validPref = true;
                    } else {
                        System.out.println("Erreur : Choix invalide.");
                    }
                }
            }

            // Disponibilité : Vérification
            String dispo = "";
            while (!(dispo.equals("Journalier") || dispo.equals("Quotidien") || dispo.equals("Hebdomadaires"))) {
                System.out.println("Entrer Votre Disponibilité (Journalier, Quotidien, Hebdomadaires) :");
                dispo = Clavier.nextLine();
                if (!(dispo.equals("Journalier") || dispo.equals("Quotidien") || dispo.equals("Hebdomadaires"))) {
                    System.out.println("Erreur : La disponibilité doit être 'Journalier', 'Quotidien' ou 'Hebdomadaires'.");
                }
            }

            // Type de course : Vérification
            String type = "";
            while (!(type.equals("Aller") || type.equals("Retour") || type.equals("Aller - Retour"))) {
                System.out.println("Entrer Votre Type de Course (Aller, Retour, Aller - Retour) :");
                type = Clavier.nextLine();
                if (!(type.equals("Aller") || type.equals("Retour") || type.equals("Aller - Retour"))) {
                    System.out.println("Erreur : Le type de course doit être 'Aller', 'Retour' ou 'Aller - Retour'.");
                }
            }

            return new Profil(status, dest, pref, dispo, type);
        }

        public static Passager createPassager(User U) {

            String x1 = "";

            // Vérification du point de ramassage
            while (x1 == null || x1.isEmpty()) {
                System.out.println("Enter Votre Point De Ramassage : ");
                x1 = Clavier.nextLine();
                if (x1 == null || x1.isEmpty()) {
                    System.out.println("Erreur : Le point de ramassage ne peut pas être vide.");
                }
            }

            return new Passager(U, 0.0, x1);
        }

        public static Chauffeur createChauffeur() {
            System.out.println("Creation d'un Chauffeur");

            User U = createUser();

            Scanner Clavier = new Scanner(System.in);

            // Vérification des points de ramassage
            String x1 = "", x2 = "", x3 = "";
            while (x1 == null || x1.isEmpty()) {
                System.out.println("Enter Vos Point De Ramassage : ");
                x1 = Clavier.nextLine();
                if (x1 == null || x1.isEmpty()) {
                    System.out.println("Erreur : Le point de ramassage ne peut pas être vide.");
                }
            }
            while (x2 == null || x2.isEmpty()) {
                System.out.println("Enter Vos Point De Ramassage : ");
                x2 = Clavier.nextLine();
                if (x2 == null || x2.isEmpty()) {
                    System.out.println("Erreur : Le point de ramassage ne peut pas être vide.");
                }
            }
            while (x3 == null || x3.isEmpty()) {
                System.out.println("Enter Vos Point De Ramassage : ");
                x3 = Clavier.nextLine();
                if (x3 == null || x3.isEmpty()) {
                    System.out.println("Erreur : Le point de ramassage ne peut pas être vide.");
                }
            }

            // Vérification du nombre de places
            int y = -1;
            while (y <= 0) {
                System.out.println("Enter le Nombre de Places : ");
                y = Clavier.nextInt();
                if (y <= 0) {
                    System.out.println("Erreur : Le nombre de places doit être supérieur à zéro.");
                }
            }

            return new Chauffeur(U, y, new String[]{x1, x2, x3});
        }

    public static Etudiant createEtudiant(User U){

        System.out.println("Entrer Votre Année d'Admission :");
        int a = Clavier.nextInt(); Clavier.nextLine();
        System.out.println("Entrer Votre Faculté :");
        String F = Clavier.nextLine();
        System.out.println("Entrer Votre Spécialité :");
        String S = Clavier.nextLine();

        return new Etudiant(U,a,F,S);
    }

    public static Enseignant createEnseignant(User U){

        System.out.println("Entrer Votre Année de Recrutement :");
        int a = Clavier.nextInt(); Clavier.nextLine();
        System.out.println("Entrer Votre Faculté :");
        String F = Clavier.nextLine();

        return new Enseignant(U,a,F);
    }

    public static ATS createATS(User U){

        System.out.println("Entrer Votre Année de Recrutement :");
        int a = Clavier.nextInt(); Clavier.nextLine();
        System.out.println("Entrer Votre Service :");
        String s = Clavier.nextLine();

        return new ATS(U,a,s);
    }

    //(said)

    // (said)

    // (said)
    public static Chauffeur createChauffeur(User U){

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

    // Statistique

    public static Passager[] getTop10Passagers() {
        Passager[] top10 = new Passager[10];
        double[] reputations = new double[10];

        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Passager.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                if (temp.length >= 7) {
                    String matricule = temp[0];
                    User u = Gestion.findUser(matricule);

                    if (u != null) {
                        double reputation = Double.parseDouble(temp[6]);
                        String moyenTransport = temp[5];
                        Passager passager = new Passager(u, reputation, moyenTransport);

                        // Cherche où insérer ce passager dans le tableau top10
                        for (int i = 0; i < 10; i++) {
                            if (top10[i] == null || reputation > reputations[i]) {
                                // Décale les éléments vers la droite pour insérer
                                for (int j = 9; j > i; j--) {
                                    top10[j] = top10[j - 1];
                                    reputations[j] = reputations[j - 1];
                                }
                                top10[i] = passager;
                                reputations[i] = reputation;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return top10;
    }

    public static Chauffeur[] getTop10Chauffeurs() {
        Chauffeur[] top10 = new Chauffeur[10];
        double[] reputations = new double[10];

        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Chauffeur.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] Temp = line.split(" ");

                double reputation = Double.parseDouble(Temp[6]);
                int nbPlaces = Integer.parseInt(Temp[5]);
                String matricule = Temp[0];

                // Construire le tableau de points de ramassage à partir de Temp[7] jusqu'à la fin
                String[] pointsDeRamassage = new String[Temp.length - 7];
                System.arraycopy(Temp, 7, pointsDeRamassage, 0, Temp.length - 7);

                // Créer l'objet User associé
                User U = Gestion.findUser(matricule);
                if (U == null) continue;

                Chauffeur chauffeur = new Chauffeur(U, nbPlaces, pointsDeRamassage);

                // Insérer dans top10 si sa réputation est suffisante
                for (int i = 0; i < 10; i++) {
                    if (top10[i] == null || reputation > reputations[i]) {
                        // Décaler vers la droite
                        for (int j = 9; j > i; j--) {
                            top10[j] = top10[j - 1];
                            reputations[j] = reputations[j - 1];
                        }
                        // Insérer le nouveau chauffeur
                        top10[i] = chauffeur;
                        reputations[i] = reputation;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return top10;
    }

    public static Passager[] getWorst10Passagers() {
        Passager[] worst10 = new Passager[10];
        double[] reputations = new double[10];
        // Initialiser à des valeurs très hautes pour les reputations
        for (int i = 0; i < 10; i++) reputations[i] = Double.MAX_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Passager.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] Temp = line.split(" ");

                double reputation = Double.parseDouble(Temp[6]);
                String matricule = Temp[0];
                String moyenDePaiement = Temp[5];

                User U = Gestion.findUser(matricule);
                if (U == null) continue;

                Passager passager = new Passager(U, reputation, moyenDePaiement);

                for (int i = 0; i < 10; i++) {
                    if (worst10[i] == null || reputation < reputations[i]) {
                        for (int j = 9; j > i; j--) {
                            worst10[j] = worst10[j - 1];
                            reputations[j] = reputations[j - 1];
                        }
                        worst10[i] = passager;
                        reputations[i] = reputation;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return worst10;
    }

    public static Chauffeur[] getWorst10Chauffeurs() {
        Chauffeur[] worst10 = new Chauffeur[10];
        double[] reputations = new double[10];
        for (int i = 0; i < 10; i++) reputations[i] = Double.MAX_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/BDD/Chauffeur.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] Temp = line.split(" ");

                double reputation = Double.parseDouble(Temp[6]);
                int nbPlaces = Integer.parseInt(Temp[5]);
                String matricule = Temp[0];

                // Construire les points de ramassage
                String[] pointsDeRamassage = new String[Temp.length - 7];
                System.arraycopy(Temp, 7, pointsDeRamassage, 0, Temp.length - 7);

                User U = Gestion.findUser(matricule);
                if (U == null) continue;

                Chauffeur chauffeur = new Chauffeur(U, nbPlaces, pointsDeRamassage);

                for (int i = 0; i < 10; i++) {
                    if (worst10[i] == null || reputation < reputations[i]) {
                        for (int j = 9; j > i; j--) {
                            worst10[j] = worst10[j - 1];
                            reputations[j] = reputations[j - 1];
                        }
                        worst10[i] = chauffeur;
                        reputations[i] = reputation;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return worst10;
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
