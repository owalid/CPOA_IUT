package tp4;

import java.util.Iterator;
import java.util.List;

public class StockNouriture extends Stock {
	
	private List<Nourriture> nourritures;
	
	public StockNouriture(int capacite) {
		super(capacite);
	}

	@Override
	public boolean stocker(Article art) {
		StockNourritureVisitor stockVisitor = new StockNourritureVisitor();
		art.accept(stockVisitor);
		
		if(!stockVisitor.IsValid()){
			return false;
		}
		
		if(capacite == nourritures.size()){
			return false;	
		}
		
		return nourritures.add((Nourriture)art);
	}

	@Override
	public Article chercher(int id) {
		for(Iterator<Nourriture> iterator = nourritures.iterator(); iterator.hasNext();){
			Nourriture current = iterator.next();
			if(id == current.getidArticle()){
				iterator.remove();
				return current;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "StockNouriture [nourritures=" + nourritures + "]";
	}

}
