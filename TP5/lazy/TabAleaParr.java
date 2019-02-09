package lazy;

import java.util.Arrays;
import java.util.Random;

public class TabAleaParr {

	private static final int NB_ELEMENTS = 2000;
	private int[] tableau;
	private boolean isInit;

	private void init() {
		if (isInit) {
			return;
		}

		isInit = true;
		tableau = new int[NB_ELEMENTS];
		Random random = new Random();
		for (int i = 0; i < NB_ELEMENTS; i++) {
			tableau[i] = random.nextInt(2000);
		}
	}

	public static void main(String[] args) {
		TabAleaParr tabAlea = new TabAleaParr();
		System.out.println("tableau=" + tabAlea.toString());
		boolean isContained = tabAlea.contient(45);
		System.out.println("45 est contenu ? " + isContained);
		System.out.println("tableau=" + tabAlea.toString());
	}

	public boolean contient(int i) {
		init();
		for (int current : tableau) {
			if (current == i) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "TabAleaParr [tab=" + Arrays.toString(tableau) + ", isInit="
				+ isInit + "]";
	}
}
