import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Addtofram extends Thread {
	private int num_region,num_secteur,num_maison,id_compteur ;
	private float consommation ,debit ;
	private boolean etat ;
	private Simu F;
	
	
	public Addtofram(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit, boolean etat,Simu F) {
		
		this.consommation=consommation;
		this.debit=debit;
		this.id_compteur=id_compteur;
		this.num_region=num_region;
		this.num_maison=num_maison;
		this.num_secteur=num_secteur;
		this.etat=etat;
		this.F=F;
		
		init( this.num_region, this.num_secteur, this.num_maison, this.id_compteur, this.consommation, this.debit,this.etat,this.F);
		
	}
	
		
	
	
	private synchronized  void init(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit, boolean etat,Simu F ) {
		
		
		
	this.F.initialize(num_region,num_secteur,num_maison,id_compteur,consommation,debit,etat);
		
		
				 			
		
	}
	
	

}
