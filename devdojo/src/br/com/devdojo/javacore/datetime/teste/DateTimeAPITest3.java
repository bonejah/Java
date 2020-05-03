package br.com.devdojo.javacore.datetime.teste;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest3 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2019, Month.NOVEMBER, 17);
		System.out.println(date);
		date.withYear(2020);
		System.out.println(date);
		date = date.withYear(2020);
		System.out.println(date);
		date = date.withMonth(Month.APRIL.getValue());
		System.out.println(date);
		date = date.withDayOfMonth(7);
		System.out.println(date);
		date = date.with(ChronoField.DAY_OF_MONTH, 17);
		System.out.println(date);
		
		date = date.plusMonths(10);
		System.out.println(date);
		date = date.plus(10, ChronoUnit.MONTHS);
		System.out.println(date);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		time = time.withHour(3);
		System.out.println(time);
		time = time.plusHours(17);
		System.out.println(time);
		
	}
}
