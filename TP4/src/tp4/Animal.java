package tp4;

public class Animal extends Article{
	

	public Animal(String nomArticle,long id) {
		super(nomArticle,id);
	}
	
	@Override
	public void accept(StockVisitor stockVisitor){
		stockVisitor.visitiAnimal(this);
	}
}
