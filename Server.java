package NetworkJavaApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() throws Exception {
		
		ServerSocket server_socket = new ServerSocket(3030); //opening a new port
		System.out.println("Port 3030 is open.");
		
		Socket socket = server_socket.accept();
		System.out.println("Client " + socket.getInetAddress() + " has connected.");
		
		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
		int num=(int)(Math.random()*10+1);
		String client_guess;
		
		do{
		out_socket.print("Guess a number in [1,10]"); // Ask the Client 
		client_guess = in_socket.readLine();
		}while(! (Integer.parseInt(client_guess)== num));
		
		System.out.println("You got it!!!");
		
		socket.close();
		System.out.println("Socket is closed.");
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}