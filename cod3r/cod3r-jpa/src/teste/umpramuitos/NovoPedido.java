package teste.umpramuitos;

import java.util.Date;

import infra.DAO;
import umpramuitos.ItemPedido;
import umpramuitos.Pedido;
import umpramuitos.Produto;

public class NovoPedido {

	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();

		Produto geladeira = new Produto("Geladeira", 2789.99);
		Pedido pedido = new Pedido(new Date());
		ItemPedido itemPedido = new ItemPedido(pedido, geladeira, 1);
		
		dao
			.abrirT()
			.incluir(geladeira)
			.incluir(pedido)
			.incluir(itemPedido)
			.fecharT()
			.fechar();
		

	}

}
