package pl.sdacademy.anagramy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;


public class AnagramTest {

	@DisplayName("Test if give pies returns siep")
	@Test
	@Disabled
	void test() {
		//given
		String str = "pies";
		//when
		Set<String> name = Anagramy.converter(str);
		//then
		assertThat(name).contains("siep");
	}
	@DisplayName("Test if give pies returns epis")
	@Test
	@Disabled
	void test1() {
		//given
		String str = "pies";
		//when
		Set<String> name = Anagramy.converter(str);
		//then
		assertThat(name).contains("epis");
	}
	@DisplayName("Test if given jo returns all anagrams")
	@Test
	void test2() {
		//gien
		String str = "jo";
		//when
		Set<String> name = Anagramy.converter(str);
		//then
		assertThat(name).containsOnly("jo","oj");
	}
	@DisplayName("Test if given oo returns all anagrams")
	@Test
	void test3() {
		//gien
		String str = "oo";
		//when
		Set<String> name = Anagramy.converter(str);
		//then
		assertThat(name).containsOnly("oo");
	}
	@DisplayName("Test if given kot returns all anagrams")
	@Test
	void test4() {
		//given
		String str ="kot";
		//when
		Set<String> name = Anagramy.converter(str);
		//then
		assertThat(name).containsOnly("kot","kto","otk","okt","tok","tko");
	}

}
