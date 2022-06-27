package people.name;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileProcessor {

	private final Statistics statistics = Statistics.getInstance();

	private final Pattern pattern = Pattern.compile("([a-zA-Z]*), ([a-zA-Z]*) -- .*");

	/**
	 * Method that reads a file following this template:
	 *
	 *  Smith, Joan -- corporis
	 *         Totam eos ut omnis et nemo dolore.
	 *     Smith, Sam -- ut
	 *         Ut dolorem est voluptate fugit qui vitae.
	 *     Thomas, Joan -- modi
	 *         Nesciunt magni suscipit maxime quaerat sint hic voluptate.
	 *     Upton, Joan -- veritatis
	 *         Sed ut impedit harum.
	 *     Cartman, Eric -- tenetur
	 *         Esse amet adipisicing commodo labore.
	 *     O'Shea, Peter
	 *
	 * The statistics will be generated only if the following pattern is true : lastName, firstName -- random text
	 *
	 * @param path
	 */
	public void readFile (final String path) {

		try (FileInputStream inputStream = new FileInputStream(path); Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				var matcher = pattern.matcher(line);
				if (matcher.matches()) {
					statistics.generatesStatistics(matcher.group(1), matcher.group(2));
				}

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
