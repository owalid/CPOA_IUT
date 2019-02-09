package tp5;

public class Voiture {

	private float vitesseMax;
	private String marque;
	private String immat;


	public Voiture(String marque, String numeroImmatriculation,
			float vitesseMaximale) {
		this.marque = marque;
		this.immat = numeroImmatriculation;
		this.vitesseMax = vitesseMaximale;
	}

	public String getMarque() {
		return marque;
	}

	public String getNumeroImmatriculation() {
		return immat;
	}

	public float getVitesseMaximale() {
		return vitesseMax;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", numeroImmatriculation="
				+ immat + ", vitesseMaximale="
				+ vitesseMax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime
				* result
				+ ((immat == null) ? 0 : immat
						.hashCode());
		result = prime * result + Float.floatToIntBits(vitesseMax);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Voiture)) {
			return false;
		}
		Voiture other = (Voiture) obj;

		if (marque.equals(other.marque)
				&& immat.equals(other.immat)
				&& vitesseMax == other.vitesseMax) {

			return true;
		}
		
		return false;
	}

}
