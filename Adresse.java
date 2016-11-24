
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

        @Override
	public String toString(){
		return numero + " " + voie + " " + nomVoie + " " + codePostal + " " + ville + " " + pays;
	}

	@Override
	public boolean equals(Object obj){
		boolean isEqual= false;
		if (obj != null && obj instanceof Adresse){
			Adresse adresse = (Adresse) obj;
			isEqual = this.numero==adresse.numero&&this.voie.equals(adresse.voie)
			&&this.nomVoie.equals(adresse.nomVoie)&&this.codePostal==adresse.codePostal
			&&this.ville.equals(adresse.ville)&&this.pays.equals(adresse.pays);
		}

		return isEqual;
	}

}
