package tp5;
import java.util.HashSet;
import java.util.Set;

public class Village {
	
	private Set<Personne> personnes = new HashSet<>();

	private boolean supprimer(Personne personne) {
		return personnes.remove(personne);
	}

	public boolean ajouter(Personne personne) {
		return personnes.add(personne);
	}

	@Override
	public String toString() {
		return "Village [personnes=" + personnes + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Village village = new Village();
		System.out.println("1.aucune personne=" + village.toString());
		Personne johnDoe = new Personne("john", "doe");

		System.out.println("2.john doe ajouté=" + village.ajouter(johnDoe));
		System.out.println("une personne attendue=" + village.toString());

		System.out.println("3.john doe encore ajouté="
				+ village.ajouter(new Personne("john", "doe")));
		System.out.println("toujours une seule personne attendue="
				+ village.toString());

		System.out.println("4.suppression john doe="
				+ village.supprimer(johnDoe));

		System.out.println("aucune personne=" + village.toString());
	}



}
