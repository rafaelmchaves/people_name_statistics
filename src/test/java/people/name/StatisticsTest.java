package people.name;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

	private final Statistics statistics = Statistics.getInstance();

	@Test
	public void getStatistics_insertManyData_returnStatistics() {

		generateStatistics();

		var statisticsOutput = statistics.getStatistics();

		assertAll(() -> {
			assertEquals(20, statisticsOutput.getFullNamesQuantity());
			assertEquals(17, statisticsOutput.getLastNamesQuantity());
			assertEquals(16, statisticsOutput.getFirstNamesQuantity());

			assertEquals("Mariah: 3", statisticsOutput.getCommonFirstNames().get(0));
			assertEquals("Anita: 2", statisticsOutput.getCommonFirstNames().get(1));
			assertEquals("Mckenna: 2", statisticsOutput.getCommonFirstNames().get(2));
			assertEquals("Matilde: 2", statisticsOutput.getCommonFirstNames().get(3));
			assertEquals("Garfield: 1", statisticsOutput.getCommonFirstNames().get(4));
			assertEquals("Ryley: 1", statisticsOutput.getCommonFirstNames().get(5));
			assertEquals("Berry: 1", statisticsOutput.getCommonFirstNames().get(6));
			assertEquals("Nikko: 1", statisticsOutput.getCommonFirstNames().get(7));
			assertEquals("Elmo: 1", statisticsOutput.getCommonFirstNames().get(8));
			assertEquals("Agustina: 1", statisticsOutput.getCommonFirstNames().get(9));

			assertEquals("Stanton: 4", statisticsOutput.getCommonLastNames().get(0));
			assertEquals("Graham: 2", statisticsOutput.getCommonLastNames().get(1));
			assertEquals("McLaughlin: 1", statisticsOutput.getCommonLastNames().get(2));
			assertEquals("Tromp: 1", statisticsOutput.getCommonLastNames().get(3));
			assertEquals("Cartwright: 1", statisticsOutput.getCommonLastNames().get(4));
			assertEquals("Rogahn: 1", statisticsOutput.getCommonLastNames().get(5));
			assertEquals("Adams: 1", statisticsOutput.getCommonLastNames().get(6));
			assertEquals("Runolfsdottir: 1", statisticsOutput.getCommonLastNames().get(7));
			assertEquals("Lang: 1", statisticsOutput.getCommonLastNames().get(8));
			assertEquals("Koch: 1", statisticsOutput.getCommonLastNames().get(9));

		});
	}

	private void generateStatistics() {
		statistics.generatesStatistics("Graham", "Mckenna");
		statistics.generatesStatistics("Marvin", "Garfield");
		statistics.generatesStatistics("McLaughlin", "Mariah");
		statistics.generatesStatistics("Lang", "Agustina");
		statistics.generatesStatistics("Bradtke", "Nikko");
		statistics.generatesStatistics("Adams", "Luis");
		statistics.generatesStatistics("Lehner", "Matilde");
		statistics.generatesStatistics("Ortiz", "Anita");
		statistics.generatesStatistics("Koch", "Anita");
		statistics.generatesStatistics("Cartwright", "Nicolas");
		statistics.generatesStatistics("Fisher", "Elmo");
		statistics.generatesStatistics("Kunze", "Mariah");
		statistics.generatesStatistics("Stanton", "Davin");
		statistics.generatesStatistics("Runolfsdottir", "Roy");
		statistics.generatesStatistics("Rogahn", "Colby");
		statistics.generatesStatistics("Tromp", "Ryley");
		statistics.generatesStatistics("Stanton", "Berry");
		statistics.generatesStatistics("Stanton", "Mariah");
		statistics.generatesStatistics("Hoppe", "Dayne");
		statistics.generatesStatistics("Stanton", "Matilde");
		statistics.generatesStatistics("Graham", "Mckenna");
	}

}
