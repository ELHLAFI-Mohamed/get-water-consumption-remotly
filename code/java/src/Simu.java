import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.SystemColor;

public class Simu extends JFrame  {

	
	
	private JLabel lblLesCompteursAvec;
	private JTable table;
	private JTable table_1;
	String[] s= {
			"Num_region", "Num_secteur", "Num_maison", "Id_compteur", "Consommation", "Debit", "Etat"
	};
	DefaultTableModel model = new DefaultTableModel(s, 0);
	DefaultTableModel model1 = new DefaultTableModel(s, 0);
	

	/**
	 * Launch the application.
	 */
	public Simu() {
	
		this.getContentPane().setBackground(Color.WHITE);
		this.setBounds(500, 500, 1590, 607);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		JLabel lblLesCompteursAvec_1 = new JLabel("              Les compteurs avec anomalie");
		lblLesCompteursAvec_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLesCompteursAvec_1.setForeground(Color.RED);
		lblLesCompteursAvec_1.setBounds(1081, 310, 273, 27);
		this.getContentPane().add(lblLesCompteursAvec_1);
		
		table = new JTable();
		
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(0, 350, 704, 112);
		this.getContentPane().add(table);
	table_1 = new JTable();
	table_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	table_1.setCellSelectionEnabled(true);
	table_1.setColumnSelectionAllowed(true);
	table_1.setBounds(794, 350, 766, 112);
	this.getContentPane().add(table_1);
		
	model.setRowCount(0);
	 model.addRow(new Object[]{" Num_region", "Num_secteur", "Num_maison", "Id_compteur", "Consommation(L)", "Debit(L/m)", "Etat"});
	 model1.setRowCount(0);
	 model1.addRow(new Object[]{" Num_region", "Num_secteur", "Num_maison", "Id_compteur", "Consommation(L)", "Debit(L/m)", "Etat"});
	 table.setModel(new DefaultTableModel(
	 	new Object[][] {
	 	},
	 	new String[] {
	 		"Num_region", "Num_secteur", "Num_maison", "Id_compteur", "Consommation", "Debit", "Etat"
	 	}
	 ));
	 table_1.setModel(new DefaultTableModel(
	 	new Object[][] {
	 	},
	 	new String[] {
	 		"Num_region", "Num_secteur", "Num_maison", "Id_compteur", "Consommation", "Debit", "Etat"
	 	}
	 ));
		
		lblLesCompteursAvec = new JLabel("Les compteurs avec etat normale ");
		lblLesCompteursAvec.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLesCompteursAvec.setBackground(new Color(153, 180, 209));
		lblLesCompteursAvec.setForeground(SystemColor.textHighlight);
		lblLesCompteursAvec.setBounds(148, 321, 289, 27);
		this.getContentPane().add(lblLesCompteursAvec);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\Radeeta2\\src\\header_radeej.jpg"));
		lblNewLabel.setBounds(347, 0, 1180, 240);
		this.getContentPane().add(lblNewLabel);
		this.setVisible(true);
	} 
	public  synchronized  void initialize(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit, boolean etat ) {
	
		
		if(etat==false) {
			 model.addRow(new Object[] { num_region, num_secteur, num_maison, id_compteur, consommation, debit,conver(etat)} );
			 table.setModel(model);
		 }
		 else {
			 model1.addRow(new Object[] { num_region, num_secteur, num_maison, id_compteur, consommation, debit,conver(etat)} );
			 table_1.setModel(model1);
		 }
		
	
	}
	public void conexion() {
		
		JLabel lblConnexion = new JLabel("Connexion ...");
		lblConnexion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConnexion.setForeground(Color.GREEN);
		lblConnexion.setBounds(644, 315, 211, 16);
		getContentPane().add(lblConnexion);
		
		
		
	}
	
	public String conver(boolean X) {
		if(X==false) {
			return "normale";
		}
		else return "Anormale" ;
	}
}
