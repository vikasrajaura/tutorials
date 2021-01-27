package com.p5.ls.web.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IGenericDao;
import com.p5.ls.web.exception.DAOException;
import com.p5.ls.web.exception.ServiceException;

@Transactional(value = "hbTxMgr", readOnly = false)
public abstract class GenericService<T, ID extends Serializable> implements IGenericService<T, ID> {

	private final Class<T> clazz;
	private final Logger logger;
	
	protected abstract Logger getLogger();

	@SuppressWarnings("unchecked")
	public GenericService() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		this.logger = getLogger();
	}

	@Autowired
	IGenericDao<T, ID> genericDao;

	@Override
	public T save(T entity) throws ServiceException {
		try {
			genericDao.save(entity);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
		return entity;
	}

	public void persist(T entity) throws ServiceException {
		try {
			genericDao.persist(entity);
		} catch (DAOException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
	}
	
	public List<T> saveAll(List<T> entities) throws ServiceException {
		List<T> list = null;
		try {
			list = genericDao.saveAll(entities);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
		return list;
	}

	@Override
	public T update(T entity) throws ServiceException {
		T t = null;
		try {
			t = genericDao.update(entity);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
		return t;
	}

	@Override
	public Collection<T> updateAll(Collection<T> entities) throws ServiceException {
		Collection<T> collection = null;
		try {
			collection = genericDao.updateAll(entities);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
		return collection;
	}

	@Override
	public void delete(T entity) throws ServiceException {
		try {
			genericDao.delete(entity);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
	}

	@Override
	public void deleteAll(List<T> entities) throws ServiceException {
		try {
			genericDao.deleteAll(entities);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
	}

	@Override
	public void deleteById(ID id) throws ServiceException {
		try {
			genericDao.deleteById(id);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
	}

	@Override
	public void deleteByIds(List<ID> ids) throws ServiceException {
		try {
			genericDao.deleteByIds(ids);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
	}

	@Override
	public T findById(ID id) throws ServiceException {
		T t = null;
		try {
			t = genericDao.findById(id);
		} catch (DAOException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}
		return t;
	}

	@Override
	public List<T> findByIds(List<ID> ids) throws ServiceException {
		// implementation
		return Collections.emptyList();
	}

	@Override
	public List<T> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults)
			throws ServiceException {
		// implementation
		return Collections.emptyList();
	}

	@Override
	public List<T> findByCriteria(final DetachedCriteria criteria) throws ServiceException {
		// implementation
		return Collections.emptyList();
	}

	@Override
	public List<T> findAll() throws ServiceException {
		List<T> list = null;
		try {
			return genericDao.findAll();
		} catch (DAOException e) {
			logger.error("DAOException Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		} catch (Exception e) {
			logger.error("Exception:"+clazz.getCanonicalName()+": "+e.getMessage());
			throw new ServiceException(20, e.getLocalizedMessage(), e.getMessage());
			
		}
	}

}