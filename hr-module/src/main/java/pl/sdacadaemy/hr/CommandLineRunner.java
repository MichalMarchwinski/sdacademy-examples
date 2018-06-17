package pl.sdacadaemy.hr;

import java.util.stream.Stream;

public class CommandLineRunner {

	public static void load(String[] args, HRManager hrManager) {
		if (Stream.of(args).allMatch(arg -> arg.contains("firstName") || arg.contains("lastName") || arg
			.contains("dateOfBirth"))) {
			hrManager.create(extractArgument(args[0],"firstName"), extractArgument(args[1],"lastName"),
				extractArgument(args[2], "dateOfBirth"));
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	private static String extractArgument(String argument, String argumentKey){
		return argument.split(argumentKey + "=")[1];
	}
}
