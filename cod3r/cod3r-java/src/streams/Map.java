package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Map {

	public static void main(String[] args) {
		Consumer<String> print= System.out::print;
		
		List<String> marcas = Arrays.asList("Bmw ", "Audi ", "Honda\n");
		marcas.stream().map(marca -> marca.toUpperCase()).forEach(print);
		
		System.out.println("\n\nUsando Composição...");
		
		marcas.stream()
			.map(Utilitarios.maiuscula)
			.map(Utilitarios.primeiraLeta)
			.map(Utilitarios::grito)
			.forEach(print);
		
	}
	
}
