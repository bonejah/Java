package oo.composicao;

public class Motor {

	Carro carro;
	boolean ligado;
	double fatorInjecao;
	
	public Motor(Carro carro) {
		this.carro = carro;
		this.ligado = false;
		this.fatorInjecao = 1;
	}

	int giros() {
		if (!ligado) {
			return 0;
		} else {
			return (int) Math.round(fatorInjecao * 3000);
		}
	}

}
