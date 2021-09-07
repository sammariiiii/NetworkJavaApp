package NetworkJavaApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception {
		
		Socket socket = new Socket("localhost",3030);
		System.out.println("Successful connection to the server.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()), true);
		Scanner keyboard= new Scanner(System.in);
        String user_num;
        while(in_socket.readLine().startsWith("Guess")){
            System.out.println("server says : Guess a number in [1,10]");
            user_num=keyboard.nextLine();// prompt the user to enter an integer
            out_socket.println(user_num);// send the user guess to the server

        }
		
		socket.close();
		System.out.println("Socket closed.");
		
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}