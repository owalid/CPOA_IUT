package tp4;

public class Animalerie {
	private Stock stockNourriture;
	private Stock stockAnimal;

	public Animalerie(int capaciteAnimal, int capaciteNourriture){
		stockAnimal = new StockAnimal(capaciteAnimal);
		stockNourriture = new StockNouriture(capaciteNourriture);
	}
	public static void main(String [] args){
		Animalerie animalis = new Animalerie(100,200);
		
		System.out.println(animalis);
	}
	
	public void stockNourriture(Article article){
		stockNourriture.stocker(article);
	}
	
	public void stockAnimal(Article article){
		stockAnimal.stocker(article);
	}
	
	public Article retirerArticleNouriture(int id){
		return stockNourriture.chercher(id);
	}
	
	public Article retirerArticleAnimal(int id){
		return stockAnimal.chercher(id);
	}
}
