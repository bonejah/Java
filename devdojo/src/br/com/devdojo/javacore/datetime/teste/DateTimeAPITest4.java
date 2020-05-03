package br.com.devdojo.javacore.datetime.teste;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import br.com.devdojo.javacore.datetime.ObterProximoDiaUtil;

public class DateTimeAPITest4 {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.with(new ObterProximoDiaUtil());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		
		date = date.plusDays(0);
		date = date.with(new ObterProximoDiaUtil());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
	}

}
