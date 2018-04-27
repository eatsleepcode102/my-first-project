package howto.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileTreeFilter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("C:\\Users\\synergix17\\Downloads");
		List<Path> files = Files.walk(path).filter(Files::isReadable).filter(Files::isRegularFile).limit(10)
				.collect(Collectors.toList());
		System.out.println(files);
	}
}
