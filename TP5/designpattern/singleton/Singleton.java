package designpattern.singleton;

public abstract class Singleton {

	public static Singleton instance;
	
	public abstract void sePresenter();
		
	
	public static void main(String[] args) {
		SingletonA.getInstance().sePresenter();
		SingletonB.getInstance().sePresenter();
	}
}
