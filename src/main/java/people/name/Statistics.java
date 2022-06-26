package people.name;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {

	private static Statistics INSTANCE;

	//TODO maybe a concurrent hash map here
	private final Map<String, Integer> firstNameCount = new HashMap<>();

	private final Map<String, Integer> lastNameCount = new HashMap<>();
	private final Map<String, Integer> fullNameCount = new HashMap<>();

	private final List<Name> firstNFullNames = new ArrayList<>();

	private static final Integer N = 25;

	private Statistics() {
	}

	public synchronized static Statistics getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Statistics();
		}

		return INSTANCE;
	}

	public void generatesStatistics(String fullName) {

		//TODO ignore punctuation, dashes, quotes,
		var nameArray = fullName.split(",");
		var lastName = nameArray[0];
		var firstName = nameArray[1];
		firstNameCount.put(firstName, firstNameCount.getOrDefault(firstName, 0) + 1);
		lastNameCount.put(lastName, lastNameCount.getOrDefault(lastName, 0) + 1);
		fullNameCount.put(fullName, fullNameCount.getOrDefault(fullName, 0) + 1);

		addNFullNames(fullName, lastName, firstName);

	}

	private void addNFullNames(String fullName, String lastName, String firstName) {
		if (firstNFullNames.size() < N) {

			var hasNames = firstNFullNames.stream()
				.anyMatch(s -> s.firstName.equals(firstName) && s.lastName.equals(firstName));

			if(!hasNames) {
				var nameClass = new Name();
				nameClass.firstName = firstName;
				nameClass.lastName = lastName;
				nameClass.fullName = fullName;
				firstNFullNames.add(nameClass);
			}
		}
	}

	public void printStatistics() {

		//TODO print the statitiscs in a file
		System.out.println("The names cardinality for full, last, and first names:");
		System.out.println("Full names: " + fullNameCount.size());
		System.out.println("Last names: " + lastNameCount.size());
		System.out.println("First names: " + firstNameCount.size());

		System.out.println("The most common last names are:");
		sortMap(lastNameCount).forEach(System.out::println);

		System.out.println("The most common first names are:");
		sortMap(firstNameCount).forEach(System.out::println);

//		System.out.println("\n first N full names are:");
//		firstNFullNames.forEach(n -> System.out.println(n.fullName));

		System.out.println("\n Modified names are:");
		generateModifiedNames().forEach(System.out::println);

	}

	public void getStatistics() {

	}

	private List<String> generateModifiedNames() {
		List<String> modifiedNames = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			final String firstName = firstNFullNames.get(i).firstName;
			final String lastName = firstNFullNames.get(i + 1).lastName;
			modifiedNames.add(lastName + ", " + firstName);
		}
		modifiedNames.add(firstNFullNames.get(0).lastName + ", " + firstNFullNames.get(N-1).firstName);

		return modifiedNames;
	}

	private List<String> sortMap(Map<String, Integer> map) {
		return map.entrySet().stream()
			.sorted((o1, o2) ->o2.getValue().compareTo(o1.getValue()))
			.limit(10)
			.map(stringIntegerEntry ->stringIntegerEntry.getKey() + ": " +  stringIntegerEntry.getValue())
			.collect(Collectors.toList());
	}

	static class Name {

		private String firstName;
		private String lastName;
		private String fullName;
	}
}
