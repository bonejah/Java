package classe;

public class ValorVsReferencia {

	public static void main(String[] args) {
		double a = 2;
		double b = a; // atribuicao valor

		a++;
		b--;
		
		System.out.println(a + " " + b);
		
		
		Data d1 = new Data(17, 11, 1981);
		Data d2 = d1; // atribuição por referência (Objeto)
		
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		
		d1.dia = 16;
		d2.mes = 02;
		d1.ano = 2012;
		
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		
		voltarDataParaValorPadrao(d1);
		System.out.println(d1.obterDataFormatada());
		System.out.println(d2.obterDataFormatada());
		
		int c = 7;
		alterarPrimitivo(c);
		System.out.println(c);
	}

	private static void alterarPrimitivo(int c) {
		c++;
	}

	private static void voltarDataParaValorPadrao(Data d1) {
		d1.dia = 1;
		d1.mes = 1;
		d1.ano = 1970;
	}
	
}
