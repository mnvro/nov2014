package be.ephec.interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import be.ephec.ApplicationClient;
import be.ephec.Param;
import be.ephec.socketTPC.reseau.MonClientTCP;

public class JFrameClient extends JFrame {
    private static int nbJFrame = 0;
	private JPanel contentPane;
	private ApplicationClient applicationClient;
	private  JTextArea jTextAreaObjetsRecus;
	private int largeur = Param.LARGEURJFCLIENT;
	private int hauteur = Param.HAUTEURJFCLIENT;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Param.LARGEURJFSERVEUR+ nbJFrame/3*largeur,nbJFrame%3*hauteur , largeur, hauteur); // colonne puis ligne
		contentPane = new JPanelAccueilClient(applicationClient);
		setContentPane(contentPane);
		nbJFrame++;
	}

}
