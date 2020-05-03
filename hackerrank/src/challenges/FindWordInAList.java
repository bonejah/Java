package challenges;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindWordInAList {
	public static void main(String[] args) {

		topNCompetitors(6, 2, Arrays.asList("newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"),
				6,
				Arrays.asList("newshop is providing good services in the city", "everyone should use newshop",
						"best services by newshop", "fashionbeats has great services in the city",
						"I am proud to have fashionbeats", "mymarket has awesome services",
						"Thanks Newshop for the quick delivery"));
	}

	public static ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
			int numReviews, List<String> reviews) {
		// System.out.println(numCompetitors);
		// System.out.println(topNCompetitors);
		// System.out.println(competitors.toString());
		// System.out.println(numReviews);
		// System.out.println(reviews.toString());

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String competitor : competitors) {
			Integer count = map.get(competitor);

			for (String review : reviews) {
				if (review.contains(competitor)) {
					count = map.get(competitor);
					if (count != null) {
						map.put(competitor, count + 1);
					} else {
						map.put(competitor, 1);
					}
				}
			}
		}

		Map<String, Integer> sorted = map.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		ArrayList<String> biggest = new ArrayList<String>();

		for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
			if (entry.getValue() >= topNCompetitors) {
				biggest.add(entry.getKey());
			}
		}

		System.out.println(map);
		System.out.println(sorted);
		System.out.println(biggest);
		return biggest;
	}

}
