package br.com.devdojo.javacore.comportamentoporparamentro.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import br.com.devdojo.javacore.comportamentoporparamentro.Carro;
import br.com.devdojo.javacore.comportamentoporparamentro.CarroPredicate;
import br.com.devdojo.javacore.comportamentoporparamentro.CarrosCorVerdePredicate;
import br.com.devdojo.javacore.comportamentoporparamentro.CarrosDezAnosRecentsPredicate;

public class CarroTest {

	public static void main(String[] args) {
		List<Carro> carros = Arrays.asList(new Carro("vermelho", 2011), new Carro("preto", 2019), new Carro("verde", 2000));
//		System.out.println(filtrarCarroVermelho(carros));
//		System.out.println(filtrarCarroPorCor(carros, "azul"));
//		System.out.println(filtrarCarroPorAnosFabricado(carros));
		
//		System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentsPredicate()));
//		System.out.println(filtrarCarros(carros, new CarrosCorVerdePredicate()));
		
		System.out.println(filtrar(carros, new Predicate<Carro>() {

			@Override
			public boolean test(Carro carro) {
				
				return carro.getCor().equals("verde");
			}
		}));
		
	}
	
//	private static List<Carro> filtrarCarroVermelho(List<Carro> carros) {
//		List<Carro> result = new ArrayList<>();
//		
//		for (Carro carro : carros) {
//			if (carro.getCor().equals("vermelho")) {
//				result.add(carro);
//			}
//		}
//		
//		return result;
//	}
//	
//	private static List<Carro> filtrarCarroPorCor(List<Carro> carros, String cor) {
//		List<Carro> result = new ArrayList<>();
//		
//		for (Carro carro : carros) {
//			if (carro.getCor().equals(cor)) {
//				result.add(carro);
//			}
//		}
//		
//		return result;
//	}
//	
//	private static List<Carro> filtrarCarroPorAnosFabricado(List<Carro> carros) {
//		List<Carro> result = new ArrayList<>();
//		
//		for (Carro carro : carros) {
//			if (carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR)) - 10) {
//				result.add(carro); 
//			}
//		}
//		
//		return result;
//	}
	
	
	private static <T> List<T> filtrar(List<T> list, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		
		for (T t : list) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}
	

}
