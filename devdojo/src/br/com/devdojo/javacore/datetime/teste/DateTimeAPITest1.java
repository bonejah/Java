package br.com.devdojo.javacore.datetime.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTimeAPITest1 {
	
	public static void main(String[] args) {
//		System.out.println(new Date());
//		System.out.println(Calendar.getInstance());
		System.out.println("-----------LocalDate------------");
		LocalDate date = LocalDate.of(2019, Month.JANUARY, 11);
		System.out.println(date);
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getDayOfYear());
		System.out.println(date.lengthOfMonth());
		System.out.println(date.lengthOfYear());
		System.out.println(date.isLeapYear());
		System.out.println(date.get(ChronoField.YEAR));
		System.out.println(date.get(ChronoField.DAY_OF_MONTH));
		System.out.println(LocalDate.MAX);
		System.out.println(LocalDate.MIN);
		
		System.out.println("-----------LocalTime------------");
		LocalTime time = LocalTime.of(13, 28, 00);
		System.out.println(time);
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
		System.out.println(LocalTime.MAX);
		System.out.println(LocalTime.MIN);
		
		System.out.println("-----------Parsing------------");
		LocalDate parseDate = LocalDate.parse("2019-11-01");
		LocalTime parseTime = LocalTime.parse("13:32:59");
		System.out.println(parseDate);
		System.out.println(parseTime);
		
		System.out.println("-----------LocalDateTime------------");
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime ldt2 = LocalDateTime.of(2019, 1, 11, 13, 36, 00);
		LocalDateTime ldt3 = date.atTime(13, 00, 00);
		LocalDateTime ldt4 = date.atTime(LocalTime.now());
		LocalDateTime ldt5 = time.atDate(LocalDate.now());
		LocalDateTime ldt6 = time.atDate(date);
		
		System.out.println(ldt);
		System.out.println(ldt2);
		System.out.println(ldt3);
		System.out.println(ldt4);
		System.out.println(ldt5);
		System.out.println(ldt6);
	}

}
