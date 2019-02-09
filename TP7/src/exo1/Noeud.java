package exo1;

public class Noeud extends Corde {
	
	private Corde filsDroit;
	private Corde filsGauche;

	Noeud(Corde filsDroit, Corde filsGauche) {
		super(filsDroit.longueur + filsGauche.longueur);
		this.filsDroit = filsDroit;
		this.filsGauche = filsGauche;
	}

	@Override
	public char get(int i) {
		if(i< filsGauche.longueur){
			return filsGauche.get(i);
		}
		
		return filsDroit.get(i - filsGauche.longueur);
	}

	@Override
	public Corde substr(int i, int j) {
		if(i==0 && j==longueur-1){
			return this;
		}
		
		//a gauche
		if(j <= filsGauche.longueur){
			return filsGauche.substr(i, j);
			}
		
		//a droite
		if(i <= filsDroit.longueur){
			return filsDroit.substr(i - filsGauche.longueur, j - filsDroit.longueur);
			}
		
		//a cheval entre deux noeud
		return new Noeud(filsGauche.substr(i,filsGauche.longueur), filsDroit.substr(j, filsGauche.longueur));
		
		
		
//		if (i<filsGauche.longueur&&j<filsGauche.longueur)
//		{
//			return filsGauche.substr(i, j);
//		}
//		else if(i<filsGauche.longueur&&j>filsDroit.longueur){
//			return new Noeud( filsGauche.substr(i, filsGauche.longueur),filsDroit.substr(0,j-filsGauche.longueur));
//		}
//		else 
//		return filsDroit.substr(i-filsGauche.longueur, j-filsGauche.longueur);
	}

	@Override
	public String toString() {
		return "Noeud [filsDroit=" + filsDroit + ", filsGauche=" + filsGauche + ", longueur=" + longueur + "]";
	}
	


}
