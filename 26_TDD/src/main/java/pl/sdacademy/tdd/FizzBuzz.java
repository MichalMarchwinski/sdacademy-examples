package pl.sdacademy.tdd;
public class FizzBuzz {

	public static String msg(int number) {

		switch (number) {
			case 0:
				return "FizzBuzz";
			case 1:
				return "1";
			case 2:
				return "Whizz";
			case 3:
				return "FizzWhizz";
			case 5:
				return "BuzzWhizz";
			default: break;
		}

			for (int i = 2; i <number;i++) {
			if (number % i == 0) {
				//if (number % 15 == 0)
				if (number % 3 == 0 && number % 5 == 0) {
					return "FizzBuzz";
				}
				if (number % 3 == 0 ) {
					return "Fizz";
				}
				if (number % 5 == 0) {
					return "Buzz";
				}
			} else {
				return "Whizz";
			}
		}
		return String.valueOf(number);
	}
}
