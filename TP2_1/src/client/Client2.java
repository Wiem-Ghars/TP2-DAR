package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Connexion au serveur
		System.out.println("Je suis un client pas encore connecté...");
		
		try {
			
			Socket socket =new Socket("localhost",104);
			System.out.println("Je suis un client connecté");
			
			//Lecture d'un entier
			Scanner scanner = new Scanner(System.in);
			
			 //Flux de communication
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			//Flux de traitement
			PrintWriter pw = new PrintWriter(os,true);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//Envoie du premier entier
			System.out.println("Tapez Le premier entier");
			int nb1 = scanner.nextInt();
			pw.println(nb1);
			//Envoie du deuxieme entier
			System.out.println("Tapez le deuxieme entier");
			int nb2 = scanner.nextInt();
			pw.println(nb2);
			//Envoie du type d'operation
			String op;
			do {
				System.out.println("Choix d'operation:");
				op = scanner.nextLine();
			} while (!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*"))&& !(op.equals("/")));
			pw.println(op);
			//Reçeption du résultat
			String s = br.readLine();
			int result = Integer.parseInt(s);
			//Afficahge du résultat
			System.out.println(nb1+" "+op+" "+nb2+"= "+result);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
