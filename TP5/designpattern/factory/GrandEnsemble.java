package designpattern.factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GrandEnsemble implements Ensemble {

	
	private Set<Integer> set;
	
	public GrandEnsemble(int[] tab) {
		set = new HashSet<>();		
		for (int current : tab){
			set.add(current);
		}
		
	}

	@Override
	public Ensemble rajouter(int n) {
		set.add(n);		
		return this;
	}

	@Override
	public boolean chercher(int n) {
		return set.contains(n);
	}
	
	@Override
	public String toString() {
		return "Je suis un grand ensemble";
	}

}
