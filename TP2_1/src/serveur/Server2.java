package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			//Lancement du server
			ServerSocket socketServer;
			try {
				socketServer = new ServerSocket(104);
				System.out.println("Je suis un serveur en attente la connexion d'un client");
				
				//Acceptation du connexion
				Socket socket = socketServer.accept();
				System.out.println("un client est connecté");
				
				// Flux de comunication
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				// Flux de traitement
				PrintWriter pw = new PrintWriter(os,true);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				//Reçeption du premier entier
				String s = br.readLine();
				int e1 = Integer.parseInt(s);

				// Reçeption du deuxieme entier
				s = br.readLine();
				int e2 = Integer.parseInt(s);


				//Reception du type d'operation
				s = br.readLine();

				//Calculatrice
				int r=0;
				switch (s) {
				case "+":
					r = e1 + e2;
					break;
				case "-":
					r = e1 - e2;
					break;
				case "*":
					r = e1 * e2;
					break;
				case "/":
					r = e1 / e2;
					break;
					

				default:
					break;
				}
				//Envoie du résultat
				pw.println(r);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}
	}