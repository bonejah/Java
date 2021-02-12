package academy.learningprogramming.chainhashtable;

import java.util.LinkedList;
import java.util.ListIterator;

/**
*
* brunolima on Feb 11, 2021
* 
*/

public class ChainHashTable {
	
	private LinkedList<StoredEmployee>[] hashtable;
	
	@SuppressWarnings("unchecked")
	public ChainHashTable() {
		hashtable = new LinkedList[10];
		
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<>();
		}
	}
	
	public void put(String key, Employee employee) {
		int hashKey = hashKey(key);
		
		hashtable[hashKey].add(new StoredEmployee(key, employee));
	}

	public Employee get(String key) {
		int hashKey = hashKey(key);
		
		ListIterator<StoredEmployee> listIterator = hashtable[hashKey].listIterator();
		
		StoredEmployee employee = null;
		
		while(listIterator.hasNext()) {
			employee = listIterator.next();
			
			if (employee.key.equals(key)) {
				return employee.employee;
			}
		}
		
		return null;
	}
	
	public Employee remove(String key) {
	int hashKey = hashKey(key);
		
		ListIterator<StoredEmployee> listIterator = hashtable[hashKey].listIterator();
		
		StoredEmployee employee = null;
		
		int index = -1;
		
		while(listIterator.hasNext()) {
			employee = listIterator.next();
			index++;
			
			if (employee.key.equals(key)) {
				break;
			}
		}
		
		if (employee == null || !employee.key.equals(key)) {
			return null;
		} else {
//			hashtable[hashKey].remove(employee);
			hashtable[hashKey].remove(index);
			return employee.employee;
		}
		
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	public void printHashTable() {
		for (int i = 0; i < hashtable.length; i++) {
			
			if (hashtable[i].isEmpty()) {
				System.out.println("Position " + i + ": empty");
			} else {
				System.out.print("Position " + i + ": ");
				ListIterator<StoredEmployee> listIterator = hashtable[i].listIterator();
				
				while(listIterator.hasNext()) {
					System.out.print(listIterator.next().employee);
					System.out.print("->");
				}
				System.out.println("null");
			}
		}
		
		
	}
}

