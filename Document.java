import java.io.Serializable;

public abstract class Document implements Serializable {

    protected String  titre;
    protected String  auteur;
    protected int     annee;
    protected String  isbn;
    protected String  genre;
    protected String  salle;
    protected String  rayon;
    protected boolean emprunte;


    /*
    public Document(String titre, String auteur, int annee, String isbn, String genre, String salle, String rayon){
        this.titre      = titre;
        this.auteur     = auteur;
        this.annee      = annee;
        this.isbn       = isbn;
        this.genre      = genre;
        this.salle      = salle;
        this.rayon      = rayon;
        this.emprunte   = false;
    }
    */

    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public int getAnnee(){
        return this.annee;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public String getGenre(){
        return this.genre;
    }

    public String getSalle(){
        return this.salle;
    }

    public String getRayon(){
        return this.rayon;
    }

    public boolean getEmprunte(){
        return this.emprunte;
    }

    public abstract int getDureeEmprunt();

    public abstract int getTarif();

    public void setSalle(String salle){
        this.salle = salle;
    }

    public void setRayon(String rayon){
        this.rayon = rayon;
    }

    public void emprunte(){
        this.emprunte = true;
    }

    public void rendu(){
        this.emprunte = false;
    }

}
