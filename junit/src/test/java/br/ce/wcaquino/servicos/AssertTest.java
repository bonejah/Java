package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertEquals("Erro de comparacao", 1, 1);
		Assert.assertEquals(0.51234, 0.512, 0.001);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "cola");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario usuario1 = new Usuario("Usuario1");
		Usuario usuario2 = new Usuario("Usuario1");
		Usuario usuario3 = usuario2;
		Usuario usuario4 = null;
		Assert.assertEquals(usuario1, usuario2);
		Assert.assertSame(usuario2, usuario3);
		Assert.assertNotSame(usuario2, usuario4);
		Assert.assertNull(usuario4);
		
	}

}
