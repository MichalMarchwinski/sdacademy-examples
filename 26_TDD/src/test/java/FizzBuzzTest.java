

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class FizzBuzzTest {


	@DisplayName("Test for is not null ")
	@Test
	void fizzBuzz2(){
		int number = 1;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isNotEqualTo(null);
	}
	@DisplayName("Test if number is 1 ")
	@Test
	void fizzBuzz3(){
		int number = 1;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("1");
	}
	@DisplayName("Test if number is 2 ")
	@Test
	void fizzBuzz4(){
		int number = 2;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("2");
	}
	@DisplayName("Test if number is 3 get Fizz ")
	@Test
	void fizzBuzz5(){
		int number = 3;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Fizz");
	}
	@DisplayName("Test if number is 5 gets Buzz ")
	@Test
	void fizzBuzz6(){
		int number = 5;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Buzz");
	}
	@DisplayName("Test if number is 6 gets Fizz")
	@Test
	void fizzBuzz7(){
		int number = 6;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Fizz");
	}
	@DisplayName("Test if number is 15 gets FizzBuzz ")
	@Test
	void fizzBuzz8(){
		int number = 15;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("FizzBuzz");
	}
	@DisplayName("Test if number is 10 gets Buzz ")
	@Test
	void fizzBuzz9(){
		int number = 10;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Buzz");
	}
	@DisplayName("Test if number is 30 gets FizzBuzz ")
	@Test
	void fizzBuzz10(){
		int number = 30;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("FizzBuzz");
	}

}
