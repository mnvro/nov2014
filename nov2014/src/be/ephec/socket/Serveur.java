package be.ephec.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur extends ServerSocket implements Runnable {
	private int numPort;
	private int nbClients;
	ArrayList<SocketCoteServeur> listeClients = new ArrayList<SocketCoteServeur>();
	private ApplicationServeur as;



	class SocketCoteServeur implements Runnable{
		private Socket socket;
		private ObjectOutputStream oos;
		private ObjectInputStream ois;
		private int id;
		private Object objetRecu;

		public SocketCoteServeur(Socket socket, int id) {
			this.socket = socket;
			this.id = id;
			System.out.println("socket = "+socket);
			try {
				oos = new ObjectOutputStream(this.socket.getOutputStream()); // deux lignes de code à croiser entre client et serveur
				ois = new ObjectInputStream(this.socket.getInputStream());   // car elles sont bloquantes.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread t =new Thread(this);
			t.start();
		}

		@Override
		public void run() {
			try {


				while (this.socket.isConnected()){
					objetRecu = ois.readObject();
					as.getJfs().getPannelPourRecevoirClient().
					getTextPaneObjetRecu().setText(
							as.getJfs().getPannelPourRecevoirClient().getTextPaneObjetRecu().getText()+"\n"+objetRecu
					);
					as.getJfs().getPannelPourRecevoirClient().
					getTextPaneObjetRecu().setCaretPosition(as.getJfs().getPannelPourRecevoirClient().getTextPaneObjetRecu().getText().length());
					Thread.sleep(10);

				}
			} catch (IOException | ClassNotFoundException | InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Le client "+(id+1)+" s'est déconnecté");
			}

		}
		public void ecrire(Object o){

			try {

				oos.writeObject(o);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("On a perdu la connexion");
			}

		}
		public boolean estConnecte(){
			return (this.socket.isConnected() && socket.isBound() && ! socket.isClosed() &&
					oos !=null); // je sais pas lequel est le bon, je prends tout
		}

	}


	public Serveur(int numPort, ApplicationServeur as) throws IOException {
		super(numPort);
		this.as = as;
		this.numPort = numPort;
		Thread thread = new Thread(this);
		thread.start();
	}



	@Override
	public void run() {
		while (this.isBound()){ // à remplacer par tant que le jeu fonctionne, tant qu'on n'arrête pas le serveur...
			try {
				SocketCoteServeur scs = new SocketCoteServeur(this.accept(),nbClients);
				listeClients.add(scs);


				nbClients++;
				Thread.sleep(10);
				System.out.println("On a "+nbClients+" clients");
				//scs.oos = new ObjectOutputStream(scs.socket.getOutputStream());

			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String args[]){
		try {
			Serveur monServeur = new Serveur(Param.NUMPORT,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
