package academy.learningprogramming.hashtablesJDK;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
*
* brunolima on Feb 11, 2021
* 
*/

public class Main {
	
	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
			
		Map<String, Employee> hashMap = new HashMap<String, Employee>();
		hashMap.put("Jones", janeJones);
		hashMap.put("Doe", johnDoe);
		hashMap.put("Smith", marySmith);
		hashMap.put("Wilson", mikeWilson);
		
		Iterator<Employee> iterator = hashMap.values().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
		
		System.out.println(hashMap.containsKey("Doe"));
		System.out.println(hashMap.containsValue(janeJones));
		
		Employee employee = hashMap.putIfAbsent("Doe", johnDoe);
		System.out.println(employee);
	}

}

