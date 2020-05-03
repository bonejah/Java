package br.com.devdojo.javacore.enumclasses;

public class Cliente {
	public enum TipoPagamento {
		AVISTA, APRAZO;
	}

	private String nome;
	private TipoCliente tipoCliente;
	private TipoPagamento tipoPagamento;

	public Cliente(String nome, TipoCliente tipo, TipoPagamento tipoPagamento) {
		super();
		this.nome = nome;
		this.tipoCliente = tipo;
		this.tipoPagamento = tipoPagamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", tipoCliente=" + tipoCliente + ", tipoPagamento=" + tipoPagamento
				+ ", numeroCliente=" + tipoCliente.getTipo() + ", descricaoCliente=" + tipoCliente.getDescricao() + "]";
	}

}
