package tp3;
public class ClearBox extends Box {
	final static char BORD = '*';
	final static char INTERIEUR=' ';
	
	public ClearBox(double largeur, double hauteur) {
		super(largeur, hauteur, INTERIEUR, BORD);
		// TODO Auto-generated constructor stub
	}
	
	public double Computerapport(){
		return(largeur/hauteur);
	}
	
	public static void main(String args[]){
		ClearBox clearB = new ClearBox(3,5);
		System.out.println(clearB);
		
	}
}

