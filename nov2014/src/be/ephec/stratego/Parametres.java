package be.ephec.stratego;

/**
 * @author mnv
 * Contient tous les paramètres mais aussi tout ce qui est utile et pas vraiment OO
 *
 */

/*
 * le maréchal (10), 1 en jeu
le général (9), 1 en jeu
les colonels (8), 2 en jeu
les commandants (7), 3 en jeu
les capitaines (6), 4 en jeu
les lieutenants (5), 4 en jeu
les sergents (4), 4 en jeu
les démineurs (3), 5 en jeu
les éclaireurs (2), 8 en jeu
l'espion (1), 1 en jeu
À ces pièces mobiles s'ajoutent les six bombes et le drapeau, indéplaçables.
 */
public class Parametres {
	public final static  int DRAPEAU  = 0; 		// 1 il en existe 1 seul
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
	
	public final static int MOMENT_JEU_PLACER_PIECES = 0;
	public final static int MOMENT_JEU_ATTENDRE_ADVERSAIRE = 1;
	public final static int MOMENT_JEU_JOUER = 2;
	public final static int MOMENT_JEU_FINI = 3;
	
	public final static Piece tableauInitialAvecToutesLesPiecesDunJoueur[] = new Piece [40];
	

	private final static int nbTypePieces = 12;
	public final static int tabNbPieces[] = {1,6,1,8,5,4,4,4,3,2,1,1};
	public static String nomPiece[] = {
		"drapeau = ░", "bombe = B", "espion = S", "éclaireur", "démineur = D", "sergent",
		"lieutenant", "capitaine", "commandant", "colonel", "gérénal = G",
		"maréchal = M"
	};

	public static Piece tabTypePiece[] = new Piece[nbTypePieces];
	
	public final static String couleurs[] = {
		"rouge","bleu"
	};

	static  {
		for (int i=0;i<nbTypePieces;i++){
			tabTypePiece[i] = new Piece(i);
		}
		int compteur = 0 ;
		for (int i=0;i<nbTypePieces;i++){
			for (int j = 0;j<tabNbPieces[i];j++){
				tableauInitialAvecToutesLesPiecesDunJoueur[compteur] = new Piece(i);
				compteur++;
			}
		}
		
	}

	public Parametres() {
		// TODO Auto-generated constructor stub
	}
	
	public static  void afficheLegende(){
		for (int i=0;i<nbTypePieces;i++){
			System.out.println(tabTypePiece[i].getVal()+" = "+nomPiece[i]);
		}
		
	}

}
