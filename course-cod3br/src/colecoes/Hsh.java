package colecoes;

import java.util.HashSet;

public class Hsh {

	public static void main(String[] args) {
		HashSet<Usuario> usuarios = new HashSet<Usuario>();
		
		usuarios.add(new Usuario("Pedro"));
		usuarios.add(new Usuario("Ana"));
		usuarios.add(new Usuario("Guilherme"));
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		boolean resultado = usuarios.contains(new Usuario("Guilherme"));
		System.out.println(resultado);
		
	}
	
}
