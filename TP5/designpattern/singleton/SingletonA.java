package designpattern.singleton;

public class SingletonA extends Singleton {

	private SingletonA(){
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new SingletonA();
		}
		return instance;
	}

	@Override
	public void sePresenter() {
		System.out.println("Je suis singleton A");
	}

}
