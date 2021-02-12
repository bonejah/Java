package academy.learningprogramming.hashtable;

/**
*
* brunolima on Feb 9, 2021
* 
*/

public class StoredEmployee {

	public String key;
	public Employee employee;
	
	public StoredEmployee(String key, Employee employee) {
		this.key = key;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "StoredEmployee [key=" + key + ", employee=" + employee + "]";
	}
	
}

