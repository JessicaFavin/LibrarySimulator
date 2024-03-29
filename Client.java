
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

public class Client implements Serializable {
	private String nom;
	private String prenom;
	private Adresse adresse;
	private CategorieClient categorie;
	private final Date dateInscription;
	private Date dateRenouvellement;
	private int nbEmprunts;
	private int nbRetards;
    private String username;
    private String password;


	public Client( String nom, String prenom, Adresse adresse, CategorieClient categorie) {
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.categorie=categorie;
		Calendar calendar = Calendar.getInstance();
        dateInscription = calendar.getTime();
		calendar.add(Calendar.YEAR,1);
		calendar.add(Calendar.DAY_OF_MONTH,-1);
		dateRenouvellement = calendar.getTime();
        this.username = (prenom+nom).toLowerCase();
        this.password = username;
	}

	public String getNom(){
		return this.nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
	public Adresse getAdresse(){
		return this.adresse;
	}
	public CategorieClient getCategorie(){
		return this.categorie;
	}
	public Date getDateInscription(){
		return this.dateInscription;
	}
	public Date getDateRenouvellement(){
		return this.dateRenouvellement;
	}
	public int getNbEmprunts(){
		return this.nbEmprunts;
	}
	public int getNbRetards(){
		return this.nbRetards;
	}

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

	public void setNom( String nom){
		this.nom=nom;
	}
	public void setPrenom( String prenom){
		this.prenom=prenom;
	}
	public void setAdresse( Adresse adresse){
		this.adresse=adresse;
	}
	public void setCategorie( CategorieClient categorie){
		this.categorie=categorie;
	}
	public void setDateRnouvellement( Date dateRenouvellement){
		this.dateRenouvellement=dateRenouvellement;
	}

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

	public boolean ajoutEmprunt(){
		if (this.categorie.getEmpruntsMax()>this.nbEmprunts){
			nbEmprunts++;
			return true;
		}
		else {
			return false;
		}
	}

	public boolean retireEmprunt(){
		if(this.nbEmprunts>0){
			nbEmprunts--;
			return true;
		}
		else {
			return false;
		}
	}

	public boolean ajoutRetard(){
		nbRetards++;
		return true;
	}

	public boolean retireRetard(){
		nbRetards++;
		return true;
	}

        @Override
	public String toString(){
		SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/Y");
		return prenom + " " + nom + " " +", Adresse: "+ adresse + "\n" + "Inscripton: "+dateFormatter.format(dateInscription) + " Renouvellement: " + dateFormatter.format(dateRenouvellement) + "\nEmprunts: " + nbEmprunts + ", Retards: " + nbRetards+"\n";

	}

	@Override
	public boolean equals(Object obj){
		boolean isEqual= false;
		if (obj != null && obj instanceof Client){
			Client client = (Client) obj;
			isEqual = this.nom.equals(client.nom)&&this.prenom.equals(client.prenom)&&this.adresse.equals(client.adresse);
		}

		return isEqual;
	}

}
