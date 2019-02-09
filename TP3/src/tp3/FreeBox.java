package tp3;


public class FreeBox implements Img {
	double nbLignes;
	double nbcolones;
	int nbLigneInTab;
	int nbColonneInTab;
	char [][] tab;
	


	public FreeBox(double nbLignes, double nbcolones, String motif) {
		this.nbLignes = nbLignes;
		this.nbcolones = nbcolones;
		
		String[] lines = motif.split("[\\r?\\n ]+");
		
		this.nbLigneInTab= lines.length;
		this.nbColonneInTab= lines[0].length();
		
		tab = new char[nbLigneInTab][nbColonneInTab];
		for(int i=0; i< nbLigneInTab; i++){
			for(int j=0; j<nbColonneInTab;j++){
				tab[i][j] = lines[i].charAt(j);
				
			}
		}
	}

	@Override
	public void scale(double factor) {
		nbLignes *= factor;
		nbcolones *= factor;
	}

	@Override
	public String toString() {
		long nbLigneArrondi = Math.round(Math.ceil(nbLignes));
		long nbcolloneArrondi = Math.round(Math.ceil(nbcolones));

		StringBuilder res = new StringBuilder();
		

		for(int i = 0; i < nbLigneArrondi; ++i) {
			for(int j = 0; j < nbcolloneArrondi; ++j) {
				res.append(tab[i % (nbLigneInTab)] [j % (nbColonneInTab)]);
			}
			res.append(System.lineSeparator());
		}
			
			return res.toString();
				
	}

	public static void main(String [] args){
		FreeBox Fbox = new FreeBox(5, 4, "salutmec");
		System.out.println(Fbox);
	}

}
