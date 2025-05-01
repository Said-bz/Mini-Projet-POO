package Entity;

public class Enseignant extends User {
    private int anneeRecrutement; // Year of recruitment of the teacher
    private String faculte; // Faculty of the teacher

    // Parameterized constructor to initialize an Enseignant object with necessary attributes
    public Enseignant(String nom, String prenom, String matricule, double reputation, Profil profil,
                      int anneeRecrutement, String faculte) {
        super(nom, prenom, matricule, reputation, profil); // Calls the constructor of the parent class User
        setAnneeRecrutement(anneeRecrutement); // Sets the year of recruitment with validation
        setFaculte(faculte); // Sets the faculty with validation
    }

    // Getter for the year of recruitment
    public int getAnneeRecrutement() {
        return anneeRecrutement;
    }

    // Setter for the year of recruitment with validation to ensure it's a valid year
    public void setAnneeRecrutement(int anneeRecrutement) {
        int currentYear = java.time.Year.now().getValue(); // Retrieves the current year
        if (anneeRecrutement > 1900 && anneeRecrutement <= currentYear) { // Validates the year range
            this.anneeRecrutement = anneeRecrutement; // Sets the year if valid
        } else {
            System.out.println("Erreur : L'année de recrutement doit être comprise entre 1900 et " + currentYear);
        }
    }

    // Getter for the faculty name
    public String getFaculte() {
        return faculte;
    }

    // Setter for the faculty with validation to ensure it's not null or empty
    public void setFaculte(String faculte) {
        if (faculte != null && !faculte.trim().isEmpty()) { // Ensures the faculty name is not null or empty
            this.faculte = faculte; // Sets the faculty if valid
        } else {
            System.out.println("Erreur : La faculté ne peut pas être nulle ou vide.");
        }
    }

    // Custom toString method to represent an Enseignant object as a string
    @Override
    public String toString() {
        // Returns a formatted string with all relevant information about the Enseignant
        return "Enseignant : " + getNom() + " " + getPrenom() +
                ", Matricule : " + getMatricule() +
                ", Réputation : " + getReputation() +
                ", Recrutement : " + anneeRecrutement +
                ", Faculté : " + faculte +
                ", Profil : " + getProfil();
    }
}
