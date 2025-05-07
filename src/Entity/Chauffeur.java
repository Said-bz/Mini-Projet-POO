package Entity;

import java.util.Arrays;

public class Chauffeur extends User {

    /* Version (Miko)
    //Course[] courses; //peut avoir une ou plusieurs courses (courses prévu pour le planning

    int nbplaces;//peut varier donc get/set (niveau par défaut pour réutilisation)
    private static final int max_course = 20;//nb max de courses
    private int indice_courses = 0;// indice du tableau de courses

    // (miko)
    public Chauffeur(String nom, String prenom, String matricule, double reputation, String sex,
                     Profil profil, int nbr_course, int nbplaces) { //le constructeur

        //lazem nzido sex dans user
        //a la creation d'un chauffeur on créer d'abord son profil qui dépendra 3la wch
        // 3emer fl main après on met la variable profile dans le constructeur
        super(nom, prenom, matricule, reputation, sex, profil);

        // Utilisation de setNbplace pour réecriture du code + Correction du setteur
        // (Miko) / (said)
        setNbPlaces(nbplaces);

        if (nbr_course <= max_course) { //si nbr_course<= max_course on prend nbr_cours sinon on prend max_course
            courses = new Course[nbr_course];
        } else {
            courses = new Course[max_course];
        }
    }

    // 2éme Constructeur, Plus pratique a L'utilisation (said)
    public Chauffeur(User U, int nbr_course, int nbplaces) { //le constructeur

        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getReputation(),U.getSexe(),U.getProfil());

        setNbPlaces(nbplaces);

        if (nbr_course <= max_course) { //si nbr_course<= max_course on prend nbr_cours sinon on prend max_course
            courses = new Course[nbr_course];
        } else {
            courses = new Course[max_course];
        }
    }

    //(miko)
    public boolean addCourse(Course c) {
        if (indice_courses < courses.length) {
            courses[indice_courses] = c;
            indice_courses++;
            return true; // retourne vrai si la course est ajoutée avec succès
        } else { //taille du tableau dépassé donc retourne faux
            System.out.println("Impossible d’ajouter une autre course : tableau plein.");
            return false;
        }
    }

    // Setteur (miko)
    int getNbPlaces () {
        return nbplaces;
    }


    void setNbPlaces ( int nbplaces)
    {//un set par pour modifier a chaque ajout de passager mais plutot pour la préférenc du chauffer

        // Modification de while par infinie parce que ca peut créer des boucles infinis
        if (nbplaces < 4 && nbplaces > 1) {
            this.nbplaces = nbplaces; //pour entrer les bonnes valeurs de places
        }else {
            // Temporaire, Si on trouve comment gérer un message d'erreur pour arréter la création d'un objet
            this.nbplaces= 1;
            System.out.println("Nombre de places Interdites, Elle est donc mise a 1");
        }
    }

    // (said)
    @Override
    public String toString(){
        return  "Matricule : " + super.getMatricule() + " " +
                "Nombre de Places : " + nbplaces;
    }
    */


    // Version (Said)

    private double reputation;
    private int cptReputation = 0;
    private String[] pointDeRamassage; // Plusieurs Points de Ramassage pour un seul Chauffeur
    int nbPlaces;

    public Chauffeur(String nom, String prenom, String matricule, String sex,
                     Profil profil, double reputation, int nbplaces,String[] pointDeRamassage) { //le constructeur

        super(nom, prenom, matricule, sex, profil);

        this.reputation = reputation;
        this.nbPlaces = nbplaces;
        this.pointDeRamassage = pointDeRamassage;
    }

    // 2éme Constructeur, Plus pratique a L'utilisation (said)
    public Chauffeur(User U, int nbplaces,String[] pointDeRamassage) { //le constructeur

        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getSexe(),U.getProfil());
        this.nbPlaces = nbplaces;
        this.pointDeRamassage = pointDeRamassage;
    }

    public void updateReputation(double reputation){
        this.cptReputation++;
        this.reputation = ((this.reputation * (cptReputation - 1)) + reputation) / cptReputation;
    }

    public double getReputation() {
        return reputation;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public String[] getPointDeRamassage() {
        return pointDeRamassage;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
                " Nombre de Places : " + this.getNbPlaces() + "\n" +
                "Reputation : " + this.getReputation() + "\n" +
                "Points De Ramassage : " + Arrays.toString(pointDeRamassage);
    }

    @Override
    public String toFileString(){
        return  this.getMatricule() + " " +  String.join(" ",this.getProfil().getPreferences()) + " " +
                this.getProfil().getDestination() + " " + String.join(" ",pointDeRamassage) + " " +
                this.getReputation() + " " + this.getNbPlaces();
    }

}
