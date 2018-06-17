package pl.sdacadaemy.hr;

public class Main {
	public static void main(String[] args) {
		HRManager hrManager = new HRManager();
		CommandLineRunner.load(args, hrManager);
		CommandLineRunner.list(hrManager).forEach(System.out::println);

	}
}
