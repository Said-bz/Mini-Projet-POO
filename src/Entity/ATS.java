package Entity;

public class ATS extends User {

    // Attributs propres à un ATS
    private int anneeRecrutement;
    private String service;

    // Constructeur complet avec héritage depuis User (rahim)
    public ATS(String nom, String prenom, String matricule, double reputation,String sex, Profil profil,
               int anneeRecrutement, String service) {
        super(nom, prenom, matricule,sex, profil); // appel au constructeur de User
        setAnneeRecrutement(anneeRecrutement);
        setService(service);
    }

    // 2eme Constructeur (said)
    public ATS(User U,  int anneeRecrutement, String service) {
        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getSexe(),U.getProfil());
        setAnneeRecrutement(anneeRecrutement);
        setService(service);
    }

    // Getter pour l'année de recrutement (rahim)
    public int getAnneeRecrutement() {
        return anneeRecrutement;
    }

    // Setter avec validation de l'année (entre 1900 et l'année actuelle) (rahim)
    public void setAnneeRecrutement(int anneeRecrutement) {
        int currentYear = java.time.Year.now().getValue();
        if (anneeRecrutement > 1900 && anneeRecrutement <= currentYear) {
            this.anneeRecrutement = anneeRecrutement;
        } else {
            System.out.println("Erreur : L'année de recrutement doit être comprise entre 1900 et " + currentYear);
        }
    }

    // Getter pour le service d'affectation (rahim)
    public String getService() {
        return service;
    }

    // Setter avec contrôle de validité (non nul, non vide) (rahim)
    public void setService(String service) {
        if (service != null && !service.trim().isEmpty()) {
            this.service = service;
        } else {
            System.out.println("Erreur : Le service ne peut pas être nul ou vide.");
        }
    }

    // Affichage personnalisé d’un ATS pour faciliter le debug ou l’affichage dans l’interface (rahim)
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "ATS{ \n" +
                "Recrutement : " + anneeRecrutement + "\n" +
                "Service : " + service + "\n" +
                "}";

    }
}