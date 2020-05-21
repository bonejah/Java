package classe.dsafios;

public class Pessoa {

	String nome;
	double peso;
	
	public Pessoa(String nome, double peso) {
		this.nome = nome;
		this.peso = peso;
	}
	
	public void comer(Comida comida) {
		if (comida != null) {
			this.peso += comida.peso;
		}
	}
	
	public String info() {
		return "Olá eu sou " + this.nome + " e peso: " + this.peso + " KG.";
	}
	
}
