package vanhack;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class CountMeetings {

	/*
	 * Complete the 'countMeetings' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY arrival 2. INTEGER_ARRAY departure
	 */

	public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
		int maxMeetingPerDay = 1;
		int n = firstDay.size();
		
		meeting(maxMeetingPerDay, lastDay, firstDay, n);
        
        return 0;
    }

	private static int meeting(int maxMeetingPerDay, List<Integer> lastDay, List<Integer> firstDay, int n) {
		
		// Base Case 0
		if (maxMeetingPerDay == 0  || n == 0) {
			return 0;
		}
		
		// Return the maximum of two cases: 
        // (1) nth item included 
        // (2) not included	
		if (lastDay.get(n - 1) > maxMeetingPerDay) {
			return meeting(maxMeetingPerDay, lastDay, firstDay, n - 1);
		} else {
			return maxMeeting(firstDay.get(n -1) + meeting(maxMeetingPerDay - lastDay.get(n - 1),
					lastDay, firstDay, n - 1), meeting(maxMeetingPerDay, lastDay, firstDay, n - 1));
		}

	}

	// A utility function that returns maximum of two integers 
	private static int maxMeeting(int i, int meeting) {
		return i > meeting ? i : meeting;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beginDay;
		result = prime * result + endDay;
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
		Investor other = (Investor) obj;
		if (beginDay != other.beginDay)
			return false;
		if (endDay != other.endDay)
			return false;
		return true;
	}
}

public class MeetupSchedule {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arrival = IntStream.range(0, arrivalCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int departureCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> departure = IntStream.range(0, departureCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = CountMeetings.countMeetings(arrival, departure);
		System.out.println(result);
		
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();
	}
}
