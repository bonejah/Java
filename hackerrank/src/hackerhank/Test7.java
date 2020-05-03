package hackerhank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Test7 {

	public static void main(String[] args) {
		openAndClosePrices("1-January-2000", "22-February-2010", "Monday");
	}

	public static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		
//		String value = "\"" + firstDate + "," + lastDate + "," + weekDay + "\"";
//		String value = firstDate + "," + lastDate + "," + weekDay;
//		String value = "\'" + firstDate + "%" + lastDate + "%"+ weekDay + "\'";
//		String value = "[" + firstDate + ";" + lastDate + ";" + weekDay + "]";
		String [] value = {firstDate, lastDate, weekDay};
		
//		StringBuilder value = new StringBuilder();
//		value.append("[");
//		value.append("\"" + "date" + "\"");
//		value.append(":[");
//		value.append("\"" + firstDate + "\"" + ",");
//		value.append("\"" + lastDate + "\"" + ",");
//		value.append("\"" + weekDay + "\"");
//		value.append(firstDate + ",");
//		value.append(lastDate + ",");
//		value.append(weekDay);
//		value.append("]");
//		value.append("]");
//		String value = String.format("%s %s %s", firstDate, lastDate, weekDay);
		System.out.println(Arrays.asList(value));
		List<String> list = Arrays.asList(value);
		
		
		try {
			URL url = new URL("https://jsonmock.hackerrank.com/api/stocks/search?date=" + firstDate + "&date=" + lastDate + "&weekDay=" + weekDay);
			
			System.out.println(url);

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuilder jsonSb = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				jsonSb.append(line);
			}

			System.out.println(jsonSb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (connection != null)
				connection.disconnect();
		}
	}

}
