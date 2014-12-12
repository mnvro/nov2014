package be.ephec.interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import be.ephec.ApplicationClient;
import be.ephec.socketTPC.reseau.MonClientTCP;

public class JFrameClient extends JFrame {

	private JPanel contentPane;
	private ApplicationClient applicationClient;
	private  JTextArea jTextAreaObjetsRecus;

	private static int nbClient;



	public static int getNbClient() {
		return nbClient;
	}

	public static void setNbClient(int nbClient) {
		JFrameClient.nbClient = nbClient;
	}


	public JTextArea getjTextAreaObjetsRecus() {
		return jTextAreaObjetsRecus;
	}



	public void setjTextAreaObjetsRecus(JTextArea jTextAreaObjetsRecus) {
		this.jTextAreaObjetsRecus = jTextAreaObjetsRecus;
	}



	/**
	 * Create the frame.
	 */
	public JFrameClient(ApplicationClient applicationClient) {
		this.applicationClient = applicationClient;
		nbClient++;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0+getNbClient()*50, 400+nbClient*50, 708, 446);
		contentPane = new JPanelAccueilClient(applicationClient);
		setContentPane(contentPane);
	}

}
