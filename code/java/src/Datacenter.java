import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Datacenter extends Thread {
	private int num_region,num_secteur,num_maison,id_compteur ;
	private float consommation ,debit ;
	private boolean etat ;
	public  Datacenter(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit, boolean etat) {
		
		this.consommation=consommation;
		this.debit=debit;
		this.id_compteur=id_compteur;
		this.num_region=num_region;
		this.num_maison=num_maison;
		this.num_secteur=num_secteur;
		this.etat=etat;
	}
	public void run() {
		
		update(this.num_region,this.num_secteur,this.num_maison,this.id_compteur,this.consommation,this.debit,this.etat);
		
		
	}
	
	public void update(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit, boolean etat) {
		
		Connection con;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/radee_ta?autoReconnect=true&useSSL=false","root","root");
			String query = "update data_user set consomation = ?,debit=?,etat=?  where num_maison=? and id_compteur=?";
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
			preparedStmt.setFloat(1,this.consommation);
			preparedStmt.setFloat(2,this.debit);
			preparedStmt.setString(3,conver(this.etat));
			preparedStmt.setInt(4,this.num_maison);
			preparedStmt.setInt(5,this.id_compteur);
			preparedStmt.executeUpdate();
			con.close();
			
		
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String conver(boolean X) {
		if(X==false) {
			return "normale";
		}
		else return "Anormale" ;
	}


}
