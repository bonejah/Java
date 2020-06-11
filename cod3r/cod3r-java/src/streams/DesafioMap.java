package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {
		/**
		 * 1. Número para string binária... 6 => "110"
		 * 2. Inverter para string... "110" => "011"
		 * 3. Converter de volta para inteiro => "011" => 3
		 */
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Function<Integer, String> numToBinario = n -> Integer.toBinaryString(n);
		UnaryOperator<String> inverteString = s -> new StringBuilder(s).reverse().toString();
		Function<String, Integer> binarioToInt = s -> Integer.parseInt(s, 2);
		
		nums.stream()
			.map(numToBinario)
			.map(inverteString)
			.map(binarioToInt)
			.forEach(System.out::println);
	}

}
