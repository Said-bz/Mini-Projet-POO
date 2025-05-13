package Entity;

import java.util.Arrays;

public class Chauffeur extends User {

    // Version (Said)

    private double reputation;
    private int cptReputation = 0;
    private String[] pointDeRamassage; // Plusieurs Points de Ramassage pour un seul Chauffeur
    int nbPlaces;

    // 2éme Constructeur, Plus pratique a L'utilisation (said)
    public Chauffeur(User U, int nbplaces,String[] pointDeRamassage) { //le constructeur

        super(U.getNom(),U.getPrenom(),U.getMatricule(),U.getSexe(),U.getProfil());
        this.nbPlaces = nbplaces;
        this.pointDeRamassage = pointDeRamassage;
    }

    public void updateReputation(double reputation){
        this.cptReputation++;
        this.reputation = ((this.reputation * (cptReputation - 1)) + reputation) / cptReputation;
    }

    public double getReputation() {
        return reputation;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public String[] getPointDeRamassage() {
        return pointDeRamassage;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
                " Nombre de Places : " + this.getNbPlaces() + "\n" +
                "Reputation : " + this.getReputation() + "\n" +
                "Points De Ramassage : " + Arrays.toString(pointDeRamassage);
    }

    @Override
    public String toFileString(){
        return  this.getMatricule() + " " +  String.join(" ",this.getProfil().getPreferences()) + " " +
                this.getProfil().getDestination() + " " + String.join(" ",pointDeRamassage) + " " +
                this.getReputation() + " " + this.getNbPlaces();
    }

}
