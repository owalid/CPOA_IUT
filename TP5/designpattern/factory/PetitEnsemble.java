package designpattern.factory;

import java.util.Arrays;

public class PetitEnsemble implements Ensemble {

	private int[] tab;

	public PetitEnsemble(int[] tab) {
		this.tab = tab;
	}

	@Override
	public Ensemble rajouter(int n) {
		tab = Arrays.copyOf(tab, tab.length + 1);
		tab[tab.length - 1] = n;
		return this;
	}

	@Override
	public boolean chercher(int n) {
		for (int current : tab) {
			if (current == n) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Je suis un petit Ensemble";
	}

}
