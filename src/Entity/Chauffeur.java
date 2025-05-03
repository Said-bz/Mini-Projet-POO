package Entity;

public class Chauffeur extends User {
    Course[] courses; //peut avoir une ou plusieurs courses (courses prévu pour le planning

    int nbplaces;//peut varier donc get/set (niveau par defaut pour reutilisation)
    private static final int max_course = 20;//nb max de courses
    private int indice_courses = 0;// indice du tableau de courses

    public Chauffeur(String nom, String prenom, String matricule, double reputation, String
            sex, Profil profil, int nbr_course, int nbplaces) { //le constructeur

        super(nom, prenom, matricule, reputation, sex, profil);//lazem nzido sex dans user
        //a la creation d'un chauffeur on créer d'abord son profil qui dependera 3la wch
        // 3emer fl main après on met la variable profile dans le constructeur
        while (nbplaces > 4 || nbplaces < 1) {
            this.nbplaces = nbplaces; //pour entrer les bonnes valeurs de places
        }
        if (nbr_course <= max_course) { //si nbr_course<= max_course on prend nbr_cours sinon on prend max_course
            courses = new Course[nbr_course];
        } else {
            courses = new Course[max_course];
        }
    }

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

    int getNbPlaces () {
        return nbplaces;
    }


    void setNbPlaces ( int nbplaces)
    {//un set par pour modifier a chaque ajout de passager mais plutot pour la préférenc du chauffer
        while (nbplaces > 4 || nbplaces < 1) {
            this.nbplaces = nbplaces; //pour entrer les bonnes valeurs de places
        }
    }
}
