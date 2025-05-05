package Entity;

public class User {
    // Attributs privés
    private String nom;
    private String prenom;
    private String matricule;
    private double reputation;
    private String sex;
    private Profil profil;


    // Constructeur
    public User(String nom, String prenom, String matricule, double reputation, String sex, Profil profil) {
        setNom(nom);
        setPrenom(prenom);
        setMatricule(matricule);
        setProfil(profil);
        setReputation(reputation);
        setSex(sex);
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

    public double getReputation() {
        return reputation;
    }

    public String getSex() {
        return sex;
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

    public void setReputation(double reputation){
        this.reputation = reputation;
    }

    public void setSex(String sex) {
        if (sex != null &&
                (sex.equals("Masculin")
                || sex.equals("Féminin"))) {
            this.sex = sex;
        } else {
            System.out.println("Erreur : Disponibilité invalide ou nulle (" + sex + ")");
        }
    }

    // Rajout de la Méthode toString dans User pour un affichage (Said)
    @Override
    public String toString(){
        return  "Nom : " + nom + "\n" +
                "Prenom : " + prenom + "\n" +
                "Matricule : " + matricule + "\n" +
                "Reputation : " + reputation + "\n" +
                "Sexe : " + sex + "\n" +
                profil.toString();


    }
}
