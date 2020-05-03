package br.com.deitel.cap.eight;

public class Time1Test {
	public static void main(String[] args) {
		// cria e inicializa o objeto Time1
		Time1 time1 = new Time1();

		// gera saida de representacoes de string da hora
		System.out.print("The initial universal time is: ");
		System.out.println(time1.toUniversalString());
		System.out.print("The initial standard time is: ");
		System.out.println(time1.toString());
		System.out.println();
		
		// altera a hora e gera saida da hora atualizada
		time1.setTime(13, 27, 6);
		System.out.print("Universal time after setTime is: ");
		System.out.println(time1.toUniversalString());
		System.out.print("Standard time after setTime is: ");
		System.out.println(time1.toString());
		System.out.println();
		
		// configura a hora com valores invalidos ; gera saida da hora atualizada
		time1.setTime(99, 99, 99);
		System.out.print("After attempting invalid settings: ");
		System.out.print("Universal time: ");
		System.out.println(time1.toUniversalString());
		System.out.print("Standard time: ");
		System.out.println(time1.toString());
		System.out.println();		
		
	}
}
