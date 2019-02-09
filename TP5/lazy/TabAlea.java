package lazy;

import java.util.Random;

public class TabAlea {

	private static final int NB_ELEMENTS = 2000;
	private int[] tab;

	public TabAlea() {
		
		tab = new int[NB_ELEMENTS];
		Random random = new Random();
		for (int i = 0; i < NB_ELEMENTS; i++) {
			tab[i] =  random.nextInt(2000);			
		}
	}

	public static void main(String[] args) {
		TabAlea tabAlea = new TabAlea();
		boolean isContained = tabAlea.contient(45);
		System.out.println("45 est contenu ? " + isContained);
	}

	public boolean contient(int i) {
		for (int current : tab) {
			if (current == i) {
				return true;
			}
		}
		return false;
	}
}
