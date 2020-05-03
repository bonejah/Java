package br.com.devdojo.javacore.datas.teste;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

	public static void main(String[] args) {
		float valor = 212.4567f;
		Locale locJp = new Locale("jp");
		Locale locFr = new Locale("fr");
		Locale locIt = new Locale("it");
		
		NumberFormat[] nfa = new NumberFormat[4];
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getInstance(locIt);
		nfa[2] = NumberFormat.getCurrencyInstance();
		nfa[3] = NumberFormat.getCurrencyInstance(locIt);
		
		for (NumberFormat nf : nfa) {
			System.out.println(nf.format(valor));
		}
		
		NumberFormat nf1 = NumberFormat.getInstance();
		System.out.println(nf1.getMaximumFractionDigits());
		nf1.setMaximumFractionDigits(2);
		System.out.println(nf1.format(valor));
		
		String valorString = "212.4567";
		try {
			System.out.println(nf1.parse(valorString));
			nf1.setParseIntegerOnly(true);
			System.out.println(nf1.parse(valorString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
