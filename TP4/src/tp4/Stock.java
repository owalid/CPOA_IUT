package tp4;
/**
 * Modelise un stock d'une animalerie.
 */
public abstract class Stock {
	final int capacite;
	int nbArt;

	Stock(int capacite) {
		this.capacite = capacite;
		this.nbArt = 0;
	}

	/**
	 * Stocke un article.
	 *
	 * @param art	l'article a stocker
	 *
	 * @return	true si l'article a pu etre stocke, false sinon
	 */
	public abstract boolean stocker(Article art);

	/**
	 * Cherche, retire et retourne un article.
	 *
	 * @param id	le numero d'identification de l'article
	 *
	 * @return	l'article cherche ou null s'il n'existe pas dans le
	 * 		stock
	 */
	public abstract Article chercher(int id);

	/**
	 * Retourne une representation textuelle du stock.
	 *
	 * @return  	un String representant le stock
	 */
	@Override
	public String toString() {
		return "nombre d'articles : " + nbArt + ", capacite : " + capacite;
	}
}