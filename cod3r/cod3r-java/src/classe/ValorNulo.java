package classe;

public class ValorNulo {

	public static void main(String[] args) {
		String s1 = "";
		System.out.println(s1.concat("!!!"));
		
		Data d = Math.random() > 0.5 ? new Data() : null;
		if (d != null) {
			System.out.println(d.obterDataFormatada());
		}
		
		String s2 = Math.random() > 0.5 ? "Opa" : null;
		if (s2 != null) {
			System.out.println(s2.concat("!!!"));
		}
	}
}
