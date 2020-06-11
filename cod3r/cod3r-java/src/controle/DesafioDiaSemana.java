package controle;

import javax.swing.JOptionPane;

public class DesafioDiaSemana {

	public static void main(String[] args) {
		String diaDaSemana = JOptionPane.showInputDialog("Informe o dia da semana: ");

		if (diaDaSemana.equalsIgnoreCase("DOMINGO")) {
			System.out.println("1");
		} else if (diaDaSemana.equalsIgnoreCase("SEGUNDA")) {
			System.out.println("2");
		} else if (diaDaSemana.equalsIgnoreCase("TERÇA")) {
			System.out.println("3");
		} else if (diaDaSemana.equalsIgnoreCase("QUARTA")) {
			System.out.println("4");
		} else if (diaDaSemana.equalsIgnoreCase("QUINTA")) {
			System.out.println("5");
		} else if (diaDaSemana.equalsIgnoreCase("SEXTA")) {
			System.out.println("6");
		} else if (diaDaSemana.equalsIgnoreCase("SÁBADO")) {
			System.out.println("7");
		} else {
			System.out.println("Dia inválido");
		}
	}
}
