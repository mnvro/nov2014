package be.ephec.stratego;

/**
 * @author mnv
 * Ca peut être la boît où les pièces sont rangées
 * ou bien le plateau de jeu
 *
 */
// todo faire deux classes différentes qui héritent de Damier
public class Damier {
	private int nbLignes;
	private int nbColonnes;

	protected Case matrice[][] ;// on commence en haute à gauche
	
	//private Piece ensemblePieces[] = Parametres.tableauInitialAvecToutesLesPiecesDunJoueur.clone(); // todo ça ne doit pas être ici

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	public Case[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(Case[][] matrice) {
		this.matrice = matrice;
	}

	

	/**
	 * @param nbLinges
	 * @param nbColonnes
	 * @param type 0 plateau de jeu - 1 boîte avec les pièces perdues ou par encore rangées
	 */
	public Damier(int nbLinges, int nbColonnes) {
		this.nbLignes = nbLinges;
		this.nbColonnes = nbColonnes;
		matrice = new Case[nbLignes][nbColonnes];
		int l,c;
		for (l=0;l<nbLinges;l++){
			for (c=0;c<nbColonnes;c++){
				matrice[l][c] = new Case(false,null, true);
			}
		}
		

	}

	public String toStringDeuxPremieresLignes(int decalage){
		String sDecal="";
		for (int i=0;i<decalage;i++){
			sDecal = sDecal+" ";
		}
		StringBuffer s = new StringBuffer("    ");
		for (int i = 0;i<nbColonnes;i++){
			s.append(i+"   ");
		}
		s.append("\n"+sDecal);
		s.append("  ┌");
		for (int i = 0;i<nbColonnes-1;i++){
			s.append("───┬");
		}
		s.append("───┐\n");
		return s.toString();
		/*return 	"    0   1   2   3   4   5   6   7   8   9\n"+sDecal+
				    "  ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐\n";*/
	}

	public String toStringLigneNormale(int numLigne){
		String s = " "+(char)(65+numLigne);
		StringBuffer sb = new StringBuffer(s);
		sb.append("│");
		for (int i=0;i<nbColonnes;i++){
			sb.append(matrice[numLigne][i].toString()+"│");
		}
		sb.append("\n");
		s = sb.toString();
		return s;

		//return " "+(char)(65+numLigne)+"│   │   │   │   │   │   │   │   │   │   │\n";

		// si c'est une ligne avec lac : " E│   │   │▓▓▓│▓▓▓│   │   │▓▓▓│▓▓▓│   │   │\n"+
	}

	public String toStringSeparationNormale(){
		StringBuffer sb = new StringBuffer("  ├");
		for (int i=0;i<nbColonnes-1;i++){
			sb.append("───┼");
			
		}
		sb.append("───┤\n");
		return sb.toString();
		//return "  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"; // todo améliorer pour que ça s'adapte au nombre de colonnes
	}

	public String toStringLaDerniereLigne(){
		StringBuffer sb = new StringBuffer("  └");
		for (int i=0;i<nbColonnes-1;i++){
			sb.append("───┴");
			
		}
		sb.append("───┘\n\n");
		return sb.toString();
		//return "  └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘\n\n";
	}

	public String toString(int decalage){
		String sDecal="";
		for (int i=0;i<decalage;i++){
			sDecal = sDecal+" ";
		}
		StringBuffer sb = new StringBuffer(sDecal);
		sb.append(toStringDeuxPremieresLignes(decalage));
		for (int i=0;i<nbLignes-1;i++){
			sb.append(sDecal);
			sb.append(toStringLigneNormale(i));
			sb.append(sDecal);
			sb.append(toStringSeparationNormale());
		}
		sb.append(sDecal);
		sb.append(toStringLigneNormale(nbLignes-1));
		sb.append(sDecal);
		sb.append(toStringLaDerniereLigne());

		return 	sb.toString();


		/*
		 return "    0   1   2   3   4   5   6   7   8   9\n"+

				"  ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐\n"+
				" A│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" B│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" C│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" D│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" E│   │   │▓▓▓│▓▓▓│   │   │▓▓▓│▓▓▓│   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" F│   │   │▓▓▓│▓▓▓│   │   │▓▓▓│▓▓▓│   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" G│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" H│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" I│   │   │   │   │   │   │   │   │   │   │\n"+
				"  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n"+
				" J│   │   │   │   │   │   │   │   │   │   │\n"+
				"  └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘\n\n";*/
	}



	


}
