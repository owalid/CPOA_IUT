import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Compteur implements Runnable {
	private String nomCpt;
	
	public Compteur(String nomCpt) {
		this.nomCpt = nomCpt;
	}

	@Override
	public void run() {
		IntStream.range(0, 100).forEach(i -> System.out.println(nomCpt + " : " + i));

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
