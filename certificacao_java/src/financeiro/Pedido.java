package financeiro;

//import modelo.Endereco;
//import modelo.Pessoa;
import modelo.*;
import static modelo.Util.TAMANHO;
import static modelo.Util.maior;
import java.util.*;
import java.sql.Date;

class Pedido {

	Endereco endereco;
	Pessoa pessoa;
	Date dataDeCriacao = new Date(Calendar.getInstance().getTimeInMillis());
	java.util.Date dataDeCriacao2 = new java.util.Date();
//	Produto produto; // nao utiliza-se classes do pacote default
	
	public Pessoa getCliente() {
		return pessoa;
	}
	
	
	public void calculaTudo() {
		int t = TAMANHO;
		maior(3, 10);
	}
	
}
