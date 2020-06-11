package teste.umpraum;

import infra.DAO;
import umpraum.Assento;
import umpraum.Cliente;

public class NovoClienteAssento2 {
	
	public static void main(String[] args) {
		Assento assento = new Assento("4D");
		Cliente cliente = new Cliente("Bruno", assento);

		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.incluirAtomico(cliente);
		
	}

}
