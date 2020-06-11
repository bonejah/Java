package br.com.bonejah.cm.visao;

import br.com.bonejah.cm.modelo.Tabuleiro;

public class Temp {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(3, 3, 9);
		
		tabuleiro.registrarObservador(e -> {
			if (e.isGanhou()) {
				System.out.println("Ganhou");
			} else {
				System.out.println("Perdeu");
			}
		});
		
		tabuleiro.alternarMarcado(0, 0);
		tabuleiro.alternarMarcado(0, 1);
		tabuleiro.alternarMarcado(0, 2);
		tabuleiro.alternarMarcado(1, 0);
		tabuleiro.alternarMarcado(1, 1);
		tabuleiro.alternarMarcado(1, 2);
		tabuleiro.alternarMarcado(2, 0);
		tabuleiro.alternarMarcado(2, 1);
		tabuleiro.alternarMarcado(2, 2);
		
	}
}
