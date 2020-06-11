package teste.umpraum;

import infra.DAO;
import umpraum.Assento;
import umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		Cliente cliente = daoCliente.obterPorId(1L);

		System.out.println("Assento: " + cliente.getAssento().getNome());
		System.out.println("==========================================");
		System.out.println("Cliente: " + cliente.getAssento().getCliente().getNome());
		daoCliente.fechar();
		
		
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Assento assento = daoAssento.obterPorId(1L);
		
		System.out.println("Cliente: " + assento.getCliente().getNome());
		daoAssento.fechar();
		
		

	}

}
