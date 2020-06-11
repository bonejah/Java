package excecao;

public class Basico {

	public static void main(String[] args) {
		Aluno a1 = null;

		try {
			imprimirNomeAluno(a1);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro no momento de "
					+ "imprimir o nome do usuário, ERRO: " + e.getMessage());
		}

		try {
			System.out.println(7 / 0);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao dividir "
					+ "uma operação, ERRO: " + e.getMessage());
		}

		System.out.println("FIM :)");
	}

	public static void imprimirNomeAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}

}
