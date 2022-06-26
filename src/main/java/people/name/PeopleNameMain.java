package people.name;

public class PeopleNameMain {

	private final static Statistics statistics = Statistics.getInstance();

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		var fileProcessment = new FileProcessment();
		//TODO use the relative path
		fileProcessment.readFile("C:\\Users\\rafae\\neginet challenges\\people_name\\src\\main\\resources\\coding-test-data-large.txt");

		long processTime = System.nanoTime();
		System.out.println("processTime: " + ((processTime - startTime)/1000000 ));

		statistics.printStatistics();
		long endTime = System.nanoTime();
		System.out.println("endTime: " + ((endTime - startTime)/1000000 ));

	}
}
