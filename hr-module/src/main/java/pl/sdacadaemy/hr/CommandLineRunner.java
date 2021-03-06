package pl.sdacadaemy.hr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandLineRunner {

	public static void load(String[] args, HRManager hrManager) {
		if (containsAllArguments(args))
		{
			createEmployee(args,hrManager);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	private static void createEmployee(String[] args, HRManager hrManager) {
		hrManager.create(
			extractArgument(args[0],"firstName"),
			extractArgument(args[1],"lastName"),
			extractArgument(args[2], "dateOfBirth"));
	}

	private static boolean containsAllArguments(String[] args) {
		return Stream.of(args).allMatch(
			arg -> arg.contains("firstName") ||
				arg.contains("lastName") ||
				arg.contains("dateOfBirth"));

	}

	private static String extractArgument(String argument, String argumentKey){
		return argument.split(argumentKey + "=")[1];
	}

	public static List<String> list(HRManager hrManager) {
		return hrManager.findAll().stream().map(Employee::toString).collect(Collectors.toList());

	}
}
