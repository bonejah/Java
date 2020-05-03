package challenges;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagrams {

	static boolean isAnagram(String a, String b) {
		// Complete the function
		Map<String, Integer> hashMap1 = new HashMap<String, Integer>();
		Map<String, Integer> hashMap2 = new HashMap<String, Integer>();

		fillMap(a, hashMap1);
		fillMap(b, hashMap2);
//		System.out.println(hashMap1);
//		System.out.println(hashMap2);

		if (hashMap1.size() != hashMap2.size()) {
			return false;
		}

		Map<String, Integer> hashMapSorted1 = comparingByKey(hashMap1);
		Map<String, Integer> hashMapSorted2 = comparingByKey(hashMap2);
//		System.out.println(hashMapSorted1);
//		System.out.println(hashMapSorted2);


		for (Map.Entry<String, Integer> entry : hashMapSorted1.entrySet()) {
			String key = entry.getKey();
			if (hashMapSorted1.get(key).intValue() != hashMapSorted2.get(key).intValue()) {
				return false;
			}
		}

		return true;
	}



	private static LinkedHashMap<String, Integer> comparingByValue(Map<String, Integer> hashMap) {
//		The example above not order by value		
//		Map<String, Integer> hashMapSorted0 = hashMap1.entrySet().stream()
//				.sorted(Map.Entry.<String, Integer>comparingByValue())
//				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		LinkedHashMap<String, Integer> hashMapSorted = hashMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return hashMapSorted;
	}



	private static LinkedHashMap<String, Integer> comparingByKey(Map<String, Integer> hashMap) {
//		The example above not order by key		
//		Map<String, Integer> hashMapSorted2 = hashMap1.entrySet().stream()
//				.sorted(Map.Entry.<String, Integer>comparingByKey())
//				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		
		LinkedHashMap<String, Integer> hashMapSorted = hashMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return hashMapSorted;
	}
	
	private static void fillMap(String a, Map<String, Integer> hashMap) {
		for (int i = 0; i <= a.length() - 1; i++) {
			String value = new String(new Character(a.charAt(i)).toString());

			if (hashMap.containsKey(value.toLowerCase())) {
				hashMap.put(value, hashMap.get(value.toLowerCase()).intValue() + 1);
			} else {
				hashMap.put(value.toLowerCase(), 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
