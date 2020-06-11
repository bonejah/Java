package oo.heranca.desafio;

public class Carro {

	public final int VELOCIDADE_MAXIMA;
	protected int velocidadeAtual;
	private int delta = 5;

	Carro(int velocidadeMaxima) {
		this.VELOCIDADE_MAXIMA = velocidadeMaxima;
	}

	public void acelerar() {
		if (this.velocidadeAtual + getDelta() > VELOCIDADE_MAXIMA) {
			this.velocidadeAtual = VELOCIDADE_MAXIMA;
		} else {
			this.velocidadeAtual += getDelta();
		}
	}

	public void frear() {
		if (this.velocidadeAtual >= getDelta()) {
			this.velocidadeAtual -= getDelta();
		} else {
			this.velocidadeAtual = 0;
		}
	}

	@Override
	public String toString() {
		return "Velocidade atual é: " + this.velocidadeAtual + "Km/h";
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

}
