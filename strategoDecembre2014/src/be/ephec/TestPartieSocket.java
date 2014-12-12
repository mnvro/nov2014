package be.ephec;

public class TestPartieSocket {

	public static void main(String[] args) {
		ApplicationServeur as = new ApplicationServeur();
		ApplicationClient ac[] = new ApplicationClient[Param.nbTotalClient];
		for (int i=0;i<ac.length;i++){
			ac[i]= new ApplicationClient();
		}

	}

}
