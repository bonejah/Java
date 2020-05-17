package vanhack.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BusStandTest2 {

	public static void main(String[] args) {
//
		int capacidadeOnibus = 57;

		List<Integer> listaPassageiros = Arrays.asList(
				78, 26, 50,  5, 53, 72, 43, 12,  3, 44,
				11, 21,  4, 90, 64, 48, 32, 57, 51, 70,
				91, 14, 25, 61, 42, 54, 76, 21, 23, 95,
				 8, 60, 29, 70, 17, 89, 93, 63, 81, 30,
				64, 11, 88, 46, 81, 22, 19, 42, 90, 89, 
				54, 33, 81, 13, 90, 36, 32, 91, 12, 28, 
				23, 65, 43,  1, 82, 36, 87, 31,  1, 17, 
				52, 54, 42);

		List<Integer> listaTempoChegadaOnibus = Arrays.asList(49, 23, 70, 12, 27, 34, 25, 95, 17, 33, 22, 52, 56, 71,
				41, 37, 7, 98, 26, 97, 25, 26, 70, 50);

		List<Integer> result = ResultFinal.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
		System.out.println(result);

		// ***********************************************************************************************************

//		int capacidadeOnibus = 3;
//
//		List<Integer> listaPassageiros = Arrays.asList(2, 5, 3);
//
//		List<Integer> listaTempoChegadaOnibus = Arrays.asList(1, 5);
//
//		List<Integer> result = ResultFinal.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
//		System.out.println(result);

		// ***********************************************************************************************************

//		int capacidadeOnibus = 2;
//
//		List<Integer> listaPassageiros = Arrays.asList(1, 4, 4, 3, 1, 2, 6);
//
//		List<Integer> listaTempoChegadaOnibus = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//
//		List<Integer> result = ResultFinal.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
//		System.out.println(result);

		// ***********************************************************************************************************
//
//		int capacidadeOnibus = 2;
//
//		List<Integer> listaPassageiros = Arrays.asList(1, 2, 3, 4);
//
//		List<Integer> listaTempoChegadaOnibus = Arrays.asList(1, 3, 4);
//
//		List<Integer> result = ResultFinal.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
//		System.out.println(result);
	}

}

class ResultFinal {

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
        
        int valueLastPerson = persons.get(persons.size() - 1);
        int indexLastPerson = persons.size() - 1;
        
        for (int timeArriveBus : queries) {
        	
        	for (int i = 0; i < persons.size(); i++) {
        		if (persons.get(i) >= timeArriveBus) {
        			 lsBus.add(persons.get(i));
                     if ((lsBus.size() < capacity) && (i != indexLastPerson && persons.get(i) != valueLastPerson)) {
                         continue;
                     } else if ((lsBus.size() < capacity) &&  (i == indexLastPerson && persons.get(i) == valueLastPerson)) {
                         lsK.add(0);
                         lsBus = new LinkedList<Integer>(); 
                         break;
                     } else if (lsBus.size() >= capacity) {
                    	 lsK.add(i + 1);
                         lsBus = new LinkedList<Integer>(); 
                         break;
                     }
                 } else if (i == indexLastPerson && persons.get(i) == valueLastPerson) {	 
                     lsK.add(0);
                     lsBus = new LinkedList<Integer>(); 
                     break;
                 }
             }
        	 
        }

        return lsK;
    }
}
