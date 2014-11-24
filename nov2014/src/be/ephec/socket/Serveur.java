package be.ephec.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur extends ServerSocket implements Runnable {
	class SocketCoteServeur extends Socket implements Runnable{
		public SocketCoteServeur() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			try {
				ObjectInputStream ois = new ObjectInputStream(this.getInputStream());

				while (this.isConnected()){
					

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	private int numPort;
	private int nbClients;
	ArrayList<Socket> listeClients = new ArrayList<Socket>();

	public Serveur(int numPort) throws IOException {
		super(numPort);
		this.numPort = numPort;
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true){ // à remplacer par tant que le jeu fonctionne, tant qu'on n'arrête pas le serveur...
			try {
				listeClients.add(this.accept());
				nbClients++;
				Thread.sleep(100);
				System.out.println("On a "+nbClients+" clients");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String args[]){
		try {
			Serveur monServeur = new Serveur(8981);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
