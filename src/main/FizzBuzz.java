package main;

public class FizzBuzz {

	public static void main(String[] args) {

		int N = 20;
		for (int n = 1; n < N; n++) {
			if (n % 15 == 0) {
				System.out.println(n + ":FizzBuzz");
			} else if (n % 3 == 0) {
				System.out.println(n + ":Fizz");
			} else if (n % 5 == 0) {
				System.out.println(n + ":Buzz");
			} else {
				System.out.println(n);
			}
		}
	}
}
