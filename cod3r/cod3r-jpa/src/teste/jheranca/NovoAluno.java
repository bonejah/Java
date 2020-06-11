	package teste.jheranca;
	
	import infra.DAO;
	import modelo.heranca.Aluno;
	import modelo.heranca.AlunoBolsista;
	
	public class NovoAluno {
	
		public static void main(String[] args) {
			DAO<Aluno> dao = new DAO<Aluno>();
			
			Aluno aluno = new Aluno(1234567L,"Bruno");
			AlunoBolsista alunoBolsista = new AlunoBolsista(34533432423L, "Leticia", 7000.00);
			
			dao.incluirAtomico(aluno);
			dao.incluirAtomico(alunoBolsista);
			dao.fechar();
		}
	}
