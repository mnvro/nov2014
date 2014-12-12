package be.ephec.stratego;

import be.ephec.application.StrategoVersionDOS;

public class Triche {
	/*
	 * public final static  int DRAPEAU  = 0; 		// 1
	public final static  int BOMBE  = 1; 		// 6
	public final static  int ESPION  = 2; 		// 1
	public final static  int ECLAIREUR  = 3; 	// 8
	public final static  int DEMINEUR  = 4; 	// 5
	public final static  int SERGENT  = 5; 		// 4
	public final static  int LIEUTENANT  = 6; 	// 4
	public final static  int CAPITAINE  = 7; 	// 4
	public final static  int COMMANDANTS  = 8; 	// 3
	public final static  int COLONEL  = 9; 		// 2
	public final static  int GENERAL  = 10; 	// 1
	public final static  int MARECHAL  = 11; 	// Il en existe 1 seul
	
	 */

	/**
	 * Cette classe permet de tester plus rapidement
	 * Elle permet de placer toutes les pièces sur le plateau de jeu d'un coup
	 * @param option 0, 1 ou 2 pour 3 versions différentes proposées - 0 on place les pièces comme dans la boîte de rangement, 1 c'est un peu mieux, 2 c'est le mieux pour tester
	 */
	public static void placeTout(StrategoVersionDOS jeu, int option) {
		for (int l=0;l<jeu.getBoiteRangement().getNbLignes();l++){

			for (int c=0;c<jeu.getBoiteRangement().getNbColonnes();c++){
				jeu.getBoiteRangement().matrice[l][c].setPiece(null);// on vide toute la boîte de rangement
			}
		}
		
		
		
		
		switch (option){
		case 0 : {
			int tabPieces[][] = {
					{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
					{10,11,12,13,14,15,16,17,18,19},
					{20,21,22,23,24,25,26,27,28,29},
					{30,31,32,33,34,35,36,37,38,39}
			};
			/*jeu.getPlateauDeJeu().matrice[6][0].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[0]); // drapeau  	// 1 -
			jeu.getPlateauDeJeu().matrice[6][1].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[1]); // bombe  		// 6
			jeu.getPlateauDeJeu().matrice[6][2].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[2]); // bombe
			jeu.getPlateauDeJeu().matrice[6][3].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[3]); // bombe
			jeu.getPlateauDeJeu().matrice[6][4].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[4]); // bombe
			jeu.getPlateauDeJeu().matrice[6][5].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[5]); // bombe
			jeu.getPlateauDeJeu().matrice[6][6].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[6]); // bombe
			jeu.getPlateauDeJeu().matrice[6][7].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[7]); // espion		// 1
			jeu.getPlateauDeJeu().matrice[6][8].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[8]); // éclaireur	// 8
			jeu.getPlateauDeJeu().matrice[6][9].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[9]); // éclaireur

			jeu.getPlateauDeJeu().matrice[7][0].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[10]); // éclaireur
			jeu.getPlateauDeJeu().matrice[7][1].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[11]); // éclaireur
			jeu.getPlateauDeJeu().matrice[7][2].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[12]); // éclaireur
			jeu.getPlateauDeJeu().matrice[7][3].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[13]); // éclaireur
			jeu.getPlateauDeJeu().matrice[7][4].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[14]); // éclaireur
			jeu.getPlateauDeJeu().matrice[7][5].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[15]); // éclaireur
			jeu.getPlateauDeJeu().matrice[7][6].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[16]); // démineur	// 5
			jeu.getPlateauDeJeu().matrice[7][7].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[17]); // démineur
			jeu.getPlateauDeJeu().matrice[7][8].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[18]); // démineur
			jeu.getPlateauDeJeu().matrice[7][9].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[19]); // démineur

			jeu.getPlateauDeJeu().matrice[8][0].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[20]); // démineur
			jeu.getPlateauDeJeu().matrice[8][1].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[21]); // sergent 	// 4
			jeu.getPlateauDeJeu().matrice[8][2].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[22]); // sergent
			jeu.getPlateauDeJeu().matrice[8][3].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[23]); // sergent
			jeu.getPlateauDeJeu().matrice[8][4].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[24]); // sergent
			jeu.getPlateauDeJeu().matrice[8][5].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[25]); // lieutenant	// 4
			jeu.getPlateauDeJeu().matrice[8][6].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[26]); // lieutenant
			jeu.getPlateauDeJeu().matrice[8][7].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[27]); // lieutenant
			jeu.getPlateauDeJeu().matrice[8][8].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[28]); // lieutenant
			jeu.getPlateauDeJeu().matrice[8][9].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[29]); // capitaine	// 4

			jeu.getPlateauDeJeu().matrice[9][0].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[30]); // capitaine
			jeu.getPlateauDeJeu().matrice[9][1].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[31]); // capitaine
			jeu.getPlateauDeJeu().matrice[9][2].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[32]); // capitaine
			jeu.getPlateauDeJeu().matrice[9][3].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[33]); // commandant	// 3
			jeu.getPlateauDeJeu().matrice[9][4].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[34]); // commandant
			jeu.getPlateauDeJeu().matrice[9][5].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[35]); // commandant
			jeu.getPlateauDeJeu().matrice[9][6].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[36]); // colonel		//2
			jeu.getPlateauDeJeu().matrice[9][7].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[37]); // colonel
			jeu.getPlateauDeJeu().matrice[9][8].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[38]); // général		//1
			jeu.getPlateauDeJeu().matrice[9][9].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[39]); //maréchal		//1*/
			
			for (int l = 0;l<4;l++){
				for (int c = 0;c<10;c++){
					jeu.getPlateauDeJeu().matrice[6+l][c].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[tabPieces[l][c]]);
					//System.out.println("Je place en ["+l+"]["+c+"] : "+Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[tabPieces[l][c]]);
				}
			}
			
			break;
			
		}
		case 1 : {
			int tabPieces[][] = {
					{30,31,32,33,34,35,36,37,38,39},
					{20,21,22,23,24,25,26,27,28,29},
					{19,18,17,16,15,14,13,12,11,10},
					{9 ,8 ,7 ,6 ,5 ,4 ,3 ,2 ,1 ,0 }
			};
			
			for (int l = 0;l<4;l++){
				for (int c = 0;c<10;c++){
					jeu.getPlateauDeJeu().matrice[6+l][c].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[tabPieces[l][c]]);
					//System.out.println("Je place en ["+l+"]["+c+"] : "+Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[tabPieces[l][c]]);
				}
			}
			
			break;
		}
		case 2 : {
			int tabPieces[][] = {
					{8 ,30,34,36,9 ,37,38,32,10,1 }, // éclaireur, capitaine, commandant, colonel, éclaireur, colonel, général, capitaine, éclaireur, bombe
					{18,25,14,31,35,27,15,26,2 ,23},
					{11,29,33,12,39,19,13,3 ,22,6 },
					{28,16,24,20,7 ,17,4 ,21,5 ,0 }
			};
			for (int l = 0;l<4;l++){
				for (int c = 0;c<10;c++){
					jeu.getPlateauDeJeu().matrice[6+l][c].setPiece(Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[tabPieces[l][c]]);
					//System.out.println("Je place en ["+l+"]["+c+"] : "+Parametres.tableauInitialAvecToutesLesPiecesDunJoueur[tabPieces[l][c]]);
				}
			}
			
			
			break;
		}

		}


	}

}
