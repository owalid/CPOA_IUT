
public class Carte {

	private Valeur valeur;
	private Couleur couleur;
	public int valeurReelle;

	//enum de valeur en fonction de la carte piocher une valeur differente 
	public enum Valeur {
		AS {
			@Override
			int getNumValeur() {
				return 0;
			}
		},
		DEUX {
			@Override
			int getNumValeur() {
				return 2;
			}
		},
		TROIS {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 3;
			}
		},
		QUATRE {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 4;
			}
		},
		CINQ {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 5;
			}
		},
		SIX {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 6;
			}
		},
		SEPT {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 7;
			}
		},
		HUIT {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 8;
			}
		},
		NEUF {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 9;
			}
		},
		DIX {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 10;
			}
		},
		VALLET {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 10;
			}
		},
		DAME {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 10;
			}
		},
		ROI {
			@Override
			int getNumValeur() {
				// TODO Auto-generated method stub
				return 10;
			}
		};

		// CLASSE ABSTRAITE POUR DEFINIR LES VALEUR DES VALEURS DES CARTES
		abstract int getNumValeur();

	}

	public enum Couleur {
		CARREAU, COEUR, PIQUE, TREFLE;
	}

	//constructeur de carte
	public Carte(Valeur valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;

	}


	//getter and setter
	public Valeur getValeur() {
		return valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public int getValeurReelle() {
		return valeurReelle;
	}

	public void setValeurReelle(int valeurReelle) {
		this.valeurReelle = valeurReelle;
	}

	//lors de la modif de equals on est obliger de modifier le hash
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		return result;
	}

	//	verification de equals
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Carte)) {
			return false;
		}

		Carte other = (Carte) obj;
		if (couleur != other.couleur && valeur != other.valeur )
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Carte [valeur=" + valeur + ", couleur=" + couleur + ", valeurReelle=" + valeurReelle + "]";
	}

	public static void main(String[] args) {
		Carte c = new Carte(Valeur.DAME, Couleur.CARREAU);
		System.out.println(c);
	}

}
