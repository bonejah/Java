package br.com.devdojo.javacore.datas.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		String mascara1 = "yyyy.MM.dd G 'as' HH:mm:ss z";
		String mascara2 = "'São Paulo' dd 'de' MMMM 'de' YYYY";
		
		SimpleDateFormat sdf = new SimpleDateFormat(mascara1);
		System.out.println(sdf.format(calendar.getTime()));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat(mascara2);
		System.out.println(sdf2.format(calendar.getTime()));
		
	}
}
