package tp3;

public class Chaos {
	
	private static final int MAX = 3;

	private int m;
	private int n;

	public Chaos() {
		m = 1 + (int) (Math.random()*MAX);
		n = 1 + (int) (Math.random()*MAX);
	}

	@Override
	public String toString() {
		String res = "";
		int k = 0;
		for(int i=0; i < m; ++i) {
			for(int j=0; j < n; ++j) {
				res += k++;
			}
			res += '\n';
		}		
		return res;
	}
}
