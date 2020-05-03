package br.com.devdojo.javacore.threads.teste;

public class DeadLockTest {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void main(String[] args) {
		new ThreadExemplo1().start();
		new ThreadExemplo2().start();
	}

	private static class ThreadExemplo1 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: segurando lock1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1: esperando pelo lock2");

				synchronized (lock2) {
					System.out.println("Thread 1: segurando lock1 e lock2");
				}
			}
		}
	}

	private static class ThreadExemplo2 extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 2: segurando lock2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 2: esperando pelo lock1");

				synchronized (lock2) {
					System.out.println("Thread 2: segurando lock2 e lock1");
				}
			}
		}
	}
}
