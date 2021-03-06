import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends Thread {
	
	private String adress_ip ;
	private int port ;
	private String str = "initialize";
	private Simu F;
	private Lock kLock = new ReentrantLock();
	

	public Client(String adress_ip,int port,Simu F) {
		
		this.adress_ip=adress_ip;
		this.port=port;
		this.F=F;
	}
	
	public void  run() {
		try {
			
			Socket soc =new Socket(this.adress_ip,this.port);
			System.out.println("Connected");
			 BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			 str=br.readLine();
			 String b[]=str.split(";");
			 
			this.stocckdata(Integer.parseInt(b[0]),Integer.parseInt(b[1]),Integer.parseInt(b[2]),Integer.parseInt(b[3]),Float.parseFloat(b[4]),Float.parseFloat(b[5]));
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public   void stocckdata(int num_region,int num_secteur,int num_maison,int id_compteur,float consommation,float debit) throws InterruptedException {
		kLock.lock(); 
		try {
		System.out.println("Traitement");
		Data d=new Data(num_region, num_secteur, num_maison, id_compteur, consommation, debit);		
		d.traitement();
		Addtofram A =new Addtofram(d.getNum_region(),d.getNum_secteur(),d.getNum_maison(),d.getId_compteur(),d.getConsommation(),d.getDebit(),d.isEtat(),this.F);
		Datacenter D=new Datacenter(d.getNum_region(),d.getNum_secteur(),d.getNum_maison(),d.getId_compteur(),d.getConsommation(),d.getDebit(),d.isEtat());
		D.start();
		
		}finally{
			kLock.unlock();
			}
		
	}



}