package Entity;

public class Enseignant extends User {
    private int anneeRecrutement; // Year of recruitment of the teacher
    private String faculte; // Faculty of the teacher

    // 2eme Constructeur (Said)
    public Enseignant(User U, int anneeRecrutement, String faculte) {
        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getSexe(),U.getProfil());
        setAnneeRecrutement(anneeRecrutement); // Sets the year of recruitment with validation
        setFaculte(faculte); // Sets the faculty with validation
    }

    // Setter for the year of recruitment with validation to ensure it's a valid year (rahim)
    public void setAnneeRecrutement(int anneeRecrutement) {
        int currentYear = java.time.Year.now().getValue(); // Retrieves the current year
        if (anneeRecrutement > 1900 && anneeRecrutement <= currentYear) { // Validates the year range
            this.anneeRecrutement = anneeRecrutement; // Sets the year if valid
        } else {
            System.out.println("Erreur : L'année de recrutement doit être comprise entre 1900 et " + currentYear);
        }
    }

    // Setter for the faculty with validation to ensure it's not null or empty
    public void setFaculte(String faculte) {
        if (faculte != null && !faculte.trim().isEmpty()) { // Ensures the faculty name is not null or empty
            this.faculte = faculte; // Sets the faculty if valid
        } else {
            System.out.println("Erreur : La faculté ne peut pas être nulle ou vide.");
        }
    }

    // Custom toString method to represent an Enseignant object as a string (rahim)
    @Override
    public String toString() {
        // Returns a formatted string with all relevant information about the Enseignant
        return  super.toString() + "\n" +
                "Enseignant{\n" +
                "Recrutement : " + anneeRecrutement + "\n" +
                "Faculté : " + faculte + "\n" +
                "}";
    }
}
