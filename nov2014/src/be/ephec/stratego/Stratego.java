package be.ephec.stratego;

/**
 * @author Marie-Noël
 * 
 * Règles du jeu de Stratego
Il existe deux règles de jeu au Stratego : celle qui est la plus utilisée et la plus populaire : Stratego se joue à 2 joueurs (un joueur avec des pièces rouges, l'autre avec des pièces bleues) sur un plateau carré de 92 cases (10 cases de côté moins 2 lacs carrés de 4 cases chacun). Chaque joueur possède 40 pièces.

Les pièces représentent des unités militaires et ont deux faces. Une face ne peut être vue que par un seul joueur à la fois, l'autre ne voyant que la couleur de la pièce. Les pièces sont placées de telle façon que le joueur ne voit que le rang de ses propres pièces.

Au début de la partie, chaque joueur positionne ses pièces sur ses quatre premières lignes comme il veut. Cette pré-phase du jeu est stratégique et déterminante pour la suite de la partie.

Chaque joueur déplace une pièce d'une case par tour. Une attaque se produit quand le joueur déplace sa pièce sur une case déjà occupée par l'adversaire. Chaque joueur tourne alors sa pièce pour la dévoiler à l'adversaire. La pièce la plus forte reste en jeu, l'autre est éliminée ; en cas d'égalité, les deux sont éliminées.


Stratego

L'édition de 2006 par Jumbo
Voici les pièces classées de la plus forte à la plus faible :

le maréchal (10), 1 en jeu
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

Le but du jeu est de capturer le drapeau de l'adversaire ou d'éliminer assez de pièces adverses afin que l'adversaire ne puisse plus faire de déplacements.

Certaines pièces obéissent à des règles spéciales :

Si l'espion, grade le plus faible, attaque le maréchal, grade le plus élevé, l'espion gagne (si le maréchal attaque en premier, le maréchal gagne);
Toute pièce attaquant une bombe est éliminée, sauf le démineur qui élimine la bombe (Remarque : si une pièce autre qu'un démineur attaque une bombe, il périt, mais la bombe reste jusqu'à l'éventuelle attaque d'un démineur)
Lors d'une attaque ou non, l'éclaireur peut se déplacer d'autant de cases libres qu'il le souhaite, en ligne droite.
 *
 */
public class Stratego {

	private boolean gagne = false;
	
	private Damier plateauDeJeu = new Plateau(10,10);
	private Damier boiteRangement = new BoiteRangement(4,10);
	
	private int etatDuJeu = Parametres.MOMENT_JEU_PLACER_PIECES;

	public boolean isGagne() {
		return gagne;
	}
	public void setGagne(boolean gagne) {
		this.gagne = gagne;
	}


	



	public Damier getPlateauDeJeu() {
		return plateauDeJeu;
	}
	public void setPlateauDeJeu(Damier plateauDeJeu) {
		this.plateauDeJeu = plateauDeJeu;
	}
	public Damier getBoiteRangement() {
		return boiteRangement;
	}
	public void setBoiteRangement(Damier boiteRangement) {
		this.boiteRangement = boiteRangement;
	}
	public int getEtatDuJeu() {
		return etatDuJeu;
	}
	public void setEtatDuJeu(int etatDuJeu) {
		this.etatDuJeu = etatDuJeu;
	}
	public static void main(String arg[]){
		Stratego jeu = new Stratego();
		int nbPieceAPlacer = 40;
		int ligneOrigine;
		int colonneOrigine;
		int lineDestination;
		int colonneDestiantion;
		
		while(jeu.etatDuJeu == Parametres.MOMENT_JEU_PLACER_PIECES){
			System.out.println("Voici le plateau de jeu");
			System.out.println(jeu.plateauDeJeu.toString(10));
			System.out.println("Voici la boîte de rangement");
			
			System.out.println(jeu.boiteRangement.toString(10));
			Parametres.afficheLegende();
			System.out.println("Vous devez choisir une pièce dans la boîte. On vous demande la ligne puis la colonne de cette pièce");
			System.out.println("Quelle est la ligne où se trouve cette pièce ?");
			ligneOrigine = Clavier.lireString().charAt(0)-65;System.out.println("ligne origine = "+ligneOrigine);
			if (ligneOrigine == 25) {
				Triche.placeTout(jeu,1);
				break;
			}
			System.out.println("Quelle est la colonne où se trouve cette pièce ?");
			colonneOrigine = Clavier.lireInt();
			
			System.out.println("Vous devez choisir une case sur le plateau. On vous demande la ligne puis la colonne de cette case");
			System.out.println("Quelle est la ligne où se trouve cette case ?");
			lineDestination = Clavier.lireString().charAt(0)-65;
			System.out.println("Quelle est la colonne où se trouve cette case ?");
			colonneDestiantion = Clavier.lireInt();
			
			Deplacement.bouge(jeu,ligneOrigine,colonneOrigine,lineDestination,colonneDestiantion);
		}
		jeu.setEtatDuJeu(Parametres.MOMENT_JEU_ATTENDRE_ADVERSAIRE);
		System.out.println("Voici le plateau de jeu");
		System.out.println(jeu.plateauDeJeu.toString(20));
		System.out.println("Voici la boîte de rangement");
		
		System.out.println(jeu.boiteRangement.toString(20));
		
	}

}
