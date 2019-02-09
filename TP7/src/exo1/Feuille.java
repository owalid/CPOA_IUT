package exo1;

public class Feuille extends Corde{
	String s;

	public Feuille(String s){
		super(s.length());
		this.s = s;
	}

	@Override
	public char get(int i) {
		return s.charAt(i);

	}

	@Override
	public Corde substr(int i, int j) {
		return new Feuille(s.substring(i, j));
	}

	@Override
	public String toString() {
		return "Feuille [s=" + s + ", longueur=" + longueur + "]";
	}



}
