package vanhack.test;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.IntStream;

class CountMeetings4 {

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

  
        
        return 0;
    }

}

public class MeetupSchedule4 {

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

		int result = CountMeetings4.countMeetings(arrival, departure);
		System.out.println(result);
		
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();
	}
}
