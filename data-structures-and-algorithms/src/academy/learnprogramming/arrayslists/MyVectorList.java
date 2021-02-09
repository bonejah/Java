package academy.learnprogramming.arrayslists;

import java.util.List;
import java.util.Vector;

/**
 *
 * brunolima on Feb 5, 2021
 * 
 */

public class MyVectorList {

	public static void main(String[] args) {
		List<Employee> employees = new Vector<>();

		employees.add(new Employee("Jane", "Jones", 123));
		employees.add(new Employee("John", "Doe", 4567));
		employees.add(new Employee("Mary", "Smith", 22));
		employees.add(new Employee("Mike", "Wilson", 323));

		
	}

}
