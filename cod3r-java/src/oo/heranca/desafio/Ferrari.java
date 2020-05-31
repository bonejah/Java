package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo, Luxo {

	
	private boolean ligarTurbo;
	private boolean ligarAr;

	public Ferrari() {
		this(300);
	}

	public Ferrari(int velocidadeMaxima) {
		super(velocidadeMaxima);
		setDelta(15);
	}

	@Override
	public void acelerar() {
		this.velocidadeAtual += 15;
	}

	@Override
	public void ligarTurbo() {
		this.ligarTurbo = true;
	}

	@Override
	public void desligarTurbo() {
		this.ligarTurbo = false;
	}
	
	public void ligarAr() {
		ligarAr = true;	 
	}

	public void desligarAr() {
		ligarAr = false;
	}
	
	@Override
	public int getDelta() {
		if (ligarTurbo && !ligarAr) {
			return super.getDelta();
		} else if (ligarTurbo && ligarAr) {
			return super.getDelta();
		} else if (ligarTurbo && !ligarAr) {
			return super.getDelta();
		} else {
			return 15;
		}
	}
	
	@Override
	public int nivelDoAr() {
		return 10;
	}
	
}
