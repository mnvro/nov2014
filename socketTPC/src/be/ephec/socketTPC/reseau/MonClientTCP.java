package be.ephec.socketTPC.reseau;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import be.ephec.ApplicationClient;
import be.ephec.Param;

public class MonClientTCP extends Socket implements Runnable {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Object objetRecu;
	private ApplicationClient applicationClient;
	private static int nbClient;
	

	public static int getNbClient() {
		return nbClient;
	}

	public static void setNbClient(int nbClient) {
		MonClientTCP.nbClient = nbClient;
	}

	public void ecrireMessage(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MonClientTCP(ApplicationClient applicationClient) throws UnknownHostException, IOException{
		super ("127.0.0.1",Param.NUMPORT);
		this.applicationClient = applicationClient;
		try {
			oos = new ObjectOutputStream(this.getOutputStream());	// il faut croiser par rapport au serveur
			ois = new ObjectInputStream(this.getInputStream());
			(new Thread(this)).start();
			nbClient++;
			applicationClient.getjFrameClient().setTitle("Client numéro :"+(nbClient-1));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void run() {
		while (this.isConnected()){
			try {
				objetRecu = ois.readObject();
				//System.out.println("J'ai reçu un objet et je l'ajouter au JTextArea");
				applicationClient.getjFrameClient().getjTextAreaObjetsRecus().append("\n"+objetRecu.toString());
				applicationClient.getjFrameClient().getjTextAreaObjetsRecus().setCaretPosition(applicationClient.getjFrameClient().getjTextAreaObjetsRecus().getText().length());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					this.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
