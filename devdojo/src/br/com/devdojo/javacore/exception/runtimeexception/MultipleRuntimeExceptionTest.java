package br.com.devdojo.javacore.exception.runtimeexception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultipleRuntimeExceptionTest {

	public static void main(String[] args) {
		try {
			throw new ArrayIndexOutOfBoundsException();
		} catch (ArrayIndexOutOfBoundsException |  IllegalArgumentException | ArithmeticException  e) {
			System.err.println("Dentro do multiplo catch");
		} 
		
		try {
			talvezLanceException();
		} catch (Exception  e) {
			System.err.println("Dentro do FileNotFoundException/SQLException");
		} 
	}
	
	public static void talvezLanceException() throws SQLException, FileNotFoundException {
		
	}

}
