package Entity;

public class User {
    // Attributs privés
    private String nom;
    private String prenom;
    private String matricule;
    private String sexe;
    private Profil profil;
    private boolean isActive;


    // Constructeur (houssem)
    public User(String nom, String prenom, String matricule, String sexe, Profil profil) {
        setNom(nom);
        setPrenom(prenom);
        setMatricule(matricule);
        setProfil(profil);
        setSexe(sexe);
    }
    public User(String nom, String prenom, String matricule, String sexe, Profil profil, boolean isActive) {
        setNom(nom);
        setPrenom(prenom);
        setMatricule(matricule);
        setProfil(profil);
        setSexe(sexe);
        setActive(isActive);
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean getActive(){
        return isActive;
    }

    // Getters (houssem)
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

    public String getSexe() {
        return sexe;
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

    public void setSexe(String sexe) {
        if (sexe != null &&
                (sexe.equals("Masculin")
                || sexe.equals("Féminin"))) {
            this.sexe = sexe;
        } else {
            System.out.println("Erreur : Disponibilité invalide ou nulle (" + sexe + ")");
        }
    }

    // Rajout de la Méthode toString dans User pour un affichage (Said)
    @Override
    public String toString(){
        return  "Nom : " + nom + "\n" +
                "Prenom : " + prenom + "\n" +
                "Matricule : " + matricule + "\n" +
                "Sexe : " + sexe + "\n" +
                profil.toString();
    }

    public String toFileString(){
        return getMatricule() + " " + getNom() + " " + getPrenom() + " " + getSexe() + " " + isActive + " "
                + getProfil().toFileString();
    }
}
