import Calc.Admin;
import Calc.Gestion;
import Entity.*;

import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static User U;

    public static void main(String[] args) {

        Scanner Clavier = new Scanner(System.in);
        boolean isConnected = false;
        do {
            // Gére la connexion du user (said)
            do {

                System.out.println("Que Voulez vous faire ? :\n");
                System.out.println("1 - Créer un Utilisateur :");
                System.out.println("2 - Se Connecter a un Utilisateur :");


                switch (Clavier.nextInt()) {
                    case 1:
                        U = Gestion.createUser();
                        String mdp = Gestion.createMotDePasse();

                        Gestion.addMotDePasse(U.getMatricule(), mdp);
                        Gestion.addUser(U);
                        break;

                    case 2:
                        Clavier.nextLine();
                        System.out.println("Entrer Votre Matricule");
                        String mat = Clavier.nextLine();
                        System.out.println("Entrer Votre Mot De Passe : ");
                        String motDePasse = Clavier.nextLine();
                        if (Gestion.isMotDePasseExist(mat, motDePasse)) {
                            isConnected = true;
                            U = Gestion.findUser(mat);
                            if (U == null) {
                                break;
                            }
                            if (!Objects.equals(U.getMatricule(),"0")) {
                                System.out.println("Vous étes Connecté !");
                                System.out.println("Bienvenue " + U.getNom() + " " + U.getPrenom() + " !");
                            } else {
                                System.out.println("Vous étes Connecté !");
                                System.out.println("Bienvenue sur le compte Administrateur");

                                Admin.mainAdmin(U);
                            }
                            U.setActive(true);
                        }
                        else{
                            System.out.println("Mot de Passe Ou Matricule erroné, Veuillez Réessayer");
                        }
                        break;
                }
            } while (!isConnected);
            if(U == null){break;}

            if(Objects.equals(U.getProfil().getStatut(), "Chauffeur")){

                Chauffeur C;
                // si chauffeur n'existait pas, alors on le rajoute
                if(!Gestion.isExist(U.getMatricule(),"Chauffeur")){
                    C = Gestion.createChauffeur(U);
                    Gestion.addChauffeur(C);
                }
                else{
                    C = Gestion.findChauffeur(U.getMatricule());
                }

                boolean Retour;
                do {
                    Retour = true;


                    System.out.println("Chauffeur, Que Voulez vous ? : ");
                    System.out.println("1 - Offrir Une Course");
                    System.out.println("2 - Paramétres");

                    int x = Clavier.nextInt();
                    Clavier.nextLine();

                    switch (x) {
                        case 1:
                            boolean R;
                            do {// Offrir Une Course
                                R = false;
                                System.out.println("Recherche de Passager...");
                                Passager P = Gestion.findPassager(C.getProfil().getDestination(), C.getPointDeRamassage(), C.getProfil().getPreferences());

                                if (P == null || !Gestion.isUserActif(P.getMatricule())) { // Cas 0 Passager
                                    System.out.println("Pas De Passager Actif Trouvé");
                                    System.out.println("Voulez Vous Réessayer ? (y/n):");

                                    String Reessaye = Clavier.nextLine().toUpperCase();

                                    switch (Reessaye) {
                                        case "Y":
                                            break;
                                        case "N":
                                            R = true;
                                            break;
                                    }
                                } else { // Cas Minimum 1 Passager
                                    Course course = new Course(C);

                                    boolean RechercheTermine;
                                    String[] mats = new String[4];
                                    int i = 0;

                                    do { // Cas plusieurs Passagers
                                        RechercheTermine = false;

                                        mats[i] = P.getMatricule();

                                        System.out.println("Passager Trouvé !");
                                        System.out.println("Voulez Vous L'ajouter ? (y/n) : ");

                                        String ajout = Clavier.nextLine().toUpperCase();

                                        switch (ajout) {
                                            case "Y":
                                                if (!course.addPassager(P)) {
                                                    RechercheTermine = true;
                                                    System.out.println("Espace Complet, Impossible d'ajouter des Passagers");
                                                    Gestion.updateChauffeur(C);
                                                    break;
                                                }
                                                Gestion.updateChauffeur(C);


                                                System.out.println("Voulez Vous Cherhcher un autre Passager ? (y/n) : ");

                                                String nouvelleAjout = Clavier.nextLine().toUpperCase();

                                                switch (nouvelleAjout) {
                                                    case "Y":
                                                        // Recherche d'un autre passager
                                                        P = Gestion.findPassager(C.getProfil().getDestination(), C.getPointDeRamassage(),
                                                                C.getProfil().getPreferences(), mats);

                                                        if (P == null) {
                                                            System.out.println("Pas De Passager Trouvé :/, Vous Voulez Réessayer ? (y/n): ");
                                                            switch (Clavier.nextLine().toUpperCase()) {
                                                                case "Y":
                                                                    break;
                                                                case "N":
                                                                    RechercheTermine = true;
                                                                    break;
                                                            }

                                                        } else {
                                                            i++;
                                                        }

                                                        break;

                                                    case "N":
                                                        RechercheTermine = true;
                                                        break;
                                                }
                                                break;

                                            case "N":
                                                RechercheTermine = true;
                                                break;
                                        }
                                    } while (!RechercheTermine);

                                    System.out.println("Lancement De La Course..."); // Valeur a Modifier
                                    //course.debutCourse(300); // Lance un Timer de 5min, La course se terminera dans 5min

                                    Gestion.sleep(5);

                                    System.out.println("Course Terminée...");

                                    course.finCourse(C);
                                    Gestion.updateCourse(course);

                                    R = true;
                                }
                            } while (!R);

                            break;

                        case 2:
                            System.out.println("PARAMETERS : ");
                            System.out.println("0 - Retour");
                            System.out.println("1 - Voir Mon Compte");
                            System.out.println("2 - Modifier Mon Compte");
                            System.out.println("3 - Supprimer Mon Compte");
                            System.out.println("4 - Se Déconnecter");
                            System.out.println("5 - Arrêt du Programme");

                            switch (Clavier.nextInt()){
                                case 0: break;
                                case 1:
                                    System.out.println(C);
                                    break;
                                case 2:

                                    break;
                                case 3:
                                    break;
                                case 4:
                                    System.out.println("Déconnexion...");
                                    Retour = false;
                                    U.setActive(false);
                                    isConnected = false;
                                    U = null;
                                    break;
                                case 5:
                                    U.setActive(false);
                                    System.exit(0);
                                    break;
                            }


                            break;
                    }
                }while(Retour);

                // Arrêt du Programme
            }

            if (Objects.equals(U.getProfil().getStatut(), "Passager")) {
                boolean retourPassager = true;

                Passager P;
                // si chauffeur n'existait pas, alors on le rajoute
                if(!Gestion.isExist(U.getMatricule(),"Chauffeur")){
                    P = Gestion.createPassager(U);
                    Gestion.addPassager(P);
                }
                else{
                    P = Gestion.findPassager(U.getMatricule());
                }

                do {
                    System.out.println("Passager, Que voulez-vous ? : ");
                    System.out.println("1 - Chercher une course");
                    System.out.println("2 - Paramètres");

                    int choixPassager = Clavier.nextInt();
                    Clavier.nextLine(); // Nettoyer le buffer

                    switch (choixPassager) {
                        case 1:
                            // Chercher une course
                            System.out.println("Recherche de chauffeurs disponibles...");

                            // Recherche un chauffeur disponible en fonction de la destination et des préférences
                            Chauffeur C = Gestion.findChauffeur(U.getProfil().getDestination(), P.getPointDeRamassage(),U.getProfil().getPreferences());

                            if (C != null) {
                                System.out.println("Course trouvée avec le chauffeur : " + C.getNom() + " " + C.getPrenom());
                                System.out.println("Voulez-vous réserver cette course ? (y/n)");

                                String reserverCourse = Clavier.nextLine().toUpperCase();
                                if (reserverCourse.equals("Y")) {
                                    Course course = new Course(C);
                                    course.addPassager(P); // Ajouter le passager à la course
                                    Gestion.updateCourse(course); // Mettre à jour la course
                                    System.out.println("Course réservée avec succès !");
                                } else {
                                    System.out.println("Course non réservée.");
                                }
                            } else {
                                System.out.println("Aucun chauffeur disponible pour votre destination.");
                            }
                            break;

                        case 2:
                            // Paramètres
                            System.out.println("PARAMÈTRES : ");
                            System.out.println("0 - Retour");
                            System.out.println("1 - Voir Mon Compte");
                            System.out.println("2 - Modifier Mon Compte");
                            System.out.println("3 - Supprimer Mon Compte");
                            System.out.println("4 - Se Déconnecter");
                            System.out.println("5 - Arrêt du Programme");

                            int choixParamPassager = Clavier.nextInt();
                            Clavier.nextLine(); // Nettoyer le buffer

                            switch (choixParamPassager) {
                                case 0:
                                    retourPassager = false;
                                    break;
                                case 1:
                                    System.out.println(P);
                                    break;
                                case 2:
                                    // Implémenter modification du compte passager ici
                                    break;
                                case 3:
                                    // Implémenter suppression du compte passager ici
                                    break;
                                case 4:
                                    // Se déconnecter
                                    System.out.println("Déconnexion...");
                                    retourPassager = false;
                                    U.setActive(false);
                                    isConnected = false;
                                    U = null;
                                    break;
                                case 5:
                                    // Arrêt du programme
                                    U.setActive(false);
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Option invalide.");
                                    break;
                            }
                            break;

                        default:
                            System.out.println("Option invalide.");
                            break;
                    }

                } while (retourPassager);
            }




        }while(!isConnected);


        Clavier.close();

    }
}