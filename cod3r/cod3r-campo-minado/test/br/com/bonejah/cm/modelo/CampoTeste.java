package br.com.bonejah.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.bonejah.cm.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo = new Campo(3, 3);

	@BeforeEach
	public void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	public void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	public void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	public void testeVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	public void testeVizinhoDistancia1EmBaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	public void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	public void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}

	@Test
	public void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	public void alternarMarcacao() {
		campo.alternarMarcado();
		assertTrue(campo.isMarcado());
	}

	@Test
	public void alternarMarcacaoDuasChamadas() {
		campo.alternarMarcado();
		campo.alternarMarcado();
		assertFalse(campo.isMarcado());
	}

	@Test
	public void testeAbrirNaoMinadoNaoMarcado() {
		campo.alternarMarcado();
		assertFalse(campo.abrir());
	}

	@Test
	public void testeAbrirMinadoMarcado() {
		campo.alternarMarcado();
		campo.minar();
		assertFalse(campo.abrir());
	}

	@Test
	public void testeAbrirMinadoNaoMarcado() {
		campo.minar();

		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}

	@Test
	public void testeAbrirComVizinho1() {
		Campo campo11 = new Campo(2, 2);
		Campo campo22 = new Campo(1, 1);

		campo11.adicionarVizinho(campo22);
		campo.adicionarVizinho(campo11);
		campo.abrir();

		assertTrue(campo22.isAberto() && campo11.isAberto());
	}

	@Test
	public void testeAbrirComVizinho2() {
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo22);
		
		campo.adicionarVizinho(campo11);
		campo.abrir();

		assertTrue(campo22.isAberto() && campo11.isFechado());
	}

}
