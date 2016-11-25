
public class Livre extends Document {

    //durée de l'emprunt en jours
    public final int DUREE_EMPRUNT  = 30;
    //tarif de l'emprunt en euros
    public final int TARIF          = 5;
    //nombre de pages du livre
    private      int  nbPages;

    public Livre(String titre, String auteur, int annee, String isbn, String genre, String salle, String rayon, int nbPages){
        //super(titre, auteur, annee, isbn, genre, salle, rayon);
        this.titre      = titre;
        this.auteur     = auteur;
        this.annee      = annee;
        this.isbn       = isbn;
        this.genre      = genre;
        this.salle      = salle;
        this.rayon      = rayon;
        this.emprunte   = false;
        this.nbPages    = nbPages;
    }

    /**
     * @return le nombre de pages du livre
     */
    public int getNbPages(){
        return this.nbPages;
    }

    @Override
    public String toString(){
        String str = "LIVRE\n";
        str += "Titre: "+titre+"\n";
        str += "Auteur(e): "+auteur+"\n";
        str += "Année: "+annee+"\n";
        str += "Nb pages: "+nbPages+"\n";
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
        if (obj != null && obj instanceof Livre){
            Livre livre = (Livre) obj;
            isEqual = this.annee==livre.annee&&this.titre.equals(livre.titre)
            &&this.auteur.equals(livre.auteur)&&this.nbPages==livre.nbPages
            &&this.isbn.equals(livre.isbn)&&this.genre.equals(livre.genre)
            &&this.salle.equals(livre.salle)&&this.rayon.equals(livre.rayon);
        }

        return isEqual;
    }

}
