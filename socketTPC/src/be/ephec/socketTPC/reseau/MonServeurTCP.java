package be.ephec.socketTPC.reseau;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import be.ephec.ApplicationServeur;
import be.ephec.Param;
import be.ephec.interfaceGraphique.ElementJcomboBox;

public class MonServeurTCP extends ServerSocket implements Runnable {

	class SocketCoteServeur implements Runnable {
		private ApplicationServeur applicationServeur;
		private int numClient;
		private Socket socket;
		private Object objetRecu; // on pourrait faire une arrayList avec tous les objets reçus si nécessaire
		private ObjectInputStream ois; // c'est le flux dans lequel je pourrai lire	
		private ObjectOutputStream oos;
		private boolean connecte=true;

		public SocketCoteServeur(Socket socket,ApplicationServeur applicationServeur, int numClient) {
			this.applicationServeur=applicationServeur;
			this.socket = socket;
			this.numClient =numClient;
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread t = new Thread(this);
			t.start();
		}

		public void ecrire(Object o){
			try {
				if (this.connecte){
					oos.writeObject(o);
				}
				else{
					System.out.println("Ce client est déconnecté");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (!socket.isClosed()){
				try {
					objetRecu = ois.readObject();
					System.out.println("J'ai reçu un objet");
					applicationServeur.getjFrameServeur().getTxtrMessagesReus().append("\n"+objetRecu.toString());
					applicationServeur.getjFrameServeur().getTxtrMessagesReus().setCaretPosition(applicationServeur.getjFrameServeur().getTxtrMessagesReus().getText().length());

				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Le client "+ this.numClient+" s'est déconnecté");
					this.connecte = false;
					// TODO mettre à jour le Combobox pour supprimer le client ou indiquer qu'il n'est pas dispo
					//JComboBox<String> jComboBox = new JComboBox<String>();
					JComboBox<ElementJcomboBox> jComboBox = new JComboBox<ElementJcomboBox>();
					applicationServeur.getjFrameServeur().getListeNumClient().remove(this.numClient);
					jComboBox.addItem(new ElementJcomboBox("envoyer à tous les clients",0,-1));
					int i=0;
					for (SocketCoteServeur socketCoteServeur : listeClients) {
						//applicationServeur.getjFrameServeur().getComboBox().addItem(new ElementJcomboBox("envoyer à tous les clients",0,-1));
						jComboBox.addItem(new ElementJcomboBox(("envoyer au client numéro "+socketCoteServeur.numClient+""),i,numClient));
						i++;
					}
					applicationServeur.getjFrameServeur().getContentPane().remove(applicationServeur.getjFrameServeur().getComboBox());
					
					//applicationServeur.getjFrameServeur().getContentPane().add(jComboBox);
					applicationServeur.getjFrameServeur().setComboBox(new JComboBox<ElementJcomboBox>());
					//comboBox.setModel(new DefaultComboBoxModel(new String[] {"un", "deux", "trois"}));
					applicationServeur.getjFrameServeur().getComboBox().addItem(new ElementJcomboBox("envoyer à tous les clients",0,-1));
					GridBagConstraints gbc_comboBox = new GridBagConstraints();
					gbc_comboBox.insets = new Insets(0, 0, 5, 5);
					gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
					gbc_comboBox.gridx = 3;
					gbc_comboBox.gridy = 1;
					applicationServeur.getjFrameServeur().getContentPane().add(applicationServeur.getjFrameServeur().getComboBox(), gbc_comboBox);
					applicationServeur.getjFrameServeur().setVisible(true);

					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		}
	}

	private int numPort;
	private ArrayList<SocketCoteServeur> listeClients= new ArrayList<SocketCoteServeur>();
	public ArrayList<SocketCoteServeur> getListeClients() {
		return listeClients;
	}

	public void setListeClients(ArrayList<SocketCoteServeur> listeClients) {
		this.listeClients = listeClients;
	}

	private ApplicationServeur applicationServeur;

	public MonServeurTCP(ApplicationServeur applicationServeur) throws IOException {
		super(Param.NUMPORT);
		numPort = Param.NUMPORT;
		this.applicationServeur = applicationServeur;
		Thread thread = new Thread(this);
		thread.start();
	}	
	/**
	 * @param numClient -1 si on veut envoyer à tous et sinon le numéro du client à qui on veut envoyer
	 */
	public void ecrire(int numClient, Object o){
		if (numClient == -1){
			for (SocketCoteServeur socketCoteServeur : listeClients) {
				socketCoteServeur.ecrire(o);
			}
		}
		else{
			listeClients.get(numClient).ecrire(o);
		}
	}
	
	public static InetAddress[] trouveToutesLesIpsDuServeur(){
		InetAddress ia[]= null;
		try {
			ia = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
			/*for (InetAddress inetAddress : ia) {
				System.out.println(inetAddress.getHostAddress());
				}
			 */


		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ia;
	}

	@Override
	public void run() {

		try {
			while( !this.isClosed()){  
				this.listeClients.add(new SocketCoteServeur(this.accept(),applicationServeur,this.listeClients.size()-1 ));
				System.out.println("un nouveau client est connecté");
				String s = "Envoyer uniquement au client "+(this.listeClients.size()-1+"");
				applicationServeur.getjFrameServeur().getComboBox().addItem(new ElementJcomboBox(s,this.listeClients.size()-1,this.listeClients.size()-1));
				applicationServeur.getjFrameServeur().getListeNumClient().add(this.listeClients.size()-1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



