package teste.umpramuitos;

import infra.DAO;
import umpramuitos.ItemPedido;
import umpramuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorId(1L);
		
//		pedido.getItens().stream().forEach(item -> System.out.println("Item: " + item));
		
		for (ItemPedido item : pedido.getItens()) {
			System.out.println("Item : " + item);
			System.out.println("Produto : " + item.getProduto());
		}
		
		dao.fechar();
	}

}
