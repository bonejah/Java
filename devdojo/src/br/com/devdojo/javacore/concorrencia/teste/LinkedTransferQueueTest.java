package br.com.devdojo.javacore.concorrencia.teste;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {

	public static void main(String[] args) throws InterruptedException {
		TransferQueue<String> tq = new LinkedTransferQueue<>();
		System.out.println(tq.remainingCapacity());
		System.out.println(tq.add("Bruno"));
		tq.put("Leticia");
		tq.offer("Bianca", 10, TimeUnit.MILLISECONDS);
		tq.offer("Matheus");
		System.out.println(tq.toString());
		System.out.println(tq.remainingCapacity());
		System.out.println(tq.tryTransfer("DevDojo"));
	}

}
