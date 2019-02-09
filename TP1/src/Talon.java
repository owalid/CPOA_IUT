import java.util.*;


public class Talon {
	private int nbCartes = 52;
	private List<Carte> cartes = new LinkedList<>();
	private int nbjeu;


	public Talon(int nbjeu ){
		this.nbjeu = nbjeu;
		for (int i=1; i<=nbjeu;i++){

			for(Carte.Couleur couleur : Carte.Couleur.values()){

				for(Carte.Valeur valeur : Carte.Valeur.values()){
					cartes.add(new Carte(valeur,couleur));
				}
			}	
		}				
	}

	public boolean estcomplet(){
		Set<Carte> setcartes = new HashSet<>(cartes);

		if(setcartes.size() != nbCartes){
			return false;
		}

		return true;
	}

	//inutile car on verifie deja que le jeux est valide dans estcomplet()
	//grace au hash

	//	public boolean estValide(){
	//		Set<Carte> setcartes = new HashSet<>(cartes);
	//		if(estcomplet()){
	//			for (int i=1; i<NB_CARTES;i++){
	//				for(int y=1; y<NB_CARTES; y++){
	//					if(i!=y){
	//						return( cartes.get(i).equals(cartes.get(y)));
	//					}
	//				}
	//			}
	//		}		
	//		else 
	//			return false;
	//	}

	//getter and setter 
	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public int getNbjeu() {
		return nbjeu;
	}

	public void setNbjeu(int nbjeu) {
		this.nbjeu = nbjeu;
	}

	@Override
	public String toString() {
		return "Talon [cartes=" + cartes + ", nbjeu=" + nbjeu + "]";
	}

	public static void main (String [] args){
		Talon t = new Talon(1);
		System.out.println(t.cartes.size());
		Set<Carte> set = new HashSet<>(t.cartes);
		System.out.println(set.size());
	}

}
