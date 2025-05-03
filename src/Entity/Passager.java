package Entity;

public class Passager extends User{

    private Course course;// sa seule course
    private Chauffeur chauffeur;//logiquement son seul chauffeur

    public Passager(String nom, String prenom, String matricule, double reputation,
                String sex, Profil profil, Course course, Chauffeur chauffeur) {
        super(nom, prenom, matricule, reputation, sex, profil);
        this.course = course;
        this.chauffeur = chauffeur;
    }
}