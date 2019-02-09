package tp3;

public class DarkBox extends Box {

	
	public DarkBox(double largeur, double hauteur,  char charactere) {
		
		super(largeur, hauteur, charactere, charactere);
		// TODO Auto-generated constructor stub
	}

	public void updateCharacter(char c){
		this.bord = c;
		this.interieur = c;
	}
	public static void main(String [] args){
		DarkBox darkB = new DarkBox(5, 5, 'o');
		System.out.println(darkB);
	}
}
