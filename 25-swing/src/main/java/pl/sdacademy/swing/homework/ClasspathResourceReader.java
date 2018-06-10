package pl.sdacademy.swing.homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A simple strategy to read classpath resources.
 */
class ClasspathResourceReader {
	/**
	 * Returns an ordered stream containing lines of the given text file.
	 *
	 * @param filePath a relative path to the text file inside the classpath
	 * @return the stream containing ordered lines of the text file
	 */
	Stream<String> readAllLines(Path filePath) {
		// TODO: implement according to the test specification and javadoc
		InputStream resourceAsStream = getClass().getResourceAsStream("/" + filePath.toString());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
		return bufferedReader.lines();

	}
	}

