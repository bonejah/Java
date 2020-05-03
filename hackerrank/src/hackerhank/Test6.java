package hackerhank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test6 {
	public static void main(String[] args) {
		List<String> arraySt = new ArrayList<String>();
		arraySt.add("20th Oct 2052");
		arraySt.add("6th Jun 1933");
		arraySt.add("26th May 1960");
		arraySt.add("20th Sep 1958");
		arraySt.add("16th Mar 2068");
		arraySt.add("25th May 1912");
		arraySt.add("16th Dec 2018");
		arraySt.add("26th Dec 2061");
		arraySt.add("4th Nov 2030");
		arraySt.add("28th Jul 1963");

		List<String> reformatDate = reformatDate(arraySt);

		if (reformatDate != null) {
			for (String dateFormatted : reformatDate) {
				System.out.println(dateFormatted);
			}
		}
	}

	public static List<String> reformatDate(List<String> dates) {
		List<String> lsDataFmt = new ArrayList<>();
		SimpleDateFormat sdfString = new SimpleDateFormat("d MMMM yyyy");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		Date rightNow = null;

		for (String data : dates) {
			data = data.replaceFirst("[a-zA-Z]{2}", "");
			System.out.println("data: " + data);
			System.out.println("");

			try {
				rightNow = sdfString.parse(data);
				System.out.println("rightNow: " + rightNow);
				System.out.println("");
			} catch (ParseException e) {
				e.printStackTrace();
			}

			sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			lsDataFmt.add(sdfDate.format(rightNow));
			System.out.println("lsDataFmt: " + lsDataFmt.toString());
			System.out.println("\n");
		}

		return lsDataFmt;
	}
}
