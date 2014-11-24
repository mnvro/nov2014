package be.ephec.stratego;

public class Deplacement {
	private int ligneOrigine;
	private int colonneOrigine;
	private int lineDestination;
	private int colonneDestiantion;

	public static void bouge(Stratego jeu, int ligneSource, int colonneSource, int ligneDestination, int colonneDestination) {

		Piece source,destination;


		if (jeu.getEtatDuJeu()==Parametres.MOMENT_JEU_PLACER_PIECES){
			if ((ligneSource >= 0 && ligneSource <= jeu.getBoiteRangement().getNbLignes()) &&
					(ligneDestination>= 0 && ligneDestination <= jeu.getPlateauDeJeu().getNbLignes() ) &&
					(colonneSource >= 0 && colonneSource <= jeu.getBoiteRangement().getNbColonnes()) &&
					(colonneDestination>= 0 && colonneDestination <= jeu.getPlateauDeJeu().getNbColonnes() )){
				
				source = jeu.getBoiteRangement().getMatrice()[ligneSource][colonneSource].getPiece();
				destination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();
				if (source != null && destination == null){
					jeu.getBoiteRangement().getMatrice()[ligneSource][colonneSource].setPiece(null);
					jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].setPiece(source);
				}
			}
		}

	}

}
