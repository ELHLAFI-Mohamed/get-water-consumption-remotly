import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Simu window=new Simu();
		Client t = null;
		
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/radee_ta?autoReconnect=true&useSSL=false","root","root");  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from adress ");  
	window.conexion();
	while(rs.next()) {
		
		 t=new Client(rs.getString("Adresse_ip"),rs.getInt("Port_ip"),window);
		t.start();
		 
       
	}
	 
	t.join();
}
}
