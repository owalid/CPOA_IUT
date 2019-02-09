public class Liste {
	private final int val;
	private final Liste successeur;

	public Liste(int valeur, Liste successeur) {
		this.val = valeur;
		this.successeur = successeur;
	}

	public Liste(int valeur) {
		this(valeur, null);
	}

	public Liste inserer(int x) {
		return new Liste(x, this);
	}
	
	public Liste inserer2(int x) {
		if(Math.random() < 0.999) {
			return new Liste(x, this);
		} else {
			return this;
		}
	}

	@Override
	public String toString() {
		String ret = "" + val;
		if(successeur != null)
			ret += "," + successeur.toString();
		return ret;
	}

	public static void main(String[] args) {
		Liste li = new Liste(1);
		li = li.inserer(2).inserer(3).inserer(4);

		System.out.println(li);
	}
}
