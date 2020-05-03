package br.com.devdojo.javacore.streams.paralelos;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParalelos {
	
	public static void main(String[] args) {
		long num = 10_000_000_00;
		somaFor(num);
//		somaStreamIterate(num);
//		somaParallelStreamIterate(num);
		somaRangeCloseStream(num);
		somaParallelRangeCloseStream(num);
	}
	
	
	private static void somaFor(long num) {
		System.out.println("For");
		long result = 0;
		long init = System.currentTimeMillis();
		
		for (long i = 1L; i <= num ; i++) {
			result += i;
		}
		
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms ");
	}
	
	private static void somaStreamIterate(long num) {
		System.out.println("Stream Sequencial");
		long result = 0;
		long init = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms ");
	}
	
	private static void somaParallelStreamIterate(long num) {
		System.out.println("Stream Parallel");
		long result = 0;
		long init = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms ");
	}

	private static void somaRangeCloseStream(long num) {
		System.out.println("Stream Range Close");
		long result = 0;
		long init = System.currentTimeMillis();
		result = LongStream.range(1L, num).reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms ");
	}
	
	private static void somaParallelRangeCloseStream(long num) {
		System.out.println("Stream Parallel Range Close");
		long result = 0;
		long init = System.currentTimeMillis();
		result = LongStream.range(1L, num).parallel().reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms ");
	}
	
}
