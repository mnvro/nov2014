package be.ephec.stratego;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public Fenetre(){
		this.setTitle("Toto");
		this.setVisible(true);
		this.setSize(500, 200);
		this.setBounds(50,80,60,100);
	}

	

	public static void main(String[] args) {
		Fenetre fen = new Fenetre();

	}

}
