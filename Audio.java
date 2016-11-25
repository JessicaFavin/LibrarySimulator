
public class Audio extends Document {

    //durée de l'emprunt en jours
    public final int DUREE_EMPRUNT  = 10;
    //tarif de l'emprunt en euros
    public final int TARIF          = 5;
    //durrée du document audio en minutes
    private     double  dureeCD;

    public Audio(String titre, String auteur, int annee, String isbn, String genre, String salle, String rayon, double dureeCD){
        //super(titre, auteur, annee, isbn, genre, salle, rayon);
        this.titre      = titre;
        this.auteur     = auteur;
        this.annee      = annee;
        this.isbn       = isbn;
        this.genre      = genre;
        this.salle      = salle;
        this.rayon      = rayon;
        this.emprunte   = false;
        this.dureeCD    = dureeCD;
    }

    /**
     *
     * @return durée du document audio en minutes
     */
    public double getDureeCD(){
        return this.dureeCD;
    }

    @Override
    public String toString(){
        String str = "AUDIO\n";
        str += "Titre: "+titre+"\n";
        str += "Auteur(e): "+auteur+"\n";
        str += "Année: "+annee+"\n";
        str += "Durée: "+dureeCD+" min\n";
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
		if (obj != null && obj instanceof Audio){
			Audio audio = (Audio) obj;
			isEqual = this.annee==audio.annee&&this.titre.equals(audio.titre)
			&&this.auteur.equals(audio.auteur)&&this.dureeCD==audio.dureeCD
			&&this.isbn.equals(audio.isbn)&&this.genre.equals(audio.genre)
            &&this.salle.equals(audio.salle)&&this.rayon.equals(audio.rayon);
		}

		return isEqual;
	}

}
