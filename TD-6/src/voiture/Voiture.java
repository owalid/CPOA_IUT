package voiture;

public class Voiture {

	private String marque;
	private String numeroImmatriculation;
	private float vitesseMaximale;

	public Voiture(String marque, String numeroImmatriculation,
			float vitesseMaximale) {
		this.marque = marque;
		this.numeroImmatriculation = numeroImmatriculation;
		this.vitesseMaximale = vitesseMaximale;
	}

	public String getMarque() {
		return marque;
	}

	public String getNumeroImmatriculation() {
		return numeroImmatriculation;
	}

	public float getVitesseMaximale() {
		return vitesseMaximale;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", numeroImmatriculation="
				+ numeroImmatriculation + ", vitesseMaximale="
				+ vitesseMaximale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime
				* result
				+ ((numeroImmatriculation == null) ? 0 : numeroImmatriculation
						.hashCode());
		result = prime * result + Float.floatToIntBits(vitesseMaximale);
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
				&& numeroImmatriculation.equals(other.numeroImmatriculation)
				&& vitesseMaximale == other.vitesseMaximale) {

			return true;
		}
		
		return false;
	}

}
