package Entity;

public class Etudiant extends User {

    // Attributs spécifiques à un étudiant
    private int anneeAdmission;
    private String faculte;
    private String specialite;

    // Constructeur avec tous les paramètres nécessaires (hérités + spécifiques)
    public Etudiant(String nom, String prenom, String matricule, double reputation, Profil profil,
                    int anneeAdmission, String faculte, String specialite) {
        super(nom, prenom, matricule, /*reputation,*/ profil); // appel au constructeur de User
        setAnneeAdmission(anneeAdmission);
        setFaculte(faculte);
        setSpecialite(specialite);
    }

    // Getter pour l'année d'admission
    public int getAnneeAdmission() {
        return anneeAdmission;
    }

    // Setter avec vérification de validité (entre 1900 et l'année actuelle)
    public void setAnneeAdmission(int anneeAdmission) {
        int currentYear = java.time.Year.now().getValue();
        if (anneeAdmission > 1900 && anneeAdmission <= currentYear) {
            this.anneeAdmission = anneeAdmission;
        } else {
            System.out.println("Erreur : L'année d'admission doit être comprise entre 1900 et " + currentYear);
        }
    }

    // Getter pour la faculté
    public String getFaculte() {
        return faculte;
    }

    // Setter avec contrôle (non nul et non vide)
    public void setFaculte(String faculte) {
        if (faculte != null && !faculte.trim().isEmpty()) {
            this.faculte = faculte;
        } else {
            System.out.println("Erreur : La faculté ne peut pas être nulle ou vide.");
        }
    }

    // Getter pour la spécialité
    public String getSpecialite() {
        return specialite;
    }

    // Setter avec contrôle (non nul et non vide)
    public void setSpecialite(String specialite) {
        if (specialite != null && !specialite.trim().isEmpty()) {
            this.specialite = specialite;
        } else {
            System.out.println("Erreur : La spécialité ne peut pas être nulle ou vide.");
        }
    }

    // Redéfinition de toString pour un affichage lisible d'un étudiant
    @Override
    public String toString() {
        return "Étudiant : " + getNom() + " " + getPrenom() +
                ", Matricule : " + getMatricule() +
                /*", Réputation : " + getReputation() +*/
                ", Admission : " + anneeAdmission +
                ", Faculté : " + faculte +
                ", Spécialité : " + specialite +
                ", Profil : " + getProfil();
    }
}
