package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cod3r-java");
		EntityManager em = emf.createEntityManager();

		String jpql = "select u from Usuario u";
		
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
//		query.setFirstResult(1);
		query.setMaxResults(3);
		
		List<Usuario> resultado = query.getResultList();
		
		resultado.stream().forEach(System.out::println);
		
		System.out.println("=========================");
		
		List<Usuario> resultado2 = em.createQuery(jpql, Usuario.class)
			.setMaxResults(5)
			.getResultList();
		
		resultado2.stream().forEach(System.out::println);
		
		
		em.close();
		emf.close();
	}
	
}
