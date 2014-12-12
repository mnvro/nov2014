package be.ephec;

import be.ephec.interfaceGraphique.JFrameClient;
import be.ephec.socketTPC.reseau.MonClientTCP;

public class ApplicationClient {
	private MonClientTCP client;
	private JFrameClient jFrameClient;
	
	public ApplicationClient(){
		jFrameClient = new JFrameClient(this);
		jFrameClient.setVisible(true);
	}
	
	public void alerteNouveauMessage(Object o){
		String s = (String) o;
		jFrameClient.getjTextAreaObjetsRecus().setText("On a reçu "+s+" du serveur");
	}

	public MonClientTCP getClient() {
		return client;
	}


	public void setClient(MonClientTCP client) {
		this.client = client;
	}


	public JFrameClient getjFrameClient() {
		return jFrameClient;
	}


	public void setjFrameClient(JFrameClient jFrameClient) {
		this.jFrameClient = jFrameClient;
	}


	public static void main(String[] args) {
		ApplicationClient client = new ApplicationClient();

	}

}
