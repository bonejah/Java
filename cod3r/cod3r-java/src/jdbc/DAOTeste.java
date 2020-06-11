package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
		String sql = "INSERT INTO pessoas (nome) values (?)";
		
		DAO dao = new DAO();
		dao.incluir(sql, "Jose das Couves");
		dao.incluir(sql, "Jose das Pimentas");
		dao.incluir(sql, "Jose das Flores");
		dao.incluir(sql, "Jose das Palmeiras");
		dao.close();
	}
	
}
