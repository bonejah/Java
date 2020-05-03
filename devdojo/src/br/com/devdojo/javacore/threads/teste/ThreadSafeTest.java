package br.com.devdojo.javacore.threads.teste;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ListaNomes {
	private List<String> nomes = Collections.synchronizedList(new LinkedList<>());

	public synchronized void add(String nome) {
		nomes.add(nome);
	}

	public synchronized void removePrimeiro() {
		if (nomes.size() > 0) {
			System.out.println(nomes.remove(0));
		}
	}
}

public class ThreadSafeTest {

	public static void main(String[] args) {
		ListaNomes nome = new ListaNomes();
		nome.add("Bruno");
		
		class RemovedorDeNomes extends Thread {
			public void run() {
				nome.removePrimeiro();
			}
		}
		
		new RemovedorDeNomes().start();
		new RemovedorDeNomes().start();
	}
}
