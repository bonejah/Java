package excecao;

public class Causa {

	public static void main(String[] args) {
		try {
			metodoA(null);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getCause().getMessage());
		}
		
		metodoA(null);
	}
	
	static void metodoA(Aluno aluno) {
		try {
			metodoB(aluno);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	static void metodoB(Aluno aluno) {
		if (aluno == null)  {
			throw new NullPointerException("Aluno está nulo...");
		}
		
		System.out.println(aluno.nome);
	}
}
