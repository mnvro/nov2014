package be.ephec.stratego;

public class Case {

	private boolean estUnLac = false;
	private boolean estOccupeeParAdversaire = false;
	private Piece piece = null;

	public boolean estOccupee(){
		return (piece!=null);
	}

	public String toString(){
		if (estOccupeeParAdversaire) return (" x ");
		if (estUnLac) return "▓▓▓";
		if (piece == null) return "   ";
		return" "+piece.toString()+" ";
	}



	public Case(boolean estUnLac, Piece piece, boolean estOccupeeParAdversaire) {
		super();
		this.estUnLac = estUnLac;
		this.piece = piece;
		this.estOccupeeParAdversaire = estOccupeeParAdversaire;
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



	public Case() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
