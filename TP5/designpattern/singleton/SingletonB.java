package designpattern.singleton;

public class SingletonB extends Singleton {

	private SingletonB(){
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new SingletonB();
		}
		return instance;
	}
	
	@Override
	public void sePresenter() {
		System.out.println("Je suis singleton B");
	}

}
