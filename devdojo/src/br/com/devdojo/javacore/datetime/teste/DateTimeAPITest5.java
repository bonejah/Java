package br.com.devdojo.javacore.datetime.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeAPITest5 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);

		String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(s1);

		String s2 = date.format(DateTimeFormatter.ISO_DATE);
		System.out.println(s2);
		
		String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(s3);
		
		String s4 = "20190111";
		String s5 = "2019-01-11";
		LocalDate parse = LocalDate.parse(s4, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(parse);
		LocalDate parse2 = LocalDate.parse(s5);
		System.out.println(parse2);
		
		LocalDateTime dateTime = LocalDateTime.now();
		String s6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(s6);
		
		String s7 = "2019-01-11T15:35:29.412";
		LocalDateTime parse3 = LocalDateTime.parse(s7);
		System.out.println(parse3);
		
		DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatBR = LocalDate.now().format(formatterBR);
		System.out.println(formatBR);
		String dataBRString = "11/01/2019";
		LocalDate parse4 = LocalDate.parse(dataBRString, formatterBR);
		System.out.println(parse4);
		
		DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
		String formatFR = LocalDate.now().format(formatterFR);
		System.out.println(formatFR);
		LocalDate parse5 = LocalDate.parse("11.janvier.2019", formatterFR);
		System.out.println(parse5);
	}

}
