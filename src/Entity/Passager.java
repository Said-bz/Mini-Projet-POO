package Entity;

public class Passager extends User{

    private Course course;// sa seule course
    private Chauffeur chauffeur;//logiquement son seul chauffeur
    private String pointDeRamassage; // 1 seul Point de Ramassage pour le passager

    // (miko)
    public Passager(String nom, String prenom, String matricule, double reputation,
                String sex, Profil profil, Course course, Chauffeur chauffeur) {
        super(nom, prenom, matricule, reputation, sex, profil);
        this.course = course;
        this.chauffeur = chauffeur;
    }

    // 2éme Constructeur, Plus pratique (said)
    public Passager(User U, Course course, Chauffeur chauffeur) {

        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getReputation(),U.getSex(),U.getProfil());
        this.course = course;
        this.chauffeur = chauffeur;
    }
}