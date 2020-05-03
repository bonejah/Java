package hackerhank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test6Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
//		List<String> arraySt = new ArrayList<String>();
//		arraySt.add("20th Oct 2052");
//		System.out.println(arraySt);

//		Calendar calendar = Calendar.getInstance();
//		System.out.println("Calendar.DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
//		System.out.println("Calendar.DAY_OF_WEEK: " +calendar.get(Calendar.DAY_OF_WEEK));
//		System.out.println("Calendar.DAY_OF_WEEK_IN_MONTH: " +calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		System.out.println("Calendar.DAY_OF_YEAR: " +calendar.get(Calendar.DAY_OF_YEAR));
//		System.out.println("Timezone: " + calendar.getTimeZone());

		String dateString1 = "20th Oct 2052";
		dateString1 = dateString1.replaceFirst("[a-zA-Z]{2}", "");
		
		System.out.println(dateString1);
		
		
		System.out.println(dateString1);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy");
		Date rightNow = null;
		
		try {
			rightNow = simpleDateFormat.parse(dateString1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(rightNow);
		System.out.println(formattedDate);

	}

}
