
package academy.learnprogramming.arrayslists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * brunolima on Feb 5, 2021
 * 
 */

public class Main {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee("Jane", "Jones", 123));
		employees.add(new Employee("John", "Doe", 4567));
		employees.add(new Employee("Mary", "Smith", 22));
		employees.add(new Employee("Mike", "Wilson", 323));

		employees.forEach(System.out::println);
		System.out.println();

		System.out.println(employees.get(1));
		System.out.println();

		System.out.println(employees.isEmpty());
		System.out.println();

		employees.set(1, new Employee("Bruno", "Lima", 7));
		employees.forEach(System.out::println);

		System.out.println(employees.size());
		System.out.println();

		employees.add(1, new Employee("John", "Doe", 4567));
		System.out.println();

		employees.forEach(System.out::println);
		System.out.println();

		Employee[] array = employees.toArray(new Employee[employees.size()]);
		Arrays.stream(array).forEach(employee -> System.out.println(employee));
		System.out.println();

		System.out.println(employees.contains(new Employee("Mary", "Smith", 22)));
		
		System.out.println(employees.indexOf(new Employee("John", "Doe", 4567)));
		
		employees.remove(2);
		
		employees.forEach(System.out::println);
		System.out.println();

	}

}
