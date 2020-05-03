package modelo;

public class TestaCarro {

	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.modelo = "Palio";
		carro.setModelo("Palio 2");
		System.out.println(carro.getDadosDeImpressao());
		System.out.println(carro.ano);
		
	}
}
