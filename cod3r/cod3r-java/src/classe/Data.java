package classe;

public class Data {

	int dia;
	int mes;
	int ano;
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Data() {
		this(1, 1, 1970);
	}


	public String obterDataFormatada() {
		return String.format("Seu aniversário: %d/%d/%d", dia, mes, ano);
	}
	
}
