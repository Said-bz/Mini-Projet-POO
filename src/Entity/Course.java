package Entity;

import java.util.Scanner;

//(miko)
public class Course {

    public static int cptID = 0;

    private final int ID_Course;
    private final Chauffeur chauffeur;
    private Passager[] passagers;
    private int nbplacesDisp;
    private int indicePassagers = 0;
    private boolean isFinished = false;

    //(miko)
    public Course(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
        this.nbplacesDisp = chauffeur.nbPlaces;// OK car même package
        this.passagers = new Passager[chauffeur.nbPlaces];  // Initialisation du tableau
        cptID++;
        ID_Course = cptID;
    }

    //(miko)
    public boolean addPassager(Passager passager) {
        if (indicePassagers < nbplacesDisp) {
            passagers[indicePassagers] = passager;
            indicePassagers++;
            nbplacesDisp--;//nb de places réstantes
            return true;// ajout avec success
        }
        return false;//erreur d'ajout
    }

    public void finCourse(Chauffeur C){

        Scanner Clavier = new Scanner(System.in);
        this.isFinished = true;

        for(int i = 0; i < indicePassagers; i++){
            System.out.println("Noter Le Passager N°" + (i + 1) + " : ");
            passagers[i].updateReputation(Clavier.nextDouble());
        }
    }

    public void finCourse(Passager P){
        Scanner Clavier = new Scanner(System.in);
        this.isFinished = true;
        System.out.println("Noter Le Chauffeur : ");
        chauffeur.updateReputation(Clavier.nextDouble());
    }

    public String getPassagerMatricule() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < indicePassagers; i++) {
            temp.append(passagers[i].getMatricule()).append(" ");
        }
        return temp.toString();
    }

    public String toFileString(){
        return ID_Course + " " + chauffeur.getMatricule() + " " + indicePassagers + " " +
                this.getPassagerMatricule() + " " + isFinished;
    }

    public int getIdCourse() {
        return ID_Course;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public Passager[] getPassagers() {
        return passagers;
    }
}