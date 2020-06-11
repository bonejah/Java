package classe.dsafios;

public class Jantar {

	public static void main(String[] args) {
		Comida c1 = new Comida("Arroz", 0.180);
		Comida c2 = new Comida("Feijao", 0.300);
		
		Pessoa james = new Pessoa("James Gosling", 99.8);
	
		System.out.println(james.info());
		james.comer(c1);
		
		System.out.println(james.info());
		james.comer(c2);
		System.out.println(james.info());	  
	}
	
}
