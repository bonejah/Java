package br.com.devdojo.javacore.streams.teste;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5 {

	public static void main(String[] args) {
		IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(s -> System.out.print(s + " "));
		System.out.println();
		IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(s -> System.out.print(s + " "));
		System.out.println();

		Stream<String> stString = Stream.of("Bruno", "Leticia", "Bianca", "Matheus");
		stString.map(String::toUpperCase).forEach(s -> System.out.println(s + " "));

		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
		OptionalDouble average = Arrays.stream(nums).average();
		System.out.println(average.getAsDouble());

		try (Stream<String> lines = Files.lines(Paths.get("xpto.txt"), Charset.defaultCharset())) {
			lines.flatMap(line -> Arrays.stream(line.split("\n"))).filter(p -> p.contains("File"))
					.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);

		Stream.iterate(new int[] { 0, 1 }, a -> new int[] { a[1], a[0] + a[1] }).limit(5)
				.forEach(t -> System.out.println(Arrays.toString(t)));

		Stream.iterate(new int[] { 0, 1 }, a -> new int[] { a[1], a[0] + a[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}

}
