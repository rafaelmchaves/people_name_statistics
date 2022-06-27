package people.name;

import java.util.ArrayList;
import java.util.List;

public class NameModifier {

	/**
	 * Method responsible for modify names. It should only use first names and last names from the original N names.
	 * However, the new list and the old list should not share any full names.
	 * For example, if the file contains the names:
	 *
	 *     Brutananadilewski, Carl
	 *     Crews, Xander
	 *     Cartman, Eric
	 *     ... 22 more names if N=25 ...
	 *
	 *   Then this is a valid output:
	 *
	 *     Brutananadilewski, Eric
	 *     Crews, Carl
	 *     Cartman, Xander
	 *     ... 22 more names if N=25 ...
	 *
	 *   But this is not (because "Barney" and "Bambam" weren't in the original file):
	 *
	 *     Brutananadilewski, Fred
	 *     Crews, Barney
	 *     Cartman, Bambam
	 *     ... 22 more names if N=25 ...
	 *
	 *   This is also incorrect (because "Cartman, Eric" is unchanged):
	 *
	 *     Brutananadilewski, Xander
	 *     Crews, Carl
	 *     Cartman, Eric
	 *     ... 22 more names if N=25 ...
	 *
	 *   This is also incorrect (because "Carl" is used multiple times):
	 *
	 *     Brutananadilewski, Xander
	 *     Crews, Carl
	 *     Cartman, Carl
	 *     ... 22 more names if N=25 ...
	 *
	 * @param firstNFullNames
	 * @return list of modified names formatted
	 */
	public List<String> generate(List<Statistics.Name> firstNFullNames) {
		List<String> modifiedNames = new ArrayList<>();

		for (int i = 0; i <= firstNFullNames.size() - 2; i++) {
			final String firstName = firstNFullNames.get(i).getFirstName();
			final String lastName = firstNFullNames.get(i + 1).getLastName();
			modifiedNames.add(String.format("%s, %s", lastName, firstName));
		}
		modifiedNames.add( String.format("%s, %s", firstNFullNames.get(0).getLastName(), firstNFullNames.get(firstNFullNames.size() - 1).getFirstName()));

		return modifiedNames;
	}


}
