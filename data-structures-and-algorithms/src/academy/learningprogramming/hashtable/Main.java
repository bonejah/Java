package academy.learningprogramming.hashtable;



/**
*
* brunolima on Feb 9, 2021
* 
* Hash Tables
* 
* - Abstract data type 
* 
* - Provide access to data using keys
* 
* - Key doesn't have to be an integer
* 
* - Consist of key/value pairs - data types don't have to match
* 
* - Optimized for retrieval (when you know the key)
* 
* - Associative array is one type of hash table
* 
* Hashing 
* 
* - Maps keys of any data type to an integer
* 
* - Hash function maps keys to int
* 
* - In Java, hash functions is Object.hashCode()
* 
* - Collision occurs when more than one value has the same hashed value
* 
*/

public class Main {
	
	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 323);
		
		SimpleHashTable sht = new SimpleHashTable();
		sht.put("Jones", janeJones);
		sht.put("Doe", johnDoe);
		sht.put("Smith", marySmith);
		sht.put("Wilson", mikeWilson);
		sht.printHashTable();
		
		System.out.println("Retrieve key Wilson: " + sht.get("Wilson"));
		System.out.println("Retrieve key Smith: " + sht.get("Smith"));
		
		sht.remove("Wilson");
		sht.remove("Jones");
		sht.printHashTable();
		
		System.out.println("Retrieve key Smith: " + sht.get("Smith"));
	}

}

