package vanhack.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

		List<Investor2> lsInvestidores = new ArrayList<Investor2>();
		for (int i = 0; i < lastDay.size(); i++) {
			if (firstDay.get(i) <= lastDay.get(i)) {
				lsInvestidores.add(new Investor2(firstDay.get(i), lastDay.get(i)));
			}
		}

		for (Investor2 investor : lsInvestidores) {
			System.out.println(investor);
		}

		Set<Integer> agenda = new TreeSet<Integer>();

		List<Investor2> lsInvestidoresAux = new ArrayList<Investor2>(lsInvestidores);
		for (Investor2 investor : lsInvestidoresAux) {
			if (investor.getBeginDay() == investor.getEndDay()) {
				agenda.add(investor.getBeginDay());
				lsInvestidores.remove(investor);
			}
		}

		System.out.println("============");
		for (Integer diaAgendado : agenda) {
			System.out.println(diaAgendado);
		}

		System.out.println("============");
		for (Investor2 investor : lsInvestidores) {
			System.out.println(investor);
		}

		for (int i = 0; i < lsInvestidores.size(); i++) {
			Investor2 investidor = lsInvestidores.get(i);
			
			for (Integer diaAgendado : agenda) {
				if (!diaAgendado.equals(investidor.getBeginDay())) {
					agenda.add(investidor.getBeginDay());
					lsInvestidores.remove(investidor);
					break;
				} else if (!diaAgendado.equals(investidor.getEndDay())) {
					agenda.add(investidor.getEndDay());
					lsInvestidores.remove(investidor);
					break;
				}
			}
		}
		
		System.out.println("============");
		for (Integer diaAgendado : agenda) {
			System.out.println(diaAgendado);
		}
		

		return agenda.size();
	}

}

class Investor2 implements Comparable<Investor2>{

	private Integer beginDay;
	private Integer endDay;
	
	public Investor2(Integer beginDay, Integer endDay) {
		this.beginDay = beginDay;
		this.endDay = endDay;
	}

	public Integer getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Integer beginDay) {
		this.beginDay = beginDay;
	}

	public Integer getEndDay() {
		return endDay;
	}

	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginDay == null) ? 0 : beginDay.hashCode());
		result = prime * result + ((endDay == null) ? 0 : endDay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investor2 other = (Investor2) obj;
		if (beginDay == null) {
			if (other.beginDay != null)
				return false;
		} else if (!beginDay.equals(other.beginDay))
			return false;
		if (endDay == null) {
			if (other.endDay != null)
				return false;
		} else if (!endDay.equals(other.endDay))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Investor2 [beginDay=" + beginDay + ", endDay=" + endDay + "]";
	}

	@Override
	public int compareTo(Investor2 o) {
		if (this.getBeginDay() > o.getBeginDay() && this.getEndDay() > o.getEndDay()) {
			return 1;
		} else if (this.getBeginDay() < o.getBeginDay() && this.getEndDay() < o.getEndDay()) {
			return -1;
		} else if (this.getBeginDay().equals(o.getBeginDay()) && this.getEndDay().equals(o.getEndDay())) {
			return 0;
		} else {
			return 0;
		}
		
	}

}

public class MeetupSchedule2 {

	public static void main(String[] args) throws IOException {
//		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 2, 3, 3, 3), Arrays.asList(2, 2, 3, 4, 4));
//		System.out.println("Resultado: " + resultado);

//		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 1, 2), Arrays.asList(1, 2, 2));
//		System.out.println("Resultado: " + resultado);

		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 2, 1, 2, 2), Arrays.asList(3, 2, 1, 3, 3));
		System.out.println("Resultado: " + resultado);

//		int resultado = CountMeetings2.countMeetings(Arrays.asList(1, 10, 11), Arrays.asList(11, 10, 11));
//		System.out.println("Resultado: " + resultado);

	}
}
