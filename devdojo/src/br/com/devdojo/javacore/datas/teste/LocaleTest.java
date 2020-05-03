package br.com.devdojo.javacore.datas.teste;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
	
	public static void main(String[] args) {
		// ISO 639 pt = portugues BR - Brasil, en = ingles, US - EUA
		Locale locItaly = new Locale("it", "IT");
		Locale locSuica = new Locale("it", "CH");
		Locale locIIndia = new Locale("hi", "IN");
		Locale locJapao = new Locale("ja");
		
		
		Calendar c = Calendar.getInstance();
		c.set(2018, Calendar.DECEMBER, 17);
		
		DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, locItaly);
		System.out.println(df1.format(c.getTime()));
		System.out.println(locItaly.getDisplayLanguage());
		System.out.println(locItaly.getDisplayCountry());
		System.out.println("---------------------------");
		
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, locSuica);
		System.out.println(df2.format(c.getTime()));
		System.out.println(locSuica.getDisplayLanguage());
		System.out.println(locSuica.getDisplayCountry());
		System.out.println("---------------------------");
		
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, locIIndia);
		System.out.println(df3.format(c.getTime()));
		System.out.println(locIIndia.getDisplayLanguage());
		System.out.println(locIIndia.getDisplayCountry());
		System.out.println("---------------------------");
		
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, locJapao);
		System.out.println(df4.format(c.getTime()));
		System.out.println(locJapao.getDisplayLanguage());
		System.out.println(locJapao.getDisplayCountry());
		System.out.println("---------------------------");
	}
}

