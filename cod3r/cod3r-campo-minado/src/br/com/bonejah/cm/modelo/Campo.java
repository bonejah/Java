package br.com.bonejah.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.bonejah.cm.excecao.ExplosaoException;

public class Campo {

	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;

	private final int linha;
	private final int coluna;

	private List<Campo> vizinhos = new ArrayList<Campo>();

	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = this.linha != vizinho.linha;
		boolean colunaDiferente = this.coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(this.linha - vizinho.linha);
		int deltaColuna = Math.abs(this.coluna - vizinho.coluna);
		int deltaGeral = deltaLinha + deltaColuna;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}

	void alternarMarcado() {
		if (!this.aberto) {
			this.marcado = !this.marcado;
		}
	}

	boolean abrir() {
		if (!this.aberto && !this.marcado) {
			this.aberto = true;

			if (this.minado) {
				throw new ExplosaoException();
			}

			if (vizinhacaSegura()) {
				this.vizinhos.forEach(v -> v.abrir());
			}

			return true;
		} else {
			return false;
		}
	}

	boolean vizinhacaSegura() {
		return this.vizinhos.stream().noneMatch(v -> v.minado);
	}

	void minar() {
		this.minado = true;
	}

	public boolean isMinado() {
		return this.minado;
	}
	
	public boolean isMarcado() {
		return this.marcado;
	}

	public boolean isAberto() {
		return this.aberto;
	}
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isFechado() {
		return !isAberto();
	}

	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	boolean objetivoAlcancado() {
		boolean desvendado = !this.minado && this.aberto;
		boolean protegido = this.minado && this.marcado;
		return desvendado || protegido;
	}

	long minasNaVizinhanca() {
		return this.vizinhos.stream().filter(v -> v.minado).count();
	}

	void reiniciar() {
		this.aberto = false;
		this.minado = false;
		this.marcado = false;
	}

	public String toString() {
		if (this.marcado) {
			return "x";
		} else if (this.aberto && this.minado) {
			return "*";
		} else if (this.aberto && minasNaVizinhanca() > 0) {
			return Long.toString(minasNaVizinhanca());
		} else if (this.aberto) {
			return " ";
		} else {
			return "?";
		}
	}

}
