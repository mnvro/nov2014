package be.ephec.interfaceGraphique;

public class ElementJcomboBox{
	private String message;
	private int numDansLeCombo;
	private int numClient;
	public ElementJcomboBox(String message, int numDansLeCombo,
			int numClient) {
		super();
		this.message = message;
		this.numDansLeCombo = numDansLeCombo;
		this.numClient = numClient;
	}
	public String toString(){
		return message;
	}
}