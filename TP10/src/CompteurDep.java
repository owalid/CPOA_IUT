import java.util.ArrayList;
import java.util.List;


public class CompteurDep implements Runnable {

	
	private String nomCpt;
	private static  int rang;//volatile permet de synchroniser toute les variable en memoire lors de la modification de celle ci un instant t
	
	public CompteurDep(String nomCpt) {
		this.nomCpt = nomCpt;
	}

	@Override
	public void run() {

		
		synchronized (CompteurDep.class) {
			System.out.println("position " + rang + " : " + nomCpt);
			rang++;
		}

	}
	
	
	/**
	 * @param args
	 */	
	public static void main(String args){
		List<Thread> threads = new ArrayList<>();
		for(int i=0; i<4 ; i++){
			threads.add(new Thread(new Compteur(String.valueOf(i))));
			threads.get(i).start();
		}
	
		
	}

}
