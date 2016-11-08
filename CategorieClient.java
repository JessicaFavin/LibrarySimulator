public enum CategorieClient {
	ETUDIANT(20, 0.0, 0.5, 1.5), PARTICULIER(15, 10.0, 1.0, 1.0), ENTREPRISE(15, 30.0, 1.0, 1.0);
	private int empruntsMax;
	private Double cotisation;
	private Double coefTarif;
	private Double coefDuree;

	private CategorieClient(int empruntsMax, Double cotisation, Double coefTarif, Double coefDuree)
	{
		this.empruntsMax=empruntsMax;
		this.cotisation=cotisation;
		this.coefTarif=coefTarif;
		this.coefDuree=coefDuree;

	}
	public String toString(){
		return this.name()+" "+empruntsMax+" "+cotisation+" "+coefTarif+" "+coefDuree;
	}


	public int getEmpruntsMax(){
		return this.empruntsMax;
	}
	public Double getCotisation(){
		return this.cotisation;
	}
	public Double getCoefTarif(){
		return this.coefTarif;
	}
	public Double getCoefDuree(){
		return this.coefDuree;
	}


}
