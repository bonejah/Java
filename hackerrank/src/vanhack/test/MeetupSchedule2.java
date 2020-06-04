package vanhack.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

        List<Investor2> investidores = new ArrayList<Investor2>();
        List<Investor2> agendaAux = new ArrayList<Investor2>();

        for (int i = 0; i < lastDay.size(); i++) {
            if (firstDay.get(i) <= lastDay.get(i)) {
                investidores.add(new Investor2(firstDay.get(i), lastDay.get(i)));
            }
        }
        System.out.println("QTDE Investidores: " + investidores.size());

        Set<Investor2> agenda = new HashSet<Investor2>();

        for (Investor2 investor : investidores) {
            if (investor.getBeginDay() == investor.getEndDay()) {
                agenda.add(investor);
            } else {
                agendaAux.add(investor);
            } 
        }
        System.out.println("QTDE Investidores JAH Agendados1: " + agenda.size());
        System.out.println("QTDE Investidores NAO Agendados1: " + agendaAux.size());
 
   
        List<Investor2> agendaAux2 = new ArrayList<Investor2>(agendaAux);
        System.out.println("QTDE Investidores agendaAux2: " + agendaAux2.size());
        
        
        for (int i = 0; i < agendaAux2.size(); i++) {
        	if (!agenda.contains(agendaAux2.get(i).getBeginDay())) {
                agenda.add(agendaAux2.get(i));
                agendaAux.remove(agendaAux2.get(i));
            } else if (!agenda.contains(agendaAux2.get(i).getEndDay())) {
                agenda.add(agendaAux2.get(i));
                agendaAux.remove(agendaAux2.get(i));
            } 
		}
  
        System.out.println("QTDE Investidores JAH Agendados2: " + agenda.size());
        System.out.println("QTDE Investidores NAO Agendados2: " + agendaAux.size());

        if (!agendaAux.isEmpty()) {
        	for (int i = 0; i < agendaAux.size(); i++) {
            	if (!agenda.contains(agendaAux.get(i))) {
                    agenda.add(agendaAux.get(i));
                } else if (!agenda.contains(agendaAux.get(i))) {
                    agenda.add(agendaAux.get(i));
                } 
    		}
        }
        
        System.out.println("QTDE Investidores JAH Agendados3: " + agenda.size());
        System.out.println("QTDE Investidores QUE sobraram3: " + agendaAux.size());
        System.out.println(agenda.contains(new Investor2(62873, 88533)));
        return agenda.size();
    }
	

}

class Investor2 {

	private int id;
	private int beginDay;
	private int endDay;

	private static int valueId = 1;

	public Investor2(Integer beginDay, Integer endDay) {
		this.id = valueId;
		this.beginDay = beginDay;
		this.endDay = endDay;
		valueId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBeginDay() {
		return beginDay;
	}

	public int getEndDay() {
		return endDay;
	}

	@Override
	public String toString() {
//		return "Investor2 [id=" + id + ", beginDay=" + beginDay + ", endDay=" + endDay + "]";
		return "Investor2 [beginDay=" + beginDay + ", endDay=" + endDay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beginDay;
		result = prime * result + endDay;
//		result = prime * result + id;
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
		if (beginDay != other.beginDay)
			return false;
		if (endDay != other.endDay)
			return false;
//		if (id != other.id)
//			return false;
		return true;
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
