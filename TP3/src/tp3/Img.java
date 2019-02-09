package tp3;
/**
 * Represente une image 2D de caracteres.
 */
public interface Img {
	/**
	* Retourne une representation graphique de l'image.
	*
	* @return  le String representant l'image
	*/
	@Override
        public String toString();

	/**
	 * Change la taille de l'image en multipliant sa taille par un facteur
	 * donne.
	 * 
	 * @param factor    le facteur de multiplication, doit etre entre 0.1 et
	 *                  10.0
	 */
	 public void scale(double factor);
}
