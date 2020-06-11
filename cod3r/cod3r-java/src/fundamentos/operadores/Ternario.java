package fundamentos.operadores;

public class Ternario {

	public static void main(String[] args) {
		double media = 7.0;
		String resultadoRecuperacao = media >= 5.6 ? "Recuperacao" : "Reprovado";
		String resultado = media >= 7.0 ? "Aprovado" : resultadoRecuperacao;
		System.out.println("O aluno esta: " + resultado);
	} 
	
}
