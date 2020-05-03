package modelo;

public class Carro {
	
	public int ano;
	public String modelo;
	
	
	public Carro() {
		ano = 2014;
	}
	
	void reseta() {
		this.ano = 2014;
	}
	
	public String getDadosDeImpressao() {
		return modelo + "::" + ano;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Carro [ano=" + ano + ", modelo=" + modelo + "]";
	}
	
}

