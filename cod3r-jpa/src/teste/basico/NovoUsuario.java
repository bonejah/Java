package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cod3r-java");
		EntityManager em = emf.createEntityManager();

		Usuario usuario = new Usuario("Bianca", "bianca@hotmail.com");
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		System.out.println("O ID gerado foi: " + usuario.getId());
		
		em.close();
		emf.close();
	}

}
