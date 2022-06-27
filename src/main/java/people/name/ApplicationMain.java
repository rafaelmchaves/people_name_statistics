package people.name;

import java.io.IOException;

public class ApplicationMain {
	private static final Statistics statistics = Statistics.getInstance();
	private static final PrintFile printFile = new PrintFile();

	public ApplicationMain() {
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();

		FileProcessor fileProcessment = new FileProcessor();
		fileProcessment.readFile("C:\\Users\\rafae\\neginet challenges\\people_name\\src\\main\\resources\\coding-test-data.txt");

		StatisticsOutput statisticsOutput = statistics.getStatistics();

		printFile.printStatistics(statisticsOutput);

		long endTime = System.nanoTime();
		System.out.println("endTime: " + (endTime - startTime) / 1000000L);
	}
}
