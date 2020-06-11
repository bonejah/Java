package br.com.bonejah.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;

	private final int linha;
	private final int coluna;

	private List<Campo> vizinhos = new ArrayList<Campo>();
	private List<CampoObservador> observadores = new ArrayList<CampoObservador>();
//	private List<BiConsumer<Campo, CampoObservador>> observadores2 = new ArrayList<>();

	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public void registraObservador(CampoObservador observador) {
		this.observadores.add(observador);
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

	public boolean isFechado() {
		return !isAberto();
	}

	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	public boolean abrir() {
		if (!this.aberto && !this.marcado) {
			this.aberto = true;

			if (this.minado) {
				notificarObservadores(CampoEvento.EXPLODIR);
				return true;
			}

			setAberto(true);

			if (vizinhacaSegura()) {
				this.vizinhos.forEach(v -> v.abrir());
			}

			return true;
		} else {
			return false;
		}
	}
	
	public void alternarMarcado() {
		if (!this.aberto) {
			this.marcado = !this.marcado;

			if (marcado) {
				notificarObservadores(CampoEvento.MARCAR);
			} else {
				notificarObservadores(CampoEvento.DESMARCAR);
			}
		}
	}
	
	public int minasNaVizinhanca() {
		return (int) this.vizinhos.stream().filter(v -> v.minado).count();
	}
	
	public boolean vizinhacaSegura() {
		return this.vizinhos.stream().noneMatch(v -> v.minado);
	}

	boolean objetivoAlcancado() {
		boolean desvendado = !this.minado && this.aberto;
		boolean protegido = this.minado && this.marcado;
		return desvendado || protegido;
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

	void minar() {
		this.minado = true;
	}

	void setAberto(boolean aberto) {
		this.aberto = aberto;

		if (this.aberto) {
			notificarObservadores(CampoEvento.ABRIR);
		}
	}

	void reiniciar() {
		this.aberto = false;
		this.minado = false;
		this.marcado = false;
		notificarObservadores(CampoEvento.REINICIAR);
	}

	private void notificarObservadores(CampoEvento evento) {
		this.observadores.stream().forEach(o -> o.eventoOcorreu(this, evento));
	}

}
