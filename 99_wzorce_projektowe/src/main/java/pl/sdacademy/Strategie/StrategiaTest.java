package pl.sdacademy.Strategie;

public class StrategiaTest {
	public static void main(String[] args) {
		Knight anna = new Knight("Anna", 20);
		Knight zbyszko = new Knight("Zbyszko", 40);
		Knight dobromil = new Knight("Dobromil", 70);

		KnightValidator oldValid = new OldKnightsValidator();
		KnightValidator nameValid = new MaleKnightsValidator();

		Arena eldersArena = new Arena(oldValid);
		Arena maleArena = new Arena(nameValid);

		eldersArena.addKnight(anna);
		eldersArena.addKnight(zbyszko);
		eldersArena.addKnight(dobromil);

		maleArena.addKnight(anna);
		maleArena.addKnight(zbyszko);
		maleArena.addKnight(dobromil);

		System.out.println("=== Arena Seniorów ===");
		System.out.println(eldersArena);

		System.out.println("---- Arena bez równouprawnienia ----");
		System.out.println(maleArena);

	}
}
