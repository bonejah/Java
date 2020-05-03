package br.ce.wcaquino.servicos;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculadoraMockTest {
	
	@Mock
	private Calculadora calcMock;
	
	@Spy
	private Calculadora calcSpy;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveMostrarADiferencaEntraMockESpy() {
//		Mockito.when(calcMock.soma(1, 2)).thenReturn(8);
		Mockito.when(calcMock.soma(1, 2)).thenCallRealMethod();
		Mockito.when(calcSpy.soma(1, 2)).thenReturn(8);
		
		System.out.println(calcMock.soma(1, 2));
		System.out.println(calcSpy.soma(1, 2));
	}
	
	@Test
	public void teste() {
		Calculadora calculadora = Mockito.mock(Calculadora.class);
		Mockito.when(calculadora.soma(Mockito.eq(1), Mockito.anyInt())).thenReturn(5);
	}
}
