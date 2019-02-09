package designpattern.factory;


public final class EnsembleFactory {
	private static final int SEUIL_PETIT_GRAND = 500;

	private EnsembleFactory() {	}

	public static Ensemble creerEnsemble(int[] tab) {
		if (tab.length<=SEUIL_PETIT_GRAND){
			return new PetitEnsemble(tab);
		}
		
		return new GrandEnsemble(tab);
	}
	
	public static void main(String[] args) {
		// petit ensemble
		int[] myLittleTab = new int[500];
		myLittleTab[10] = 43;		
		Ensemble ensemble = creerEnsemble(myLittleTab);
		System.out.println(ensemble);
		System.out.println("43 est stockée ? " + ensemble.chercher(43));
		Ensemble newEmsemble = ensemble.rajouter(666);
		System.out.println("apres ajout dans ancien ensemble=" + ensemble.chercher(666) );
		System.out.println("apres ajout dans nouvel ensemble=" + newEmsemble.chercher(666) );
		
		// rajouter chercher
		
		// grand ensemble
		int[] myBigTab = new int[700];

		ensemble = creerEnsemble(myBigTab);
		System.out.println(ensemble);
		

		
	}
}