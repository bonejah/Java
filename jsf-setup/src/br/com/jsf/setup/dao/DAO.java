package br.com.jsf.setup.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> extends Serializable {
	
	public abstract T save (T entity);
	public abstract T update (T entity);
	public abstract List<T> listAll (T entity);

}
