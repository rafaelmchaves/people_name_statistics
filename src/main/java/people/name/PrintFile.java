package people.name;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintFile {

	public void printStatistics(StatisticsOutput statisticsOutput) throws IOException {

		FileWriter fileWriter = new FileWriter("statistics_output.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		printWriter.println("The names cardinality for full, last, and first names: ");
		printWriter.printf("Full names: %s", statisticsOutput.getFullNamesQuantity());
		printWriter.printf("\nLast names: %s", statisticsOutput.getLastNamesQuantity());
		printWriter.printf("\nFirst names: %s", statisticsOutput.getFirstNamesQuantity());
		printWriter.println();

		printWriter.println("\nThe most common last names are:");
		statisticsOutput.getCommonLastNames().forEach(printWriter::println);

		printWriter.println();
		printWriter.println("The most common first names are:");
		statisticsOutput.getCommonFirstNames().forEach(printWriter::println);

		printWriter.println();
		printWriter.println("Modified names are:");
		statisticsOutput.getModifiedNames().forEach(printWriter::println);

		printWriter.close();

	}
}
