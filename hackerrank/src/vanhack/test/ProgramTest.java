package vanhack.test;

import java.time.LocalDate;
import java.time.Period;

public class ProgramTest {
	
	public static void main(String[] args) {
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now);
//		System.out.println(now.get(ChronoField.DAY_OF_MONTH));
//		System.out.println(now.get(ChronoField.MONTH_OF_YEAR));
//		System.out.println(now.get(ChronoField.YEAR));
//		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar.getTime());
		
//		Calendar calendarAux = Calendar.getInstance();
//		calendarAux.add(Calendar.DATE, -1);
//		System.out.println(calendarAux.getTime());
//		
//		System.out.println(calendar.after(calendarAux));
//		System.out.println(calendar.before(calendarAux));
		
		
		LocalDate now = LocalDate.now();
		LocalDate input = LocalDate.of(2020, 6, 13);
		
		System.out.println(now);
		System.out.println(input);
		
		Period period = Period.between(now, input);
		System.out.println(period.getDays());
		System.out.println(period.getMonths());
		System.out.println(period.getYears());
		
	}

}
