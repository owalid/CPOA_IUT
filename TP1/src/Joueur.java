abstract class Joueur {
	public int numJoueur;
	protected static Main mainJ = new Main(2);

	public Joueur(int numJoueur){
		this.numJoueur = numJoueur;
	}
	//renvois vrai si le user veux piocher ou pas
	protected abstract boolean prendCartes();
	
	//renvois vrai si un des joueurs gagne
	protected abstract boolean Gagne();
}
