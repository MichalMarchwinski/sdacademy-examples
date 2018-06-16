package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

public class FizzBuzzTest {

/*
	@DisplayName("do nothing - this pseudo test is here only to show how to create your own teast")
	@Test

	void nothing() {
		//this is how you write assertion
		assertThat(1).isEqualTo(1);
		assertThat(1).isEqualTo(2);
		fail("remove this peseudo test and start writing your own real test");
		}
*/
	@DisplayName("Test for is not null ")
	@Test
	void fizzBuzz2(){
		//given
		int number = 1;
		//when
		String msg = FizzBuzz.msg(number);
		//then
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
	@DisplayName("Test if number is 10 gets Buzz ")
	@Test
	void fizzBuzz9(){
		int number = 10;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Buzz");
	}
	@DisplayName("Test if number is 15 gets FizzBuzz ")
	@Test
	void fizzBuzz8(){
		int number = 15;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("FizzBuzz");
	}
	@DisplayName("Test if number is 30 gets FizzBuzz ")
	@Test
	void fizzBuzz10(){
		int number = 30;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("FizzBuzz");
	}
	@DisplayName("if given 2 is returns Whizz")
	@Test
	void fizzBuzz11(){
		int number = 2;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Whizz");
	}
	@DisplayName("if given 17389 returns Whizz")
	@Test
	void fizzBuzz12(){
		int number = 17389;
		String msg = FizzBuzz.msg(number);
		assertThat(msg).isEqualTo("Whizz");
	}


}
