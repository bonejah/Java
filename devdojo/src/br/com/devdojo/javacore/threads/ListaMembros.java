package br.com.devdojo.javacore.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {

	private final Queue<String> emails = new LinkedList<>();
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition conditionLock1 = lock.newCondition();

	private boolean aberta = true;

	public int getEmailsPendentes() {
		lock.lock();
		try {
//			synchronized (emails) {
			return this.emails.size();
//			}
		} finally {
			lock.unlock();
		}
	}

	public boolean isAberta() {
		return aberta;
	}

	public String obterEmailMembro() {
		String email = null;
		try {
			lock.lock();
//			synchronized (this.emails) {
			while (this.emails.size() == 0) {
				if (!aberta)
					return null;
				System.out.println(
						"Lista vazia, colocando a Thread :" + Thread.currentThread().getName() + " em modo wait");
//					this.emails.wait();
				conditionLock1.await();
			}

			email = this.emails.poll();
//			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return email;
	}

	public void addEmailMembro(String email) {
		lock.lock();
		try {
//		synchronized (this.emails) {
			this.emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as Threads que estão em espera: " + Thread.currentThread().getName());
//			this.emails.notifyAll();
			conditionLock1.signalAll();
			// }
		} finally {
			lock.unlock();
		}
	}

	public void fecharLista() {
		lock.lock();
		try {
			System.out.println("Notificando todas as Threads e fechando a lista");
			aberta = false;
//			synchronized (this.emails) {
//				this.emails.notifyAll();
				conditionLock1.signalAll();
//			}
		} finally {
			lock.unlock();
		}
	}
}
