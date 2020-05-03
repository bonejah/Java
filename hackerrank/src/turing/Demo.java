package turing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Demo {

	public static void main(String[] args) {
		List<String> countries = Arrays.asList("Germany", "England", "China", "Denamark", "Brazil", "France",
				"Australia");
		
		Optional<String> countriName = countries.stream().reduce((c1, c2) -> c1.length() > c2.length() ? c1 : c2);
		countriName.ifPresent(System.out::println);

		
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		System.out.println(treeSet);
		
		String a = "abc";
		String b = "abc";
		a.concat(b);
		System.out.println(a);
		
		
	}

}
