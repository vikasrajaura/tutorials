package com.p5.ls.web.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.p5.ls.web.exception.ServiceException;

public interface IGenericService<T, ID extends Serializable> {

	public T save(T entity) throws ServiceException;
	List<T> saveAll(List<T> entities) throws ServiceException;
	public void persist(T entity) throws ServiceException;
	
	public T update(T entity) throws ServiceException;
	public Collection<T> updateAll(Collection<T> entities) throws ServiceException;

	public void delete(T entity) throws ServiceException;
	public void deleteAll(List<T> entities) throws ServiceException;
	public void deleteById(ID entityId) throws ServiceException;
	public void deleteByIds(List<ID> ids) throws ServiceException;

	public T findById(ID id) throws ServiceException;
	public List<T> findByIds(List<ID> ids) throws ServiceException;
	public List<T> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults) throws ServiceException;
	public List<T> findByCriteria(final DetachedCriteria criteria) throws ServiceException;
	public List<T> findAll() throws ServiceException;

}
