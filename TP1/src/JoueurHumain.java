import java.util.*;

public class JoueurHumain extends Joueur {
	
	public JoueurHumain(int numJoueur) {
	super(numJoueur);
	}

	@Override
	protected boolean prendCartes() {
		Scanner sc = new Scanner(System.in);
		String reponse;
		System.out.println("Veux tu piocher ? O/N?");
		reponse = sc.nextLine();
		if(reponse == "O")return true;
		else  return false;		
	}
	@Override
	protected boolean Gagne() {
		if(JoueurHumain.mainJ.value() == 21) return true;
		else return false;
	}

}
