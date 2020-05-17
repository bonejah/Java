package vanhack.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CountMeetings2 {

	/*
	 * Complete the 'countMeetings' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY arrival 2. INTEGER_ARRAY departure
	 */

	public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
		int sizeFirstDay = firstDay.size();
		int sizeLastDay = lastDay.size();

		if (sizeFirstDay != sizeLastDay) {
			return 0;
		}

		// Constraint: 1 <= n <= 100000
		if (sizeFirstDay <= 1 && sizeFirstDay > 100000) {
			return 0;
		}

		// Constraint: 1 <= n <= 100000
		if (sizeLastDay <= 1 && sizeLastDay > 100000) {
			return 0;
		}

		// Constraint: 1 <= firstDay[i], lastDay[i] <= 100000 (where 0 <= i < n)
		// Constraint: firstDay[i] <= lastDay[i] (where 0 <= i < n)

		List<Investor> investidores = new ArrayList<Investor>();
		List<Investor> investidoresAux = new ArrayList<Investor>();

		for (int i = 0; i < lastDay.size(); i++) {
			investidores.add(new Investor(firstDay.get(i), lastDay.get(i)));
		}
		
		List<Integer> agenda = new ArrayList<Integer>();

		for (int i = 0; i < investidores.size(); i++) {
			if (investidores.get(i).getBeginDay() == investidores.get(i).getEndDay()) {
				agenda.add(investidores.get(i).getEndDay());
			} else {
				investidoresAux.add(investidores.get(i));
			}
		}
		
		System.out.println("BEFORE agenda.size(): " + agenda.size());

		Collections.sort(agenda);

		for (int i = 0; i < investidoresAux.size(); i++) {

			if (Collections.binarySearch(agenda, investidoresAux.get(i).getBeginDay()) < 0) {
				agenda.add(investidoresAux.get(i).getBeginDay());
				continue;
			}

			if (Collections.binarySearch(agenda, investidoresAux.get(i).getEndDay()) < 0) {
				agenda.add(investidoresAux.get(i).getEndDay());
				continue;
			}
		}
		
		System.out.println("AFTER agenda.size(): " + agenda.size());

		return agenda.size();
	}

}

class Investor {

	private int beginDay;
	private int endDay;

	public Investor(Integer beginDay, Integer endDay) {
		this.beginDay = beginDay;
		this.endDay = endDay;
	}

	public int getBeginDay() {
		return beginDay;
	}

	public int getEndDay() {
		return endDay;
	}

	@Override
	public String toString() {
		return "Investor [beginDay=" + beginDay + ", endDay=" + endDay + "]";
	}
}

public class MeetupSchedule2 {

	public static void main(String[] args) throws IOException {
//		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 2, 3, 3, 3), Arrays.asList(2, 2, 3, 4, 4));
//		System.out.println("Resultado: " + resultado);

//		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 2));
//		System.out.println("Resultado: " + resultado);

//		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 2, 1, 2, 2), Arrays.asList(3, 2, 1, 3, 3));
//		System.out.println("Resultado: " + resultado);

		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 10, 11), Arrays.asList(11, 10, 11));
		System.out.println("Resultado: " + resultado);

	}
}
