package tp3;


public class Repeated<P> implements Img {

	protected P[][] tab;
	protected double nbLigne;
	protected double nbColonne;
	private int nbLigneInTab;
	private int nbColonneInTab;

	public Repeated() {
	}

	public Repeated(double nbLigne, double nbColonne, P[][] tab)
			throws IllegalArgumentException {
		this.tab = tab;
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;

		nbLigneInTab = tab.length;
		nbColonneInTab = tab[0].length;

		for (int i = 1; i < nbLigneInTab; ++i) {
			if (tab[i].length != nbColonneInTab)
				throw new IllegalArgumentException("non-rectangular array!");
		}
	}

	@Override
	public void scale(double factor) {
		nbLigne *= factor;
		nbColonne *= factor;
	}
	
	@Override
	public String toString() {
//		
//		long nbLigneArrondi = Math.round(Math.ceil(nbLigne));
//		long nbcolloneArrondi = Math.round(Math.ceil(nbColonne));
//
//		StringBuilder res = new StringBuilder();
//		
//		if(P.toString() > P.toString()){
//				for(int i = 0; i < nbLigneArrondi; ++i) {
//					for(int j = 0; j < nbcolloneArrondi; ++j) {
//						res.append(tab[i % (nbLigneInTab)] [j % (nbColonneInTab)]);
//					}
//					res.append(System.lineSeparator());
//				}
//					
//					return res.toString();
//		}		
//		
//		else(){
//			
//		}
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Chaos[][] tab = new Chaos[2][3];

		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 3; ++j) {
				tab[i][j] = new Chaos();
				System.out.println("chaos " + i + "," + j + ":");
				System.out.println(tab[i][j]);
			}
		}

		Repeated<Chaos> repeatedChaos = new Repeated<Chaos>(2.3, 3.5, tab);
		System.out.println("repeatedChaos toString() : ");

		System.out.println(repeatedChaos);
		System.out.println("-------------------");
		System.out.println("scale *2");
		repeatedChaos.scale(2.0);
		System.out.println(repeatedChaos);
	}

}