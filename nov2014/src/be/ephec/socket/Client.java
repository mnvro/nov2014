package be.ephec.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.UnknownHostException;

public class Client extends Socket implements Runnable {
	private ApplicationClient ac;
	private int i = 0;
	private Object objetRecu; // mettez ici ce qui a du sens pour votre projet, ça peut être une arraylist d'objets si vous devez les "retenir"
	private int num;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	public Client(int num, ApplicationClient ac) throws UnknownHostException, IOException {
		super("127.0.0.1",Param.NUMPORT);
		this.ac = ac;
		this.num = num;
		ois = new ObjectInputStream(this.getInputStream()); // Il faut croiser ces deux lignes par % au serveur
		oos = new ObjectOutputStream(this.getOutputStream());
		
		Thread t = new Thread(this);
		t.start();
	}

	public static void main(String args[]){
		try {
			Client client = new Client(0,null);
			System.out.println("Ceci est la console du client ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {

			
			while (this.isConnected()){
				i++;
				objetRecu = ois.readObject();
				System.out.println("J'ai reçu "+i+" objets\n"+objetRecu+"\n");
				ac.getJfc().getTextAreaMessageRecu().setText(ac.getJfc().getTextAreaMessageRecu().getText()+"\n"+objetRecu);
				ac.getJfc().getTextAreaMessageRecu().setCaretPosition(ac.getJfc().getTextAreaMessageRecu().getText().length());
				Thread.sleep(10);
			} 
		}catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("On a perdu la connexion avec le serveur");

	}

	}

}
