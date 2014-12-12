package mesTests;



import javax.swing.JFrame;
import java.awt.Toolkit;

public class MaFenetre extends JFrame {
	public MaFenetre (){
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/StrategoIcon.jpg")); // permet de mettre une image dans la barre de titre
		
		//getContentPane().set
		this.setBounds(100, 200, 256, 256);
		//this.setSize(400, 600);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		MaFenetre mf = new MaFenetre();

	}

}
