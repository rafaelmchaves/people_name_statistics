package people.name;

import java.util.List;

public class StatisticsOutput {

	private Integer fullNamesQuantity;

	private Integer lastNamesQuantity;

	private Integer FirstNamesQuantity;

	private List<String> commonLastNames;

	private List<String> commonFirstNames;

	private List<String> modifiedNames;

	public Integer getFullNamesQuantity() {
		return fullNamesQuantity;
	}

	public void setFullNamesQuantity(Integer fullNamesQuantity) {
		this.fullNamesQuantity = fullNamesQuantity;
	}

	public Integer getLastNamesQuantity() {
		return lastNamesQuantity;
	}

	public void setLastNamesQuantity(Integer lastNamesQuantity) {
		this.lastNamesQuantity = lastNamesQuantity;
	}

	public Integer getFirstNamesQuantity() {
		return FirstNamesQuantity;
	}

	public void setFirstNamesQuantity(Integer firstNamesQuantity) {
		FirstNamesQuantity = firstNamesQuantity;
	}

	public List<String> getCommonLastNames() {
		return commonLastNames;
	}

	public void setCommonLastNames(List<String> commonLastNames) {
		this.commonLastNames = commonLastNames;
	}

	public List<String> getCommonFirstNames() {
		return commonFirstNames;
	}

	public void setCommonFirstNames(List<String> commonFirstNames) {
		this.commonFirstNames = commonFirstNames;
	}

	public List<String> getModifiedNames() {
		return modifiedNames;
	}

	public void setModifiedNames(List<String> modifiedNames) {
		this.modifiedNames = modifiedNames;
	}
}
