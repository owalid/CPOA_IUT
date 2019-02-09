package exo1;
public abstract class Corde {
	final int longueur;

	Corde(int longueur) {
		this.longueur = longueur;
	}
	
	 public abstract char get(int i);

	 public abstract Corde substr(int i, int j);

	 public Corde concat(Corde c){
		return new Noeud(this,c);
	 }
	
	 public Corde insert(Corde cordeInsert, int i){
		 //raisoner dans le sens avant et apres pour pouvoir insert
		 Corde before = substr(0, i);
		 Corde after = substr(i, longueur);
		 return before.concat(cordeInsert).concat(after);
	 }

	public static void main(String[] args) {
		Corde c = new Noeud(new Noeud(new Feuille("Bon"), new Feuille("jour, ")), new Feuille("bienvenue"));
		System.out.println(c);
		char elementIndex10 = c.get(10);
		System.out.println("elementIndex10" + elementIndex10);
		
		Corde nouvelleC = c.insert(new Feuille("ne "), 3);
		
		System.out.println("nouvelle corde = " + nouvelleC);
	}
}