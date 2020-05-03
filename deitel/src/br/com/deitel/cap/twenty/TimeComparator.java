package br.com.deitel.cap.twenty;

import java.util.Comparator;

import br.com.deitel.cap.eight.Time2;

public class TimeComparator implements Comparator<Time2> {
	@Override
	public int compare(Time2 time1, Time2 time2) {
		int hourCompare = time1.getHour() - time2.getHour();

		if (hourCompare != 0)
			return hourCompare;

		int minuteCompare = time1.getMinute() - time2.getMinute();
		
		if (minuteCompare != 0)
			return minuteCompare;

		int secondCompare = time1.getSecond() - time2.getSecond();

		return secondCompare;
	}
}
