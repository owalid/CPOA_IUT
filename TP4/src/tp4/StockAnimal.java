package tp4;

import java.util.Iterator;
import java.util.List;

public class StockAnimal extends Stock {

	private List<Animal> animales;
	public StockAnimal(int capacite) {
		super(capacite);
	}

	@Override
	public boolean stocker(Article art) {
		StockAnimalVisitor stockVisitor = new StockAnimalVisitor();
		art.accept(stockVisitor);
		
		if(!stockVisitor.IsValid()){
			return false;
		}
		
		if(capacite == animales.size()){
			return false;	
		}
		
		return animales.add((Animal)art);
	}

	@Override
	public Article chercher(int id) {
		for(Iterator<Animal> iterator = animales.iterator(); iterator.hasNext();){
			Animal current = iterator.next();
			if(id == current.getidArticle()){
				iterator.remove();
				return current;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "StockAnimal [animales=" + animales + "]";
	}

}
