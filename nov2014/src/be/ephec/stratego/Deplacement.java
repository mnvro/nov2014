package be.ephec.stratego;

import java.sql.Array;
import java.util.ArrayList;

/**
 * @author mnv
 * Il s'agit d'une classe utilitaire (elle contient donc principalement des �l�ments statics)
 * g�re tout ce qui est d�placement
 *
 */
public class Deplacement {

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
	
	public static boolean aDesDestinationsPossibles(Stratego jeu, int ligneSource, int colonneSource){
		ArrayList<Case> listeCases = trouveToutesLesDestinationsPossibles(jeu,ligneSource,colonneSource);
		return (listeCases.size() != 0);
	}

	public static ArrayList<Case> trouveToutesLesDestinationsPossibles(Stratego jeu, int ligneSource, int colonneSource){
		Piece pieceSource,pieceDestination;
		int ligneDestination, colonneDestination;
		ArrayList<Case> listeCases = new ArrayList<Case>();
		if (jeu.getEtatDuJeu()==Parametres.MOMENT_JEU_JOUER){
			pieceSource = jeu.getPlateauDeJeu().getMatrice()[ligneSource][colonneSource].getPiece();
			switch (pieceSource.getVal()){
			case Parametres.BOMBE :
			case Parametres.DRAPEAU : break; // on ne peut rien faire
			case Parametres.ECLAIREUR : 
				// on va ajouter � la liste des d�placements possibles toutes les cases libres � gauche
				colonneDestination = colonneSource-1;
				ligneDestination = ligneSource; // on reste sur la m�me ligne
				while (colonneDestination>=0){ // tant qu'il y a des cases � gauche
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
						break;// on ne peut pas aller plus loin
					}	
					colonneDestination--; // on se d�cale d'une case � gauche
				} 

				// on va ajouter � la liste des d�placements possibles toutes les cases libres � droite
				colonneDestination = colonneSource+1;
				ligneDestination = ligneSource; // on reste sur la m�me ligne
				while (colonneDestination<Parametres.NBLIGNES){ // tant qu'il y a des cases � droite
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
						break;// on ne peut pas aller plus loin
					}	
					colonneDestination++; // on se d�cale d'une case � droite
				} 

				// on va ajouter � la liste des d�placements possibles toutes les cases libres en-dessous
				colonneDestination = colonneSource;
				ligneDestination = ligneSource+1; // on descend d'une ligne
				while (ligneDestination<Parametres.NBCOLONNES){ // tant qu'il y a des cases � gauche
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
						break;// on ne peut pas aller plus loin
					}	
					colonneDestination++; // on se d�cale d'une case en-dessous
				} 

				// on va ajouter � la liste des d�placements possibles toutes les cases libres au-dessus
				colonneDestination = colonneSource;
				ligneDestination = ligneSource-1; // on descend d'une ligne
				while (ligneDestination>=0){ // tant qu'il y a des cases � gauche
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
						break;// on ne peut pas aller plus loin
					}	
					colonneDestination--; // on se d�cale d'une case au-dessus
				} 					
				break;
			default : // dans tous les autres cas, donc on n'a ni une bombe, ni un drapeau, ni un �claireur
				
				// si la case � gauche est libre
				colonneDestination = colonneSource-1;
				ligneDestination = ligneSource; // on reste sur la m�me ligne
				if (colonneDestination<Parametres.NBLIGNES){ // tant qu'il y a des cases � droite
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
					}	
				}
				// si la case � droite est libre
				colonneDestination = colonneSource+1;
				ligneDestination = ligneSource; // on reste sur la m�me ligne
				if (colonneDestination<Parametres.NBLIGNES){ // tant qu'il y a des cases � droite
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
					}	
				} 
				
				// si la case en-dessous est libre
				colonneDestination = colonneSource;
				ligneDestination = ligneSource+1; // on descend d'une ligne
				if (ligneDestination<Parametres.NBCOLONNES){ // tant qu'il y a des cases � gauche
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
					}	
				} 
				// si la case au-dessus est libre
				colonneDestination = colonneSource;
				ligneDestination = ligneSource-1; // on descend d'une ligne
				while (ligneDestination>=0){ // tant qu'il y a des cases � gauche
					pieceDestination = jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination].getPiece();// c'est la pi�ce qui se trouve sur cette case
					if 	(pieceDestination == null) listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]);// dans ce cas la case est libre, allons-y
					else if (pieceDestination.getCouleur() != pieceSource.getCouleur()){
						listeCases.add(jeu.getPlateauDeJeu().getMatrice()[ligneDestination][colonneDestination]); // dans ce cas la case est occup�e par l'adversaire ce sera un combat
					}	
				} 					


			}
		}
		// sinon �a n'a pas de sens d'utiliser cette m�thode
		return listeCases;
	}

}
