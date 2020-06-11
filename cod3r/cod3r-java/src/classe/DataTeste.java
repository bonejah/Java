package classe;

public class DataTeste {

	public static void main(String[] args) {
		Data data1 = new Data(17, 11, 1981);;
		System.out.println(data1.obterDataFormatada());
		
		Data data2 = new Data();
		System.out.println(data2.obterDataFormatada());
	}
}
