package vanhack.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BusStandTest1 {

	public static void main(String[] args) {

		int capacidadeOnibus = 57;

		List<Integer> listaPassageiros = Arrays.asList(78, 26, 50, 5, 53, 72, 43, 12, 3, 44, 11, 21, 4, 90, 64, 48, 32,
				57, 51, 70, 91, 14, 25, 61, 42, 54, 76, 21, 23, 95, 8, 60, 29, 70, 17, 89, 93, 63, 81, 30, 64, 11, 88,
				46, 81, 22, 19, 42, 90, 89, 54, 33, 81, 13, 90, 36, 32, 91, 12, 28, 23, 65, 43, 1, 82, 36, 87, 31, 1,
				17, 52, 54, 42);

		List<Integer> listaTempoChegadaOnibus = Arrays.asList(49, 23, 70, 12, 27, 34, 25, 95, 17, 33, 22, 52, 56, 71,
				41, 37, 7, 98, 26, 97, 25, 26, 70, 50);

		List<Integer> result = Result.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
		System.out.println(result);

		// ***********************************************************************************************************

//		int capacidadeOnibus = 3;
//
//		List<Integer> listaPassageiros = Arrays.asList(2, 5, 3);
//
//		List<Integer> listaTempoChegadaOnibus = Arrays.asList(1, 5);
//
//		List<Integer> result = Result.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
//		System.out.println(result);

		// ***********************************************************************************************************
		
//		int capacidadeOnibus = 2;
//
//		List<Integer> listaPassageiros = Arrays.asList(1, 4, 4, 3, 1, 2, 6);
//
//		List<Integer> listaTempoChegadaOnibus = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//
//		List<Integer> result = Result.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
//		System.out.println(result);
		
		// ***********************************************************************************************************
//
//		int capacidadeOnibus = 2;
//
//		List<Integer> listaPassageiros = Arrays.asList(1, 2, 3, 4);
//
//		List<Integer> listaTempoChegadaOnibus = Arrays.asList(1, 3, 4);
//
//		List<Integer> result = Result.kthPerson(capacidadeOnibus, listaPassageiros, listaTempoChegadaOnibus);
//		System.out.println(result);
	}

}

class Result {

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

        List<PersonQueue> lsQueueForBus = new ArrayList<PersonQueue>();
        List<PersonQueue> lsBus = new LinkedList<PersonQueue>();

        List<Integer> lsK = new LinkedList<Integer>();

        createQueueForBus(persons, lsQueueForBus);
        
        int lastPerson = lsQueueForBus.get(lsQueueForBus.size() - 1).getIndex();
        
        for (int timeArriveBus : queries) {
             
             for (int i = 0; i < lsQueueForBus.size(); i++) {
                 if (lsQueueForBus.get(i).getPatience() >= timeArriveBus) {
                     lsBus.add(lsQueueForBus.get(i));
                     if ((lsBus.size() < capacity) && (lsQueueForBus.get(i).getIndex() != lastPerson)) {
                         continue;
                     } else if ((lsBus.size() < capacity) && (lsQueueForBus.get(i).getIndex() == lastPerson)) {
                         lsK.add(0);
                         lsBus = new LinkedList<PersonQueue>(); 
                         break;
                     } else if (lsBus.size() >= capacity) {
                         lsK.add(lsBus.get(lsBus.size() - 1).getIndex() + 1);
                         lsBus = new LinkedList<PersonQueue>(); 
                         break;
                     }
                 } else if (lsQueueForBus.get(i).getIndex() == lastPerson) {     
                     lsK.add(0);
                     lsBus = new LinkedList<PersonQueue>(); 
                     break;
                 }
             }
             
        }

        return lsK;
    }

    private static void createQueueForBus(List<Integer> persons, List<PersonQueue> lsPersonOnQueue) {
        for (int i = 0; i < persons.size(); i++) {
            lsPersonOnQueue.add(new PersonQueue(i, persons.get(i)));
        }    
    }
}

class PersonQueue {

    private int index;
    private int patience;

    public PersonQueue(int index, int patience) {
        this.index = index;
        this.patience = patience;
    }

    public int getIndex() {
        return index;
    }

    public int getPatience() {
        return patience;
    }
}
