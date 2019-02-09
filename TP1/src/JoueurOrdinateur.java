
public class JoueurOrdinateur extends Joueur {
	
	public JoueurOrdinateur(int numJoueur) {
		super(numJoueur);
	}

	@Override
	protected boolean prendCartes() {
		if(JoueurOrdinateur.mainJ.value() <= 16) return true;
		else return false;
	}

	@Override
	protected boolean Gagne() {
		if(JoueurOrdinateur.mainJ.value() == 21) return true;
		else return false;
	}

}
