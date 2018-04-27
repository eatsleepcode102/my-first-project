package howto.lambda;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OutputDirectory {
	public static void main(String[] args) {
		final String dir = "C:\\Users\\synergix17\\Downloads";
		final Path path = Paths.get(dir);
		final File file = path.toFile();
		Stream.of(file.listFiles(File::isDirectory)).forEach(System.out::println);;;
	}
}
