package tp3;
public class Box implements Img {
	double largeur;
	double hauteur;
	char interieur;
	char bord;

	public Box(double largeur, double hauteur, char interieur, char bord) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.interieur = interieur;
		this.bord = bord;
	}

	@Override
	public String toString() {
		long m = Math.round(Math.ceil(largeur));
		long n = Math.round(Math.ceil(hauteur));

		String res = "";

		for(long i = 0; i < m; ++i) {
			for(long j = 0; j < n; ++j) {
				if(i==0 || i==m-1 || j==0 || j==n-1)
					res += bord;
				else
					res += interieur;
			}
			res += "\n";
		}

		return res;
	}

	public void scale(double factor) {
		largeur *= factor;
		hauteur *= factor;
	}

	public static void main(String[] args) {
		Box b = new Box(2.3, 3.5, 'H', '*');
		System.out.println(b);
	}
}