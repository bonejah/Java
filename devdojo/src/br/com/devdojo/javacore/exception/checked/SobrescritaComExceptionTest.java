package br.com.devdojo.javacore.exception.checked;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.devdojo.javacore.exception.custom.LoginInvalidoException;

public class SobrescritaComExceptionTest {
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		Pessoa pessoa = new Pessoa();
		
		try {
			funcionario.salvar();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pessoa.salvar();
		} catch (LoginInvalidoException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
