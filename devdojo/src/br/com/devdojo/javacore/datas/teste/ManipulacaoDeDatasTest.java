package br.com.devdojo.javacore.datas.teste;

import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDatasTest {
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		date.setTime(date.getTime() + 3_600_000l);
		System.out.println(date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		if (Calendar.SUNDAY == calendar.getFirstDayOfWeek()) {
			System.out.println("Domingo é o primeiro dia da semana");
		}
		
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		calendar.add(Calendar.HOUR, 24);
		calendar.roll(Calendar.MONTH, 9);
		
		Date date2 = calendar.getTime();
		System.out.println(date2);
		
	}

}
