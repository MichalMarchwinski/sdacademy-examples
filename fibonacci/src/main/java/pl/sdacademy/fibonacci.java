package pl.sdacademy;

public class fibonacci {
	public static int Fibonacci(int number) {
		if (number == 0 || number == 1) {
			return number;
		}
		return (Fibonacci(number - 1)) + (Fibonacci(number - 2));
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int N = 60;
		for (int i = 1; i <= N; i++) {
			System.out.println(i + ": " + Fibonacci(i));
			long end = System.currentTimeMillis();
			System.out.println("Elapsed time: " + (end - start));
		}
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (end - start));
	}
}