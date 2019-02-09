
package tp2;
import java.util.*;
//QUESTION 1
//*************************************************************
//1/
//Est NaN quand le denom est egal a zero jeux de methode
//contructeur avec des parametre entier non objet int != integer
//**************************************************************
//2/
//
//**************************************************************
//3/
//nous somme dans une metode d'instance 
//**************************************************************
//4/
//Non car les champs seront final car modifier final ne permet pas de reasigner un champs(protection pour le constructeur)
//**************************************************************


/**
 * Représente un nombre rationnel ou la valeur distincte "not a number" (NaN).
 */
public class Rationnel implements Comparable<Rationnel> {
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
		return new Rationnel(this.num*that.num,this.den*that.den);
	}

	/**
	 * Retourne le quotient de this et that. Pré-condition that != null.
	 * @return	un nouveau Rationnel égal �  this/that si aucun des deux
	 * 		est NaN. Sinon, retourne NaN.
	 */
	public Rationnel div(Rationnel that) {
		if(that.estNaN())
			return new Rationnel(1,0);
		
		else
		return new Rationnel(this.num*that.den,
				this.den*that.num);
	}



	// Exercice 3

//	@Override
//	public int compareTo(Object that) {
//	
//	if (!(that instanceof Rationnel)) {
//		String msg = "Can't compare a BlackjacHand  object to a " +
//				that.getClass().getName() + " object: " + that;
//		throw new IllegalArgumentException(msg);
//	}
//
//	Rationnel that = (Rationnel) that;
//	return 1;
//	}
	
	@Override
	public int compareTo(Rationnel o) {

		if(estNaN() && o.estNaN()) return -1;
		if(!estNaN() && o.estNaN()) return -1;
		if(estNaN() && o.estNaN()) return -1;
		
		
		return Float.compare(num/den,o.num/o.den);
	}
	



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
		
		Rationnel r1 =new Rationnel(4,4); 
		Rationnel r2 = new Rationnel(4,0);
		Rationnel r3 = new Rationnel(-4,-4);
		Rationnel r4 = new Rationnel(120,8);
		List<Rationnel> rationnels = Arrays.asList(r1,r2,r3,r4);
		System.out.println("before=" + rationnels);
		Collections.sort(rationnels);
		System.out.println("after=" + rationnels);

	}
}