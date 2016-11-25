
public class Video extends Document {

    //durée de l'emprunt en jours
    public final int DUREE_EMPRUNT  = 15;
    //tarif de l'emprunt en euros
    public final int TARIF          = 10;
    //durrée du document vidéo en minutes
    private     double dureeDVD;

    public Video(String titre, String auteur, int annee, String isbn, String genre, String salle, String rayon, double dureeDVD){
        //super(titre, auteur, annee, isbn, genre, salle, rayon);
        this.titre      = titre;
        this.auteur     = auteur;
        this.annee      = annee;
        this.isbn       = isbn;
        this.genre      = genre;
        this.salle      = salle;
        this.rayon      = rayon;
        this.emprunte   = false;
        this.dureeDVD   = dureeDVD;
    }

    /**
     * @return la durée du document video en minutes
     */
    public double getDureeDVD(){
        return this.dureeDVD;
    }

    @Override
    public String toString(){
        String str = "VIDEO\n";
        str += "Titre: "+titre+"\n";
        str += "Réalisateur(trice): "+auteur+"\n";
        str += "Année: "+annee+"\n";
        str += "Durée: "+dureeDVD+" min\n";
        str += "ISBN: "+isbn+"\n";
        str += "Genre: "+genre+"\n";
        str += "Localisation: salle "+salle+" rayon "+rayon+"\n";
        return str;
    }

    @Override
    public int getDureeEmprunt(){
        return this.DUREE_EMPRUNT;
    }

    @Override
    public int getTarif(){
        return this.TARIF;
    }

    @Override
    public boolean equals(Object obj){
        boolean isEqual= false;
        if (obj != null && obj instanceof Video){
            Video video = (Video) obj;
            isEqual = this.annee==video.annee&&this.titre.equals(video.titre)
            &&this.auteur.equals(video.auteur)&&this.dureeDVD==video.dureeDVD
            &&this.isbn.equals(video.isbn)&&this.genre.equals(video.genre)
            &&this.salle.equals(video.salle)&&this.rayon.equals(video.rayon);
        }

        return isEqual;
    }

}
