import java.io.Serializable;

public class Adresse implements Serializable {

	private int numero;
	private String voie;
	private String nomVoie;
	private int codePostal;
	private String ville;
	private String pays;

	public Adresse(int numero, String voie, String nomVoie, int codePostal, String ville, String pays){
		this.numero=numero;
		this.voie=voie;
		this.nomVoie=nomVoie;
		this.codePostal=codePostal;
		this.ville=ville;
		this.pays=pays;

	}

	public String toString(){
		return numero + " " + voie + " " + nomVoie + " " + codePostal + " " + ville + " " + pays;
	}


}
