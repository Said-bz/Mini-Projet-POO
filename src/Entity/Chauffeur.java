package Entity;

import java.util.List;

public class Chauffeur {

    private List<String> pointDeRamassage;
    private Profil profil;

    // Consturcteur
    public Chauffeur(List<String> pointDeRamassage, Profil profil){
        this.profil = profil;
        this.pointDeRamassage = pointDeRamassage;
    }

    // Setteurs
    public void setPointDeRamassage(List<String> pointDeRamassage){
        this.pointDeRamassage = pointDeRamassage;
    }
    public void setProfil(Profil profil){
        this.profil = profil;
    }

    // Getteurs
    public List<String> getPointDeRamassage(){
        return pointDeRamassage;
    }

    public Profil getProfil(){
        return profil;
    }


}
