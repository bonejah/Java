package academy.learningprogramming.chainhashtable;

/**
 *
 * brunolima on Feb 9, 2021
 * 
 */

public class Main {

	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 323);

		ChainHashTable cht = new ChainHashTable();
		cht.put("Jones", janeJones);
		cht.put("Doe", johnDoe);
		cht.put("Wilson", mikeWilson);
		cht.put("Smith", marySmith);

		cht.printHashTable();

		System.out.println("Retrieve key Smith: " + cht.get("Smith"));

		cht.remove("Doe");
		cht.remove("Jones");
		
		cht.printHashTable();
//
//		System.out.println("Retrieve key Smith: " + cht.get("Smith"));
	}

}
