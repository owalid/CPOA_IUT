package tp5;
public class Personne {

	private String nom;
	private String prenom;

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}

	@Override
	public int hashCode() {
		return nom.hashCode() + prenom.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Personne)) {
			return false;
		}
		Personne other = (Personne) obj;

		if (nom.equals(other.nom) && prenom.equals(other.prenom)) {
			return true;
		}

		return false;
	}

}
