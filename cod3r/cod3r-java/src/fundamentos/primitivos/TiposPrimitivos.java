package fundamentos.primitivos;

public class TiposPrimitivos {

	public static void main(String[] args) {
		
		// Tipos numéricos inteiros
		byte anoDeEmpresa = 23;
		short numeroDeVoos = 542;
		int id = 56789;
		long pontosAcumulados = 3_234_845_223L;
		
		
		// Tipos numéricos reais
		float salario = 11_445.44F;
		double vendasAcumuladas = 2_991_7979_103.01;
		
		// Tipo booleano
		boolean estaDeFerias = false;
		
		// Tipo caractere
		char status = 'A';
		
		// Dias de empresa
		System.out.println(anoDeEmpresa * 365);
		
		// Numéro de viagens
		System.out.println(numeroDeVoos / 2);
		
		// Pontos por real
		System.out.println(pontosAcumulados / vendasAcumuladas);
		
		System.out.println(id + ": ganha -> " + salario);
		System.out.println("Férias? " + estaDeFerias);
		System.out.println("Status: " + status);
	}
	
}
