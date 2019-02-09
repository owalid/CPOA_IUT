package designpattern.factory;
/**
 * Modelise un ensemble d'entiers.
 */
public interface Ensemble {
	/**
	 * Renvoie l'ensemble courrant apres avoir rajoute l'entier n.
	 * Peut changer l'objet courrant.
	 */
	public Ensemble rajouter(int n);

	/**
	 * Renvoie true si et seulement si l'entier n est un element de 
	 * l'ensemble courrant.
	 * Ne change pas l'objet courrant.
	 */
	public boolean chercher(int n);
}