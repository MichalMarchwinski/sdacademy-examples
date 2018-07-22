package pl.sdacademy.tank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {



	@DisplayName("Should have filed up tank")
	@Test
	void test00() {
		//given
		Car carPetrol = new Car(Tank.PETROL);
		//when
		boolean result = carPetrol.fullTank();
		//then
		assertThat(result).isEqualTo(true);
	}
	@DisplayName("Should give how much i would pay for given petrol")
	@Test
	void test01() {
		//given
		Car carPetrol = new Car(Tank.PETROL);
		Car carDisel = new Car(Tank.DISEL);
		int currentTank = 10;
		//when
		int result = carPetrol.fillUpTheTankAndKnowHowMuchIPaid(currentTank);
		int result1 = carDisel.fillUpTheTankAndKnowHowMuchIPaid(currentTank);
		//then
		assertThat(result).isEqualTo(160);
		assertThat(result1).isEqualTo(128);
	}
}
