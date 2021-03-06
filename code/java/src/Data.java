
public class Data {
	private int num_region,num_secteur,num_maison,id_compteur ;
	private float consommation ,debit ;
	private boolean etat ;
	
	
	public   Data(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit) {
		this.consommation=consommation;
		this.debit=debit;
		this.id_compteur=id_compteur;
		this.num_region=num_region;
		this.num_maison=num_maison;
		this.num_secteur=num_secteur;
		
		
	}
	
	
	
	
	public int getNum_region() {
		return num_region;
	}
	public void setNum_region(int num_region) {
		this.num_region = num_region;
	}
	public int getNum_secteur() {
		return num_secteur;
	}
	public void setNum_secteur(int num_secteur) {
		this.num_secteur = num_secteur;
	}
	public int getNum_maison() {
		return num_maison;
	}
	public void setNum_maison(int num_maison) {
		this.num_maison = num_maison;
	}
	public int getId_compteur() {
		return id_compteur;
	}
	public void setId_compteur(int id_compteur) {
		this.id_compteur = id_compteur;
	}
	public float getConsommation() {
		return consommation;
	}
	public void setConsommation(float consommation) {
		this.consommation = consommation;
	}
	public float getDebit() {
		return debit;
	}
	public void setDebit(float debit) {
		this.debit = debit;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public  void  traitement() {
		if(this.debit>30) {
			this.setEtat(true);
		}
		else this.setEtat(false);
		
		
	}
	

}
