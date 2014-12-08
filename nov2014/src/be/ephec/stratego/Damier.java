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

	protected Case matrice[][] ;// on commence en haute à gauche,c'est d'abord la ligne puis la colonne

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
	 */
	public Damier(int nbLinges, int nbColonnes) {
		this.nbLignes = nbLinges;
		this.nbColonnes = nbColonnes;
		matrice = new Case[nbLignes][nbColonnes];
		int l,c;
		for (l=0;l<nbLinges;l++){
			for (c=0;c<nbColonnes;c++){
				matrice[l][c] = new Case(false,null, true,l,c);
			}
		}
		

	}

	/**
	 * @param decalage le nombre d'espaces que l'on veut ajouter avant l'affichage de chaque ligne
	 * @return si on a 10 colonnes cette fonction retourne
	 * 				"    0   1   2   3   4   5   6   7   8   9\n"+
				    "  ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐\n";
	 */
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
	}

	/**
	 * @param numLigne le numéro de la ligne
	 * @return
	 * si on a 10 colonnes, retourne " "+La lettre correspondant à la ligne+"│   │   │   │   │   │   │   │   │   │   │\n"
	   si c'est une ligne avec lac  retourne                                " E│   │   │▓▓▓│▓▓▓│   │   │▓▓▓│▓▓▓│   │   │\n"
	   On verra également les pièces placées sur cette ligne
	 */
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
	}

	/**
	 * @return "  ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\n" si on a 10 colonnes
	 */
	public String toStringSeparationNormale(){
		StringBuffer sb = new StringBuffer("  ├");
		for (int i=0;i<nbColonnes-1;i++){
			sb.append("───┼");
			
		}
		sb.append("───┤\n");
		return sb.toString();
	}

	/**
	 * @return "  └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘\n\n" si on a 10 colonnes
	 */
	public String toStringLaDerniereLigne(){
		StringBuffer sb = new StringBuffer("  └");
		for (int i=0;i<nbColonnes-1;i++){
			sb.append("───┴");
			
		}
		sb.append("───┘\n\n");
		return sb.toString();
	}

	/**
	 * @param decalage le nombre d'espaces ajoutés au début de chaque ligne
	 * @return  "    0   1   2   3   4   5   6   7   8   9\n"+
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
				"  └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘\n\n"
		si on a 10 lignes et 10 colonnes
		on verra également les pièces placées sur ce damier
	 */
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
