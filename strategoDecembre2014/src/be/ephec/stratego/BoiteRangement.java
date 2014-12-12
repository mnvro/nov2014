package be.ephec.stratego;

public class BoiteRangement extends Damier {

	public BoiteRangement(int nbLignes, int nbColonnes) {
		super(nbLignes, nbColonnes);
		// TODO Auto-generated constructor stub
		Piece ensemblePieces[] = Parametres.tableauInitialAvecToutesLesPiecesDunJoueur.clone();


		for (int l=0;l<nbLignes;l++){
			for (int c=0;c<nbColonnes;c++){
				matrice[l][c] = new Case(false,ensemblePieces[l*10+c], false,l,c);
			}
		}
	}

}
