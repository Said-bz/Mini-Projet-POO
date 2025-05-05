package Entity;

import java.util.List;

public class Profil {

    // pour cette classe les attributs sont privées et on utilise des setteurs pour s’assurer qu’on rentre les bonnes valeurs
    private String statut;
    private String Destination; // on a choisi une liste car il pourrait y avoir plusieurs point de passage
    private List<String> preferences; // la même chose plusieurs préférences
    private String disponibilites; // on a pas utilisé de liste car les possibilités sont dans l'intitulé
    private String typeDeCourse;

    // Constructeur
    public Profil(String statut, String Destination, List<String> preferences,
                  String disponibilites, String typeDeCourse) {
        setStatut(statut);
        setDestination(Destination);
        setPreferences(preferences);
        setDisponibilites(disponibilites);
        setTypeDeCourse(typeDeCourse);
    }

    // Getters
    public String getStatut() {
        return statut;
    }

    public String getDestination() {
        return Destination;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public String getDisponibilites() {
        return disponibilites;
    }

    public String getTypeDeCourse() {
        return typeDeCourse;
    }

    // Setters
    public void setStatut(String statut) {
        if (statut.equals("Chauffeur") ||
                statut.equals("chauffeur") ||
                statut.equals("Passager") ||
                statut.equals("passager")) {

            // Normaliser pour enregistrer proprement avec majuscule
            if (statut.equals("chauffeur")) {
                this.statut = "Chauffeur";
            } else if (statut.equals("passager")) {
                this.statut = "Passager";
            } else {
                this.statut = statut; // Déjà bien écrit
            }

        } else {
            System.out.println("ERREUR : Statut invalide.");
        }
    }

    public void setDestination(String destination) {
        if (destination == null || destination.isEmpty()) {
            System.out.println("Erreur : La liste des itinéraires ne peut pas être vide.");
        } else {
            this.Destination = destination;
        }
    }

    public void setPreferences(List<String> preferences) {
        if (preferences == null) {
            System.out.println("Erreur : Les préférences ne peuvent pas être nulles.");
        } else {
            this.preferences = preferences;
        }
    }

    public void setDisponibilites(String disponibilites) {
        if (disponibilites != null &&
                (disponibilites.equals("Journalier") ||
                        disponibilites.equals("Hebdomadaire") ||
                        disponibilites.equals("Quotidien"))) {
            this.disponibilites = disponibilites;
        } else {
            System.out.println("Erreur : Disponibilité invalide ou nulle (" + disponibilites + ")");
        }
    }

    public void setTypeDeCourse(String typeDeCourse) {
        if (typeDeCourse != null &&
                (typeDeCourse.equals("Aller simple") ||
                        typeDeCourse.equals("Retour simple") ||
                        typeDeCourse.equals("Aller-retour"))) {
            this.typeDeCourse = typeDeCourse;
        } else {
            System.out.println("Erreur : Type de course invalide ou nul (" + typeDeCourse + ")");
        }
    }

    // Méthode toString pour afficher joliment un Profil
    @Override
    public String toString() {
        return  "Profil{ \n" +
                "Statut : " + statut + '\n' +
                "Destination : " + Destination + "\n" +
                "Preferences : " + preferences + "\n" +
                "Disponibilités : " + disponibilites + '\n' +
                "Type De Course : " + typeDeCourse + '\n' +
                "}";
    }
}