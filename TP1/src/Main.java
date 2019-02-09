import java.util.*;
public class Main {

	Talon t = new Talon(1);
	List<Carte> cartes = new LinkedList<>();
	private int nbCartes;

	public Main(int nbCartes){
		this.nbCartes = nbCartes;

	}

	//verifie si les cartes dans la main sont valides
	public boolean estValide(){
		Set<Carte> setcartes = new HashSet<>(cartes);
		if(cartes.size() > 0){
			for (int i=1; i<cartes.size();i++){
				for(int y=1; y<cartes.size(); y++){
					if(i!=y){
						return( cartes.get(i).equals(cartes.get(y)));
					}
				}
			}
		}		
		else 
			return false;

		return estValide();
	}

	//renvois la valeur de la main
	public int value() {
		int somme = 0;
		for (int i=0; i<nbCartes;i++){
			somme += cartes.get(i).getValeurReelle();
		}
		return somme;
	}

	//compare deux main et renvois la difference
	public int compareTo(Object other) {

		if (!(other instanceof Main)) {
			String msg = "Can't compare a BlackjacHand  object to a " +
					other.getClass().getName() + " object: " + other;
			throw new IllegalArgumentException(msg);
		}

		Main that = (Main) other;
		return this.value() - that.value();
	}

	//ajoute un nombre de carte a la main du joueur
	public void addCard(int nbCartes){
		if(t.getNbCartes() >0){
			for(int i=0; i<nbCartes; i++){
				cartes.add(t.getCartes().get(i));
				t.getCartes().remove(t.getCartes().get(i));
				t.setNbCartes( t.getNbCartes() - nbCartes);
			}	

		}

	}


	//getter and setter
	public Talon getT() {
		return t;
	}

	public void setT(Talon t) {
		this.t = t;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}


}
