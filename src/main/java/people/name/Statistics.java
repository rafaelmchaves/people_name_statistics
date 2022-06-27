package people.name;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {

	private static Statistics INSTANCE;

	private final Map<String, Integer> firstNameCount = new HashMap<>();

	private final Map<String, Integer> lastNameCount = new HashMap<>();

	private final Map<String, Integer> fullNameCount = new HashMap<>();

	private final List<Name> firstNFullNames = new ArrayList<>();

	private static final Integer N = 25;
	
	private final NameModifier nameModifier = new NameModifier();

	private Statistics() {
	}

	public synchronized static Statistics getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Statistics();
		}

		return INSTANCE;
	}

	/**
	 * Using firstNameCountMap, lastNameCountMap, fullNameCountMap to compute every name. If a first name,
	 * last name or a full name is repeated, we increment the count of the name.
	 *
	 * @param lastName
	 * @param firstNames
	 */
	public void generatesStatistics(String lastName, String firstNames) {

		final String fullName = String.format("%s, %s", lastName, firstNames);

		firstNameCount.put(firstNames, firstNameCount.getOrDefault(firstNames, 0) + 1);
		lastNameCount.put(lastName, lastNameCount.getOrDefault(lastName, 0) + 1);
		fullNameCount.put(fullName, fullNameCount.getOrDefault(fullName, 0) + 1);

		addNFullNames(lastName, firstNames);

	}

	/**
	 * Method that add all the first N full mames into firstNFullNames collection.
	 * Building a new list of N names by taking the first N names from the input file where the following is true:
	 *
	 *   . No previous name in the new list has the same first name.
	 *   . No previous name in the new list has the same last name.
	 *
	 * @return StatisticsOutput
	 */
	private void addNFullNames(String lastName, String firstName) {
		if (firstNFullNames.size() < N) {

			var hasNames = firstNFullNames.stream()
				.anyMatch(s -> s.firstName.equals(firstName) || s.lastName.equals(lastName));

			if(!hasNames) {
				var nameClass = new Name();
				nameClass.firstName = firstName;
				nameClass.lastName = lastName;
				firstNFullNames.add(nameClass);
			}
		}
	}

	/**
	 * Method that returns all processed statistics.
	 *
	 * @return StatisticsOutput
	 */
	public StatisticsOutput getStatistics() {

		StatisticsOutput statisticsOutput = new StatisticsOutput();
		statisticsOutput.setFirstNamesQuantity(firstNameCount.size());
		statisticsOutput.setLastNamesQuantity(lastNameCount.size());
		statisticsOutput.setFullNamesQuantity(fullNameCount.size());
		statisticsOutput.setCommonLastNames(getFirst10SortedValuesByMap(lastNameCount));
		statisticsOutput.setCommonFirstNames(getFirst10SortedValuesByMap(firstNameCount));
		statisticsOutput.setModifiedNames(nameModifier.generate(firstNFullNames));

		return statisticsOutput;

	}

	/**
	 * Method responsible for getting the data from the map, sorting the values
	 * in descending order and returning the 10 most used keys in the "key: value" format.
	 *
	 * @return string list.
	 * Example:
	 * Dayne: 3
	 * Alfonzo: 2
	 * etc
	 *
	* */
	private List<String> getFirst10SortedValuesByMap(Map<String, Integer> map) {
		return map.entrySet().stream()
			.sorted((o1, o2) ->o2.getValue().compareTo(o1.getValue()))
			.limit(10)
			.map(stringIntegerEntry ->stringIntegerEntry.getKey() + ": " +  stringIntegerEntry.getValue())
			.collect(Collectors.toList());
	}

	static class Name {

		private String firstName;
		private String lastName;

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}
}
