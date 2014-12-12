package be.ephec.stratego;

/**
 * @author mnv
 * Cette classe représente une case qui peut être sur le plateu de jeu ou bien dans une des boîtes de rangement
 *
 */
public class Case {

	private boolean estUnLac = false;
	private boolean estOccupeeParAdversaire = false;
	private Piece piece = null;
	private int ligne;
	private int colonne;
	
	

	/**
	 * @return
	 */
	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public boolean estOccupee(){
		return (piece!=null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Utilisée pour la version DOS principalement
	 */
	public String toString(){
		if (estOccupeeParAdversaire) return (" x ");
		if (estUnLac) return "▓▓▓";
		if (piece == null) return "   ";
		return" "+piece.toString()+" ";
	}

	/**
	 * Constructeur pour créer une case
	 * @param estUnLac vrai s'il s'agit d'un lac
	 * @param piece la pièce qui occupe cette case
	 * @param estOccupeeParAdversaire vrai si la case est occupée par un pion de l'adversaire, faux si la case est libre ou occupée par un pion du joueur
	 */
	public Case(boolean estUnLac, Piece piece, boolean estOccupeeParAdversaire,int ligne, int colonne) {
		super();
		this.estUnLac = estUnLac;
		this.piece = piece;
		this.estOccupeeParAdversaire = estOccupeeParAdversaire;
		this.ligne = ligne;
		this.colonne = colonne;
	}


	public boolean isEstUnLac() {
		return estUnLac;
	}


	public void setEstUnLac(boolean estUnLac) {
		this.estUnLac = estUnLac;
	}



	public Piece getPiece() {
		return piece;
	}


	public void setPiece(Piece piece) {
		this.piece = piece;
	}


}
