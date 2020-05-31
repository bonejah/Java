package oo.polimorfismo;

public class Jantar {

	public static void main(String[] args) {
		Pessoa bruno = new Pessoa(86.0);		
		Comida arroz = new Arroz(0.200);
		Comida feijao = new Feijao(0.300);
		Comida comida = new Arroz(1.700);
		
		System.out.println(bruno.getPeso());
		
		bruno.comer(arroz);
		bruno.comer(feijao);
		bruno.comer(comida);
		
		System.out.println(bruno.getPeso());
		
		Comida sorvete = new Sorvete(0.500);
		bruno.comer(sorvete);
		
		System.out.println(bruno.getPeso());
	}
	 
}
 