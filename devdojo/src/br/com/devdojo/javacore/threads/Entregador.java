package br.com.devdojo.javacore.threads;

public class Entregador implements Runnable {
	private ListaMembros listaMembros;
	
	public Entregador(ListaMembros listaMembros) {
		this.listaMembros = listaMembros;
	}

	@Override
	public void run() {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + " - começando a trabalhar na entrega");
		int qtdPendentes = listaMembros.getEmailsPendentes();
		boolean aberta = listaMembros.isAberta();
		
		while(qtdPendentes > 0 || aberta) {
			try {
				String email = listaMembros.obterEmailMembro();
				if (email != null) {
					System.out.println(nomeThread + " - enviando email para: " + email);
					Thread.sleep(2000);
					System.out.println("Email " + email + ", enviado com sucesso");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			aberta = listaMembros.isAberta();
			qtdPendentes = listaMembros.getEmailsPendentes();
		}
		
		System.out.println("Atividades finalizadas com sucesso!!!");
	}

}
