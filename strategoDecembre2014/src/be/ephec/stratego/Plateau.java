package be.ephec.stratego;

public class Plateau extends Damier {

	public Plateau(int nbLignes, int nbColonnes) {
		
		super(nbLignes, nbColonnes);
		for (int l=0;l<4;l++){
			for (int c=0;c<nbColonnes;c++){
				matrice[l][c] = new Case(false,null, true,l,c);
			}
		}
		for (int l=4;l<nbLignes;l++){
			for (int c=0;c<nbColonnes;c++){
				matrice[l][c] = new Case(false,null, false,l,c);
			}
		}
		// ce qui suit permet de créer les lacs au mileu
		matrice[4][2] = new Case(true,null,false,4,2);
		matrice[4][3] = new Case(true,null,false,4,3);
		matrice[5][2] = new Case(true,null,false,5,2);
		matrice[5][3] = new Case(true,null,false,5,3);
		matrice[4][6] = new Case(true,null,false,4,6);
		matrice[4][7] = new Case(true,null,false,4,7);
		matrice[5][6] = new Case(true,null,false,5,6);
		matrice[5][7] = new Case(true,null,false,5,7);
	}


}
