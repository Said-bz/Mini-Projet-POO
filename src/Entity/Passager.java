package Entity;

public class Passager {

    private String pointDeRamassage;
    private Profil profil;

    // Consturcteur
    public Passager(String pointDeRamassage, Profil profil){
        this.profil = profil;
        this.pointDeRamassage = pointDeRamassage;
    }

    // Setteurs
    public void setPointDeRamassage(String pointDeRamassage){
        this.pointDeRamassage = pointDeRamassage;
    }
    public void setProfil(Profil profil){
        this.profil = profil;
    }

    // Getteurs
    public String getPointDeRamassage(){
        return pointDeRamassage;
    }

    public Profil getProfil(){
        return profil;
    }


}
