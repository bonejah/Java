package academy.learningprogramming.hashtable;



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
		Employee brunoLima = new Employee("Bruno", "Lima", 7);
		
		SimpleHashTable sht = new SimpleHashTable();
		sht.put("Jones", janeJones);
		sht.put("Doe", johnDoe);
		sht.put("Smith", marySmith);
		sht.put("Wilson", mikeWilson);
		sht.put("Lima", brunoLima);
		
		sht.printHashTable();
		
		System.out.println("Retrieve key Wilson: " + sht.get("Wilson  "));
		
	}

}

