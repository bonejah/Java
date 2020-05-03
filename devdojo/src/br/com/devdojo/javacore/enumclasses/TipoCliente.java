package br.com.devdojo.javacore.enumclasses;

public enum TipoCliente {
	PESSOA_FISICA(1, "Pessoa Fisica"), PESSOA_JURIDICA(2, "Pessoa Juridica") {
		public String getId() {
			return "B";
		}
	};

	private int tipo;
	private String descricao;

	TipoCliente(int tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public String getId() {
		return "A";
	}

	public int getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
