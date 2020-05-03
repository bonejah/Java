package operadores;

public class TestaArray {
	
	public static void main(String[] args) {
		double pesos[];
		long []numeros;
		long[]tamanhos;
		
		int[] idades = new int[10];
		for (int i = 0; i < idades.length; i++) {
			System.out.println(idades[i]);
		}
		
		System.out.println(" =============== ");
		
		String[] nomes = new String[10];
		for (int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
		
		System.out.println(" =============== ");
		
		int idades2[] = new int[] {0, 2, 4, 6, 8, 10};
		for (int i = 0; i < idades2.length; i++) {
			System.out.println(idades2[i]);
		}
		
		System.out.println(" =============== ");
	}

}
