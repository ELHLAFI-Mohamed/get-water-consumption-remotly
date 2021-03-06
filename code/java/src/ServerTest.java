import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			ServerSocket listen=new ServerSocket(80);
			
				
				System.out.println("Wait for a new client.....");
				Socket soc=listen.accept();
				
				//try {
				System.out.println("New client connected!!");
				PrintWriter out = new PrintWriter(soc.getOutputStream(), true) ;
				out.println("2;2;2;6;80;40");
				
				/*	}finally {
					System.out.println("closing.....");
					soc.close();
				}*/
				
				
				
				
			}
			
			
			
			
			
		
	}


