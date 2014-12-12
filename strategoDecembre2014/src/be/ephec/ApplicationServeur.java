package be.ephec;

import java.awt.EventQueue;

import be.ephec.interfaceGraphique.JFrameServeur;
import be.ephec.socketTPC.reseau.MonServeurTCP;

/**
 * @author mnv
 *
 */
public class ApplicationServeur {
	private JFrameServeur jFrameServeur;
	private MonServeurTCP serveur;

	/**
	 * 
	 */
	public ApplicationServeur(){
		jFrameServeur = new JFrameServeur(this);
		jFrameServeur.setVisible(true);
	}

	/**
	 * @return
	 */
	public JFrameServeur getjFrameServeur() {
		return jFrameServeur;
	}

	/**
	 * @param jFrameServeur
	 */
	public void setjFrameServeur(JFrameServeur jFrameServeur) {
		this.jFrameServeur = jFrameServeur;
	}

	/**
	 * @return
	 */
	public MonServeurTCP getServeur() {
		return serveur;
	}

	/**
	 * @param serveur
	 */
	public void setServeur(MonServeurTCP serveur) {
		this.serveur = serveur;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationServeur applicationServeur = new ApplicationServeur();

	}

}


