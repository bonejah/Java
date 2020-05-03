package br.com.devdojo.javacore.exception.custom.teste;

import br.com.devdojo.javacore.exception.custom.LoginInvalidoException;

public class CustomExceptionTest {
	
	public static void main(String[] args) {
		try {
			logar();
		} catch (LoginInvalidoException e) {
			e.printStackTrace();
		}
	}

	public static void logar() throws LoginInvalidoException {
		String usuario = "Goku";
		String senha = "213";
		String usuarioDigitado = "Goku";
		String senhaDigitada = "123";
		
		if (!usuario.equals(usuarioDigitado) || !senha.equals(senhaDigitada)) {
			throw new LoginInvalidoException();
		} else {
			System.out.println("Parabens você logou no sistema");
		}
		
	}
}
