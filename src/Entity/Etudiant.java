package Entity;

public class Etudiant extends User {

    // Attributs spécifiques à un étudiant
    private int anneeAdmission;
    private String faculte;
    private String specialite;

    // Constructeur avec tous les paramètres nécessaires (hérités + spécifiques) (rahim)
    public Etudiant(String nom, String prenom, String matricule, double reputation,String sex, Profil profil,
                    int anneeAdmission, String faculte, String specialite) {
        super(nom, prenom, matricule, reputation,sex, profil); // appel au constructeur de User
        setAnneeAdmission(anneeAdmission);
        setFaculte(faculte);
        setSpecialite(specialite);
    }

    // 2eme Constructeur (said)
    public Etudiant(User U, int anneeAdmission, String faculte, String specialite) {
        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getReputation(),U.getSex(),U.getProfil());
        setAnneeAdmission(anneeAdmission);
        setFaculte(faculte);
        setSpecialite(specialite);
    }

    // Getter pour l'année d'admission (rahim)
    public int getAnneeAdmission() {
        return anneeAdmission;
    }

    // Setter avec vérification de validité (entre 1900 et l'année actuelle) (rahim)
    public void setAnneeAdmission(int anneeAdmission) {
        int currentYear = java.time.Year.now().getValue();
        if (anneeAdmission > 1900 && anneeAdmission <= currentYear) {
            this.anneeAdmission = anneeAdmission;
        } else {
            System.out.println("Erreur : L'année d'admission doit être comprise entre 1900 et " + currentYear);
        }
    }

    // Getter pour la faculté (rahim)
    public String getFaculte() {
        return faculte;
    }

    // Setter avec contrôle (non nul et non vide) (rahim)
    public void setFaculte(String faculte) {
        if (faculte != null && !faculte.trim().isEmpty()) {
            this.faculte = faculte;
        } else {
            System.out.println("Erreur : La faculté ne peut pas être nulle ou vide.");
        }
    }

    // Getter pour la spécialité (rahim)
    public String getSpecialite() {
        return specialite;
    }

    // Setter avec contrôle (non nul et non vide) (rahim)
    public void setSpecialite(String specialite) {
        if (specialite != null && !specialite.trim().isEmpty()) {
            this.specialite = specialite;
        } else {
            System.out.println("Erreur : La spécialité ne peut pas être nulle ou vide.");
        }
    }

    // Redéfinition de toString pour un affichage lisible d'un étudiant (rahim)
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Etudiant{\n" +
                "Admission : " + anneeAdmission + "\n" +
                "Faculté : " + faculte + "\n" +
                "Spécialité : " + specialite + "\n" +
                "}";

    }
}
