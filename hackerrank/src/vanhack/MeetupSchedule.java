package vanhack;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int sizeFirstDay = firstDay.size();
        int sizeLastDay = lastDay.size();

        if (sizeFirstDay != sizeLastDay) {
            return 0;
        }

        // Constraint: 1 <= n <= 100000
        if (sizeFirstDay <= 1 && 100000 >= sizeFirstDay) {
            return 0;
        }

        // Constraint: 1 <= n <= 100000
        if (sizeLastDay <= 1 && 100000 >= sizeLastDay) {
            return 0;
        }

        // Constraint: 1 <= firstDay[i], lastDay[i] <= 100000 (where 0 <= i < n)
        // Constraint: firstDay[i] <= lastDay[i] (where 0 <= i < n)

        List<Investor> investors = new ArrayList<Investor>();
        for (int i = 0; i < sizeFirstDay; i++) {
            Integer fDay = firstDay.get(i);
            Integer lDay = lastDay.get(i);

            if ((fDay >= 1) && (100000 >= lDay) && (lDay >= fDay)) {
                investors.add(new Investor(fDay, lDay));
            }
        }

        Map<Integer, Investor> schedules = new Hashtable<Integer, Investor>();
        List<Investor> schedulesAux = new ArrayList<Investor>();
        
        if (investors.size() > 0) {
            for (Investor investor : investors) {
                int beginDay = investor.getBeginDay();
                int endDay = investor.getEndDay();

                if (beginDay == endDay) {
                    schedules.put(beginDay, investor);
                } else {
                    schedulesAux.add(investor);
                }
            }

            for (Investor investor : schedulesAux) {
                int beginDay = investor.getBeginDay();
                int endDay = investor.getEndDay();

                if (!schedules.containsKey(beginDay)) {
                    schedules.put(beginDay, investor);
                } else if (!schedules.containsKey(endDay)) {
                    schedules.put(endDay, investor);
                }
            }

        }

        return schedules.size();
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
