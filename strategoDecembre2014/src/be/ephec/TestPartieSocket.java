package be.ephec;

/**
 * @author mnv
 * Permet de tester tout rapidement
 * Va créer un serveur et plusieurs clients
 *
 */
public class TestPartieSocket {

	public static void main(String[] args) {
		ApplicationServeur as = new ApplicationServeur();
		ApplicationClient ac[] = new ApplicationClient[Param.nbTotalClient];
		for (int i=0;i<ac.length;i++){
			ac[i]= new ApplicationClient();
		}

	}

}
