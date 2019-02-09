package tp4;

public class StockAnimalVisitor implements StockVisitor {

	private boolean isValid;

	@Override
	public void visitiAnimal(Animal animal) {
		this.isValid = false;
	}
	


	@Override
	public void visitNourriture(Nourriture nourriture) {
		this.isValid = false;
		
	}


	public boolean IsValid() {
		return isValid;
	}

}
