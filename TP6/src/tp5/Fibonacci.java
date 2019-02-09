package tp5;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {


	private static Map<Integer, Integer> resultN;
	
	static{
		resultN = new HashMap<>();
		resultN.put(0, 0);
		resultN.put(1, 1);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Avec fibo de 6, j'attends le résultat 8 = "
				+ Fibonacci.fibonacciNaif(6));
		
		long start = System.currentTimeMillis();	
		System.out.println("Avec fibo naif de 45, j'attends le résultat 1134903170 = "
				+ Fibonacci.fibonacciNaif(45));
		long stop = System.currentTimeMillis();
		System.out.println("temp écoulé " + (stop-start)/1000F);
		 //deuxieme cas
		 start = System.currentTimeMillis();	
		System.out.println("Avec fibo optimisé de 45, j'attends le résultat 1134903170 = "
				+ Fibonacci.fibonacci(45));
		 stop = System.currentTimeMillis();
		System.out.println("temp écoulé " + (stop-start)/1000F);
		

	}

	private static int fibonacci(int n) {
		System.out.println("invocation fibonacci() avec n=" + n);
		if (n == 0 || n == 1) {
			return n;
		}

		if (resultN.containsKey(n)){
			return resultN.get(n);
		}
		
		int newResult = fibonacci(n - 1)  + fibonacci(n - 2);
		resultN.put(n, newResult);
		return newResult;
		
	}

	public static int fibonacciNaif(int n) {

		System.out.println("invocation fibonacciNaif() avec n=" + n);
		if (n == 0 || n == 1) {
			return n;
		}

		return fibonacciNaif(n - 1) + fibonacciNaif(n - 2);
	}

}
