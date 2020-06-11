package teste.basico;

import infra.DAO;
import umpramuitos.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
//		Produto ps4 = new Produto("PS4", 2000.00);
//		dao.abrirT().incluir(ps4).fecharT().fechar();

		Produto mackBookAir = new Produto("MacBook Air", 15000.00);
		dao.abrirT().incluir(mackBookAir).fecharT();
		
		Produto penDrive = new Produto("Pen Drive", 30.00);
		dao.abrirT().incluir(penDrive).fecharT().fechar();
	}
}
