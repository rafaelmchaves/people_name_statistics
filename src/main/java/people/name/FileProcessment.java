package people.name;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileProcessment { ;

	private final Statistics statistics = Statistics.getInstance();

	public void readFile (final String path) {
		try (FileInputStream inputStream = new FileInputStream(path); Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.matches("(.*), (.*) -- .*")) {
					//TODO open new threads?
					var arrayLine = line.split("--");
					statistics.generatesStatistics(arrayLine[0]);
				}

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}





}
