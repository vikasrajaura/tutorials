package com.p5.ls.web.dao.sd;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.p5.ls.web.exception.DAOException;

public interface IGenericDAO<T, ID extends Serializable> {

	public T save(T entity) throws DAOException;
	List<T> saveAll(List<T> entities) throws DAOException;
	public void persist(T entity) throws DAOException;

	public T update(T entity) throws DAOException;
	public Collection<T> updateAll(Collection<T> entities) throws DAOException;

	public void delete(T entity) throws DAOException;
	public void deleteAll(List<T> entities) throws DAOException;
	public void deleteById(ID entityId) throws DAOException;
	public void deleteByIds(List<ID> ids) throws DAOException;

	public T findById(ID id) throws DAOException;
	public List<T> findByIds(List<ID> ids) throws DAOException;
	public List<T> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults) throws DAOException;
	public List<T> findByCriteria(final DetachedCriteria criteria) throws DAOException;
	public List<T> findAll() throws DAOException;
}
