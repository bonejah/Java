package br.com.devdojo.javacore.concorrencia.teste;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

final class Pessoa {
	private final String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}

public class CopyOnWriteTest implements Runnable {
//	private List<Integer> list = Collections.synchronizedList(new ArrayList<>());
	private List<Integer> list = new CopyOnWriteArrayList<>();
	
	public CopyOnWriteTest() {
		for (int i = 0; i < 9000; i++) {
			list.add(i);
		}
	}

	@Override
	public void run() {
		Iterator<Integer> it = list.iterator();
		
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		while(it.hasNext()) {
			System.out.println(Thread.currentThread().getName() + " " + it.next());
		}
		
	}
	
	public List<Integer> getList() {
		return list;
	}
	
	public static void main(String[] args) {
		CopyOnWriteTest cwt = new CopyOnWriteTest();
		Thread t1 = new Thread(cwt);
		Thread t2 = new Thread(cwt);
		Thread t3 = new Thread(new RemoveMembros(cwt.getList()));
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	private static class RemoveMembros implements Runnable {
		private List<Integer> list;
		
		
		public RemoveMembros(List<Integer> list) {
			this.list = list;
		}


		@Override
		public void run() {
			for (int i = 0; i < 500; i++) {
				System.out.println(Thread.currentThread().getName() + ", removeu: " + list.remove(i));
			}
			
		}
		
	}

}
