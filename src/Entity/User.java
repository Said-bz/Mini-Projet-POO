package Entity;

public class User {
    // Attributs privés
    private String nom;
    private String prenom;
    private String matricule;
    private Profil profil;


    // Constructeur
    public User(String nom, String prenom, String matricule, Profil profil) {
        setNom(nom);
        setPrenom(prenom);
        setMatricule(matricule);
        setProfil(profil);
    }


    // Getters
    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public String getMatricule() {
        return matricule;
    }


    public Profil getProfil() {
        return profil;
    }


    // Setters
    public void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        } else {
            System.out.println("Erreur : Le nom ne peut pas être nul.");
        }
    }


    public void setPrenom(String prenom) {
        if (prenom != null) {
            this.prenom = prenom;
        } else {
            System.out.println("Erreur : Le prénom ne peut pas être nul.");
        }
    }


    public void setMatricule(String matricule) {
        if (matricule != null) {
            this.matricule = matricule;
        } else {
            System.out.println("Erreur : Le matricule ne peut pas être nul.");
        }
    }


    public void setProfil(Profil profil) {
        if (profil != null) {
            this.profil = profil;
        } else {
            System.out.println("Erreur : Le profil ne peut pas être nul.");
        }
    }
}
