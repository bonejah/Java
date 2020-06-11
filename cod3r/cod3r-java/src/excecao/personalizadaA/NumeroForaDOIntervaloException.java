package excecao.personalizadaA;

@SuppressWarnings("serial")
public class NumeroForaDOIntervaloException extends RuntimeException {
	
	private String nomeDoAtributo;
	
	public NumeroForaDOIntervaloException(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	
	public String getMessage() {
		return String.format("O atributo %s está negativo", this.nomeDoAtributo);
	}

}
