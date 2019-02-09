package tp4;

public abstract class Article {
	private final String nomArticle;
	private final long idArticle;
	
	public Article(String nomArticle, long idArticle) {
		this.nomArticle = nomArticle;
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public long getidArticle() {
		return idArticle;
	}
	
	public abstract void accept(StockVisitor stockvisiteur);


}
