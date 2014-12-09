package be.ephec.interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import be.ephec.ApplicationServeur;

public class JFrameServeur extends JFrame {

	private JPanel contentPane;
	private ApplicationServeur applicationServeur;
	private JComboBox comboBox;
	private JTextArea txtrMessagesReus;

	private ArrayList<Integer> listeNumClient = new ArrayList<Integer>();

	public ArrayList<Integer> getListeNumClient() {
		return listeNumClient;
	}

	public void setListeNumClient(ArrayList<Integer> listeNumClient) {
		this.listeNumClient = listeNumClient;
	}

	public JTextArea getTxtrMessagesReus() {
		return txtrMessagesReus;
	}

	public void setTxtrMessagesReus(JTextArea txtrMessagesReus) {
		this.txtrMessagesReus = txtrMessagesReus;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JFrameServeur(ApplicationServeur applicationServeur) {
		this.applicationServeur = applicationServeur;
		listeNumClient.add(-1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 562, 359);
		this.setVisible(true);
		this.setTitle("Serveur");
		contentPane = new JPanelAccueilServeur(applicationServeur);	
		setContentPane(contentPane);
	}

}
