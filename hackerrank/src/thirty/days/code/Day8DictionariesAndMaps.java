package thirty.days.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8DictionariesAndMaps {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> lsPhones = new HashMap<>();

		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			lsPhones.put(name, phone);
		}

		while (in.hasNext()) {
			String s = in.next();
			if (lsPhones.get(s) == null) {
				System.out.println("Not found");
			} else {
				System.out.println(s + "=" + lsPhones.get(s));
			}
		}
		
		in.close();
	}

}
