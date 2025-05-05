package Entity;

//(miko)
public class Course {
    private Chauffeur chauffeur;
    private Passager[] passagers;
    private int nbplacesDisp;
    private int indicePassagers = 0;

    //(miko)
    public Course(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
        this.nbplacesDisp = chauffeur.nbplaces; // OK car même package
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

    // (miko)
    public boolean suppPassager(Passager passager) {
        for (int i = 0; i < indicePassagers; i++) {
            if (passagers[i] == passager) { // Comparaison par référence
                // Décalage manuel des éléments vers la gauche
                for (int j = i; j < indicePassagers - 1; j++) {
                    passagers[j] = passagers[j + 1]; // Même si passagers[j+1] est null, c'est OK
                }
                // Nettoyage de la dernière référence et mise à jour des compteurs
                passagers[indicePassagers - 1] = null;
                indicePassagers--;
                nbplacesDisp++;
                return true;
            }
        }
        return false;
    }
}