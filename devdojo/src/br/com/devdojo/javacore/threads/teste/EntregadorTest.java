package br.com.devdojo.javacore.threads.teste;

import javax.swing.JOptionPane;

import br.com.devdojo.javacore.threads.Entregador;
import br.com.devdojo.javacore.threads.ListaMembros;

public class EntregadorTest {
	
	public static void main(String[] args) {
		ListaMembros listaMembros = new ListaMembros();
		Thread t1 = new Thread(new Entregador(listaMembros), "Entregador1");
		Thread t2 = new Thread(new Entregador(listaMembros), "Entregador2");
		t1.start();
		t2.start();
		
		while(true) {
			String email = JOptionPane.showInputDialog("Digite o e-mail: ");
			if (email == null || email.isEmpty()) {
				listaMembros.fecharLista();
				break;
			}
			listaMembros.addEmailMembro(email);
		}
	}

}
