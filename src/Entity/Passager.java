package Entity;

public class Passager extends User{

    private String pointDeRamassage; // 1 seul Point de Ramassage pour le passager
    private double reputation = 0.0;
    private int cptReputation = 0;

    // (miko)
    public Passager(String nom, String prenom, String matricule,
                String sex, Profil profil, double reputation,String pointDeRamassage) {
        super(nom, prenom, matricule, sex, profil);
        this.reputation = reputation;
        this.pointDeRamassage = pointDeRamassage;
    }

    // 2éme Constructeur, Plus pratique (said)
    public Passager(User U, double reputation,String pointDeRamassage) {

        super(U.getNom(),U.getPrenom(),U.getMatricule(),/*U.getReputation(),*/ U.getSexe(),U.getProfil());

        this.reputation = reputation;
        this.pointDeRamassage = pointDeRamassage;
    }

    public String getPointDeRamassage() {
        return pointDeRamassage;
    }

    public double getReputation() {
        return reputation;
    }

    public void updateReputation(double reputation){
        this.cptReputation++;
        this.reputation = ((this.reputation * (cptReputation - 1)) + reputation) / cptReputation;
    }

    @Override
    public String toFileString(){

        return  this.getMatricule() + " " + String.join(" ",this.getProfil().getPreferences()) + " " +
                this.getProfil().getDestination() + " "  + pointDeRamassage + " " + this.getReputation();
    }

}