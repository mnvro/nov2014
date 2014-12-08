package be.ephec.stratego;

public class Piece {
	private int val;
	private int couleur;
	//private String nom;

	public Piece() {
		// TODO Auto-generated constructor stub
	}

	public Piece(int val) {
		super();
		this.val = val;
	}

	/*public boolean estDeplacable(){
		case 
	}*/
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		if (val == Parametres.GENERAL) return "G";
		if (val == Parametres.MARECHAL) return "M";
		if (val == Parametres.BOMBE) return "B";
		if (val == Parametres.ESPION) return "S";
		if (val == Parametres.DEMINEUR) return "D";
		if (val == 0) return "░";
		return val+"";
	}

	public static String affcheResultCombat(int valCombat){
		switch (valCombat){
		case 0 :  
			return "Personne ne gagne";
		case 1 : 
			return "Vous gagnez le combat";
		case 2 : 
			return "Vous perdez le combat";
		case -1:
			return "Vous avez trouvé le drapeau";
		case -2 : 
			return "On en devrait pas passer ici";

		}
		return "toto";
	}


	/**
	 * @param autrePiece
	 * @return -1 on a trouvé le drapeau, 1 l'attaquant gagne, 2 l'attaqué gagne, 0 match nule tout le monde a perdu
	 */
	public int combat (Piece autrePiece){
		if (this.val == autrePiece.val ){
			return 0;	
		}
		if ((this.val >= 3) && (autrePiece.val >= 3)){// c'est un combat normal
			if (this.val > autrePiece.val)
				return 1;
			else return 2;
		}
		if ((this.val == Parametres.ESPION) && (autrePiece.val == Parametres.MARECHAL)){
			return 1;
		}
		if ((this.val == Parametres.ESPION)){
			return 2;
		}
		if ((this.val == Parametres.DEMINEUR) && (autrePiece.val == Parametres.BOMBE)){
			return 1;
		}
		if (autrePiece.val == Parametres.BOMBE){
			return 2;
		}
		if (autrePiece.val == Parametres.DRAPEAU){
			//Stratego.setGagne(true);
			System.out.println("on a gagné");
			return -1;
		}
		// Je ne traite pas le drapeau ou la bombe qui attaque, puisque ce n'est pas possible
		System.out.println("Normalement on ne passe pas ici");
		return -2;

	}
	public static void main(String args[]) throws InterruptedException{
		
	}
}
