package hackerhank;

import java.util.ArrayList;
import java.util.List;

public class TestStateOfCells {

	private static Integer ACTIVE = 1;
	private static Integer INACTIVE = 0;

	public static void main(String args[]) {
		int state[] = { 1, 0, 0, 0, 0, 1, 0, 0 };
		int numberOfDays = 1;
		
		List<Integer> list1 = cellCompete(state, numberOfDays);

		System.out.println("Printing list1");
		for (Integer value1 : list1) {
			System.out.print(value1 + " ");
		}

		System.out.println("\n");

		int state2[] = { 1, 1, 1, 0, 1, 1, 1, 1 };
		int numberOfDays2 = 2;

		List<Integer> list2 = cellCompete(state2, numberOfDays2);

		System.out.println("Printing list1");
		for (Integer value2 : list2) {
			System.out.print(value2 + " ");
		}
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static List<Integer> cellCompete(int[] states, int days) {
		List<Integer> statesAux = new ArrayList<Integer>(states.length);

		if (days == 0) {
			for (int value : states) {
				statesAux.add(Integer.valueOf(value));
			}
			return statesAux;
		}

		// RULES
		// IF PREVIOUS == INACTIVE AND NEXT == INACTIVE => CURRENTIDX = INACTIVE
		// IF PREVIOUS == ACTIVE AND NEXT == ACTIVE => CURRENTIDX = INACTIVE
		// IF PREVIOUS == INACTIVE AND NEXT == ACTIVE => CURRENTIDX = ACTIVE
		// IF PREVIOUS == ACTIVE AND NEXT == INACTIVE => CURRENTIDX = ACTIVE

		// CELL BEGIN AND END
		// IF PREVIOUS == INACTIVE AND NEXT == INACTIVE => CURRENTIDX = INACTIVE
		// IF PREVIOUS == ACTIVE AND NEXT == ACTIVE => CURRENTIDX = INACTIVE
		// IF PREVIOUS == INACTIVE AND NEXT == ACTIVE => CURRENTIDX = ACTIVE
		// IF PREVIOUS == ACTIVE AND NEXT == INACTIVE => CURRENTIDX = ACTIVE

		for (int i = 0; i < states.length; i++) {
			if (i == 0) {
				fillState(statesAux, INACTIVE, states[i + 1]);
				continue;
			}

			if (i == states.length - 1) {
				fillState(statesAux, states[i - 1], INACTIVE);
				continue;
			}

			int PREVIOUS = states[i - 1];
			int NEXT = states[i + 1] < states.length - 1 ? states[i + 1] : INACTIVE;
			fillState(statesAux, PREVIOUS, NEXT);
		}

		return cellCompete(statesAux.stream().mapToInt(i -> i).toArray(), --days);
	}

	private static void fillState(List<Integer> statesAux, int PREVIOUS, int NEXT) {
		if ((PREVIOUS == INACTIVE && NEXT == INACTIVE) || (PREVIOUS == ACTIVE && NEXT == ACTIVE)) {
			statesAux.add(INACTIVE);
		} else if ((NEXT == ACTIVE && PREVIOUS == INACTIVE) || (NEXT == INACTIVE && PREVIOUS == ACTIVE)) {
			statesAux.add(ACTIVE);
		}
	}

}