package people.name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NameModifierTest {

	private NameModifier nameModifier;

	@Test
	public void generate_5Names_return5ModifiedNames() {

		nameModifier = new NameModifier();

		List<Statistics.Name> firstNFullNames = new ArrayList<>();

		firstNFullNames.add(creatingNames("Graham", "Mckenna"));
		firstNFullNames.add(creatingNames("Marvin", "Garfield"));
		firstNFullNames.add(creatingNames("McLaughlin", "Mariah"));
		firstNFullNames.add(creatingNames("Lang", "Agustina"));
		firstNFullNames.add(creatingNames("BradtkeNikko", "Nikko"));

		var result = nameModifier.generate(firstNFullNames);

		Assertions.assertAll(() -> {
			Assertions.assertEquals("Marvin, Mckenna", result.get(0));
			Assertions.assertEquals("McLaughlin, Garfield", result.get(1));
			Assertions.assertEquals("Lang, Mariah", result.get(2));
			Assertions.assertEquals("BradtkeNikko, Agustina", result.get(3));
			Assertions.assertEquals("Graham, Nikko", result.get(4));
		});
	}

	@Test
	public void generate_1name_return0ModifiedNames() {

		nameModifier = new NameModifier();

		List<Statistics.Name> firstNFullNames = new ArrayList<>();

		firstNFullNames.add(creatingNames("Graham", "Mckenna"));

		var result = nameModifier.generate(firstNFullNames);

		Assertions.assertAll(() -> {
			Assertions.assertEquals("Graham, Mckenna", result.get(0));
		});
	}

	@Test
	public void generate_2name_return2ModifiedNames() {

		nameModifier = new NameModifier();

		List<Statistics.Name> firstNFullNames = new ArrayList<>();

		firstNFullNames.add(creatingNames("Graham", "Mckenna"));
		firstNFullNames.add(creatingNames("Marvin", "Garfield"));


		var result = nameModifier.generate(firstNFullNames);

		Assertions.assertAll(() -> {
			Assertions.assertEquals("Marvin, Mckenna", result.get(0));
			Assertions.assertEquals("Graham, Garfield", result.get(1));
		});
	}

	public Statistics.Name creatingNames(String lastName, String firstName) {

		Statistics.Name name = new Statistics.Name();

		name.setFirstName(firstName);
		name.setLastName(lastName);

		return name;
	}


}
