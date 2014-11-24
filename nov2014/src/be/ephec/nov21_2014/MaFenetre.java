package be.ephec.nov21_2014;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MaFenetre extends JFrame {

	public MaFenetre(){
		this.setVisible(true);
		this.setBounds(5, 50, 600, 100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaFenetre maFenetre = new MaFenetre();
	}

}
