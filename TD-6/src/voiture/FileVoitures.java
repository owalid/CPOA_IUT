package voiture;

import java.util.LinkedList;

public class FileVoitures {

	
	private LinkedList<Voiture> voitures = new LinkedList<>(); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileVoitures fileVoitures = new FileVoitures();
		Voiture peugeot = new Voiture("peugeot", "1515415A4", 150);
		System.out.println("1.pas de peugeot trouvée " + fileVoitures.chercher(peugeot));
		System.out.println("2.peugeot ajoutée " + fileVoitures.ajouter(peugeot));
		System.out.println("3.peugeot trouvée " + fileVoitures.chercher(peugeot));
//		System.out.println("3bis.peugeot trouvée mais autre objet " + fileVoitures.chercher(new Voiture("renault", "999999A9", 200)));
		System.out.println("4.peugeot supprimée " + fileVoitures.supprimerPremiere());
		System.out.println("5.pas de peugeot trouvée " + fileVoitures.chercher(peugeot));
	}

	public boolean chercher(Voiture voiture) {
		return voitures.contains(voiture);
	}
	
	public boolean ajouter(Voiture voiture) {
		return voitures.add(voiture);		
	}
	
	public Voiture supprimerPremiere() {
		return voitures.remove();
		
	}

}
