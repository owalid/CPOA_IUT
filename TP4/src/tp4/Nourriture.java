package tp4;

public class Nourriture extends Article {

	public Nourriture(String nomArticle,long id) {
		super(nomArticle,id);
	}
	
	@Override
	public void accept(StockVisitor stockVisitor){
		stockVisitor.visitNourriture(this);
	}

}
