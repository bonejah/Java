package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<T> {

	private static EntityManagerFactory emf;

	private EntityManager em;
	private Class<T> clazz;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cod3r-java");
		} catch (Exception e) {

		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<T> clazz) {
		this.em = emf.createEntityManager();
		this.clazz = clazz;
	}

	public DAO<T> abrirT() {
		this.em.getTransaction().begin();
		return this;
	}

	public DAO<T> fecharT() {
		this.em.getTransaction().commit();
		return this;
	}

	public DAO<T> incluir(T type) {
		this.em.persist(type);
		return this;
	}

	public DAO<T> incluirAtomico(T type) {
		return this.abrirT().incluir(type).fecharT();
	}

	public List<T> obterTodos() {
		return this.obterTodos(0, 10);
	}

	public List<T> obterTodos(int offSet, int limit) {
		if (this.clazz == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}

		String jpql = "select e from " + this.clazz.getName() + " e";

		TypedQuery<T> query = this.em.createQuery(jpql, this.clazz);
		query.setFirstResult(offSet);
		query.setMaxResults(limit);
		return query.getResultList();
	}

	public T obterPorId(Object id) {
		return this.em.find(this.clazz, id);
	}

	public List<T> consultar(String nomeConsulta, Object... params) {
		TypedQuery<T> query = em.createNamedQuery(nomeConsulta, this.clazz);

		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}

		return query.getResultList();
	}

	public T consultarUm(String nomeConsulta, Object... params) {
		List<T> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public void fechar() {
		this.em.close();
	}

}
