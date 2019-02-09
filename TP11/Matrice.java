import java.util.concurrent.*;

public class Matrice {
	private final int m;
	private final int n;
	private final double[][] entrees;

	public Matrice(int m, int n) {
		this(m, n, new double[m][n]);
	}

	public Matrice(int m, int n, double[][] entrees) throws IllegalArgumentException {
		if(entrees.length != m)
			throw new IllegalArgumentException("entrees n'a pas m lignes");

		for(int i = 0; i < m; ++i) {
			if(entrees[i].length != n)
				throw new IllegalArgumentException("entrees n'a pas n colonnes");
		}

		this.m = m;
		this.n = n;
		this.entrees = entrees;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(!(o instanceof Matrice))
			return false;
		Matrice that = (Matrice) o;

		if(this.m != that.m || this.n != that.n)
			return false;

		for(int i = 0; i < m; ++i)
			for(int j = 0; j < n; ++j)
				if(this.entrees[i][j] != that.entrees[i][j])
					return false;

		return true;
	}

	@Override
	public String toString() {
		String res = "";
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				res += entrees[i][j] + "\t";
			}
			res += "\n";
		}
		return res;
	}

	public Matrice produit(Matrice B) {
		Matrice A = this;
		if(A.n != B.m)
			throw new IllegalArgumentException("tailles non compatibles");
		int p = B.n;

		double[][] C = new double[m][p];

		ExecutorService exec = Executors.newCachedThreadPool();
		@SuppressWarnings("unchecked")
		Future<Double>[][] resultats = (Future<Double>[][])(new Future<?>[m][p]);
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < p; ++j) {
				final int fi = i;
				final int fj = j;
				resultats[i][j] = exec.submit(new Callable<Double>() {
					public Double call() {
						double res = 0;
						for(int k = 0; k < n; ++k)
							res += A.entrees[fi][k] * B.entrees[k][fj];
						return res;
					}
				});
			}
		}

		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < p; ++j) {
				try {
					C[i][j] = resultats[i][j].get();
				} catch(Exception e) {
					C[i][j] = 0;
				}
			}
		}

		exec.shutdown();

		return new Matrice(m, p, C);
	}

	public static void main(String[] args) {
		Matrice A = new Matrice(3, 2, new double[][] {{1, 2}, 
			                                      {3, 4}, 
			                                      {5, 6}});

		Matrice B = new Matrice(2, 2, new double[][] {{1, 0}, 
			                                      {1, 1}});

		System.out.println(A.produit(B));
	}
}
