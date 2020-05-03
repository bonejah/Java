package br.com.jsf.setup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class DAOImpl<T> implements DAO<T> {
	
	@PersistenceContext
	private EntityManager em;
	
	private final Class<T> classe;
	
	public DAOImpl(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	@Override
	public T save(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listAll(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
