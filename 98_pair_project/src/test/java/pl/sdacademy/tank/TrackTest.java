package pl.sdacademy.tank;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class TrackTest {

	@DisplayName("samochód może przejechać jedno okrążenie")
	@Test
	void trackTest01() {
		//given
		Car car = new Car(TypeCar.DIESEL);
		Track track = new Track();
		track.setRound(0);
		//when
		track.driveOneRound(car);
		//then
		assertThat(track.getRound()).isEqualTo(1);
	}

	@DisplayName("samochór ma przejechać 100 okrążeń")
	@Test
	void trackTest02() {
		//given
		Car car = new Car(TypeCar.DIESEL);
		Track track = new Track();
		track.addCar(car);
		track.setRound(0);
		//when
		track.driveRace(100);
		//then
		assertThat(track.getRound()).isEqualTo(100);
	}

	@DisplayName("określamy stopień zużycia paliwa, opon i stopień zabrudzenia samochodu na jednego okrążenie")
	@Test
	void trackTest03() {
		//given
		Car bmw = new Car(TypeCar.DIESEL);
		bmw.setCurrentFuelLevel(bmw.getMAX_FUEL_LEVEL());
		Track track = new Track();
		track.addCar(bmw);
		track.setRound(0);
		int initalDirtValue = track.getCars().get(0).getCarDirt();
		int initialTireValue = track.getCars().get(0).getTires();
		int initialFuelValue = track.getCars().get(0).getCurrentFuelLevel();
		//when
		track.driveRace(1);

		//then
		assertThat(track.getCars().get(0).getTires()).isEqualTo(3+initialTireValue);
		assertThat(track.getCars().get(0).getCarDirt()).isEqualTo(2+initalDirtValue);
		assertThat(track.getCars().get(0).getCurrentFuelLevel()).isEqualTo(initialFuelValue-7);
	}

	@DisplayName("określamy stopień zużycia paliwa, opon i stopień zabrudzenia samochodu na wielu okrążenie")
	@ParameterizedTest
	@CsvSource({"2, 6, 4, 14", "50, 150, 100, 350"})
	void trackTest03(int numberOfTracks, int tireUsage, int dirtOnCar, int fuelUsage) {
		//given
		Car bmw = new Car(TypeCar.DIESEL);
		bmw.setCurrentFuelLevel(bmw.getMAX_FUEL_LEVEL());
		Track track = new Track();
		track.addCar(bmw);
		track.setRound(0);
		int initalDirtValue = track.getCars().get(0).getCarDirt();
		int initialTireValue = track.getCars().get(0).getTires();
		int initialFuelValue = track.getCars().get(0).getCurrentFuelLevel();
		//when
		track.driveRace(numberOfTracks);

		//then
		assertThat(track.getCars().get(0).getTires()).isEqualTo(tireUsage+initialTireValue);
		assertThat(track.getCars().get(0).getCarDirt()).isEqualTo(dirtOnCar+initalDirtValue);
		assertThat(track.getCars().get(0).getCurrentFuelLevel()).isEqualTo(initialFuelValue-fuelUsage);
	}
}
