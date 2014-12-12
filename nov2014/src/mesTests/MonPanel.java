package mesTests;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * 
 * @author Nicolas Perivolaris (3TI 2014-2014)
 *
 */
public class MonPanel extends JPanel {
	
	private static final long serialVersionUID = 7203738621706153450L;
	private BufferedImage background;
	
	public MonPanel() {
		setOpaque(false); //le background devient transparent
		background = getImage("images/image.jpg"); //chargement de l'image
		Dimension d = new Dimension(background.getWidth(), background.getHeight()); //récupération des dimensions de l'image
		setPreferredSize(d); // resize la taille du panel à la taille de l'image
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//methode appelée automatiquement par java lors du rendering du JPanel
		g.drawImage(background, 0, 0, this); 
		super.paintComponent(g); 
	}
	
	/**
	 * Chargement de l'image à partir du disque
	 * @param path le chemin vers l'image
	 * @return l'image si elle est trouvée sur le disque, null sinon
	 */
	private BufferedImage getImage(String path){
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new MonPanel(), BorderLayout.CENTER);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
	}

}
