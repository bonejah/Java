import br.com.cod3r.app.calculo.CalculadoraImpl;

module cod3r.app.calculo {
	
	exports br.com.cod3r.app.calculo;
	
	requires transitive cod3r.app.logging;
	
	exports br.com.cod3r.app.calculo.interno
		to cod3r.app.financeiro;
	
	opens br.com.cod3r.app.calculo to cod3r.app.financeiro;
	
	requires cod3r.app.api.publica;
	provides br.com.cod3r.app.Calculadora
		with CalculadoraImpl;
}