package excecao.personalizadaA;

import excecao.Aluno;

public class TesteValidacoes {

	public static void main(String[] args) {
		try {
			Aluno bruno = new Aluno("Bruno", 7);
			Validar.aluno(bruno);
			
			Validar.aluno(null);
		} catch (StringVaziaException e) {
			System.err.println(e.getMessage());
		} catch (NumeroForaDOIntervaloException | IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Fim :)");
	}

}
