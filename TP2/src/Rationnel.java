
/**
 * Représente un nombre rationnel ou la valeur distincte "not a number" (NaN).
 */
public class Rationnel {
	// numérateur
	private final int num;
	// dénominateur
	private final int den;

	// invariant Rationnel : den >= 0 et pgcd(num, den) = 0 si den > 0

	/**
	 * Construit un Rationnel n.
	 */
	public Rationnel(int n) {
		this.num = n;
		this.den = 1;
	}

	/**
	 * Construit un Rationnel p/q. Si q = 0, construit un Rationnel = NaN.
	 * Sinon, construit un Rationnel = p/q.
	 */
	public Rationnel(int p, int q) {
		if(q == 0) {
			this.num = p;
			this.den = 0;
		} else {
			int d = pgcd(p,q);

			if(q/d < 0) {
				this.num = -p/d;
				this.den = -q/d;
			} else {
				this.num = p/d;
				this.den = q/d;
			}
		}
	}

	/**
	 * Retourne la somme de this et that. Pré-condition that != null.
	 * @return	un nouveau Rationnel égal �  this+that si aucun des deux
	 * 		est NaN. Sinon, retourne NaN.
	 */
	public Rationnel add(Rationnel that) {
		return new Rationnel(this.num*that.den + this.den*that.num,
				this.den*that.den);
	}

	/**
	 * Retourne la différence de this et that. Pré-condition that != null.
	 * @return	un nouveau Rationnel égal �  this-that si aucun des deux
	 * 		est NaN. Sinon, retourne NaN.
	 */
	public Rationnel diff(Rationnel that) {
		return new Rationnel(this.num*that.den - this.den*that.num,
				this.den*that.den);
	}


	// Exercice 2

	/**
	 * Retourne le produit de this et that. Pré-condition that != null.
	 * @return	un nouveau Rationnel égal �  this*that si aucun des deux
	 * 		est NaN. Sinon, retourne NaN.
	 */
	public Rationnel mult(Rationnel that) {
		throw new Error("�  compléter");
	}

	/**
	 * Retourne le quotient de this et that. Pré-condition that != null.
	 * @return	un nouveau Rationnel égal �  this/that si aucun des deux
	 * 		est NaN. Sinon, retourne NaN.
	 */
	public Rationnel div(Rationnel that) {
		throw new Error("�  compléter");
	}



	// Exercice 3

//	@Override
//	public int compareTo(Rationnel that) {
//		throw new Error("�  compléter");
//	}


	/**
	 * @return true ssi le Rationnel n'est pas un nombre (NaN)
	 */
	public boolean estNaN() {
		return (this.den == 0);
	}

	/**
	 * Retourne le plus grad commun diviseur de a et b. 
	 * Pré-condition b != 0.
	 * @return le plus grand d tel que a % d = 0 et b % d = 0
	 */
	private static int pgcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	/**
	 * Retourne une représentation textuelle du Rationnel sous forme
	 * réduite.
	 */
	@Override
	public String toString() {
		if(this.estNaN())
			return "NaN";
		else
			return this.num + "/" + this.den;
	}

	public static void main(String[] args) {
		Rationnel r = new Rationnel(3,-6);
		Rationnel s = new Rationnel(3,6);
		System.out.println(r + " + " + s + " = " + r.add(s));
		System.out.println(r + " - " + s + " = " + r.diff(s));
	}
}