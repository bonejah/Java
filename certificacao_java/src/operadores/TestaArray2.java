package operadores;

public class TestaArray2 {
	
	public static void main(String[] args) {
		ClienteNovo[] clientes = new ClienteNovo[10];
		
		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new ClienteNovo();
			clientes[i].nome = "Tadeu" + (i + 1);
		}
		
		for (ClienteNovo cliente : clientes) {
			System.out.println(cliente.nome);
		}
		
		
		ClienteNovo[] clientes2 = new ClienteNovo[5];
		clientes2[0] = new ClienteNovo();
		clientes2[1] = new ClienteNovoEspecial();
		
		for (ClienteNovo cliente : clientes2) {
			System.out.println(cliente);
		}
		
	}

}

class ClienteNovo {
	String nome;
}

class ClienteNovoEspecial extends ClienteNovo {}