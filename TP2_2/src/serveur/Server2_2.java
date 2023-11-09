package serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import operation.Operation;

public class Server2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			// Réservation du port et acceptation de connexion
			System.out.println("Je suis un serveur en attente la connexion d'un client");		
			ServerSocket serverSocket = new ServerSocket(107);
			Socket socket = serverSocket.accept();
			
			System.out.println("Client connecté");
			
			// Utlisation du ObjectInputStream pour pouvoir lire l'objet reçus du client
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// Conversion du type Object vers Operation
			Operation op =(Operation) ois.readObject();
			
			// Traitement / Service
			int nb1 =op.getOp1();
			int nb2=op.getOp2();
			int resultat=0;
			switch(op.getOperation()) {
			case '+':
				resultat = nb1+nb2;
				break;
			case '-':
				resultat =  nb1-nb2;
				break;
			case '*':
				resultat =  nb1*nb2;
				break;
			case '/':
				resultat =  nb1/nb2;
				break;
			}
		
			op.setResultat(resultat);
			
			// Le renvoi du même objet vers le client après modification de la propriétés 'Resultat'
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(op);
			
			// Libération des ressources
			serverSocket.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
