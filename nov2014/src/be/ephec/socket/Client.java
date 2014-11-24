package be.ephec.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.UnknownHostException;

public class Client extends Socket implements Runnable {
	private Object objetRecu; // mettez ici ce qui a du sens pour votre projet, ça peut être une arraylist d'objets si vous devez les "retenir"

	public Client() throws UnknownHostException, IOException {
		super("127.0.0.1",8981);
	}

	public static void main(String args[]){
		try {
			Client client = new Client();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {

			ObjectInputStream ois = new ObjectInputStream(this.getInputStream());
			while (this.isConnected()){

				objetRecu = ois.readObject();
				System.out.println("J'ai reçu "+objetRecu);
			} 
		}catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}

	}

}
