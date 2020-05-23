package vanhack;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

class Result1 {

	/*
	 * Complete the 'kthPerson' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER k 2. INTEGER_ARRAY p 3. INTEGER_ARRAY q
	 */

	public static List<Integer> kthPerson(int capacity, List<Integer> persons, List<Integer> queries) {
		if (capacity > 100000 || persons.size() <= 0) {
			return new ArrayList<Integer>();
		}

		if (persons.contains(100000) || queries.contains(100000)) {
			return new ArrayList<Integer>();
		}

		List<Integer> lsBus = new LinkedList<Integer>();
		List<Integer> lsK = new LinkedList<Integer>();
		
		int indexLastPerson = persons.size() - 1;

		for (int timeArriveBus : queries) {
			for (int i = 0; i < persons.size(); i++) {
				if (persons.get(i) >= timeArriveBus) {
					lsBus.add(persons.get(i));

					if ((lsBus.size() < capacity) && (i != indexLastPerson)) {
						continue;
					} else if ((lsBus.size() < capacity) && (i == indexLastPerson)) {
						lsK.add(0);
						lsBus = new LinkedList<Integer>();
						break;
					} else if (lsBus.size() >= capacity) {
						lsK.add(i + 1);
						lsBus = new LinkedList<Integer>();
						break;
					}
				} else if (i == indexLastPerson) {
					lsK.add(0);
					lsBus = new LinkedList<Integer>();
					break;
				}
			}
		}

		return lsK;
	}
}

public class BusStand {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		int pCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> p = IntStream.range(0, pCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int qCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> q = IntStream.range(0, qCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = Result1.kthPerson(k, p, q);
		System.out.println("Result: " + result);

//		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");
		bufferedReader.close();
//		bufferedWriter.close();
	}
}
