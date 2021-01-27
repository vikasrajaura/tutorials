package com.p5.ls.web.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.p5.ls.web.exception.DAOException;

@Transactional(value = "hbTxMgr", readOnly = false)
public abstract class GenericDao<T, ID extends Serializable>  implements IGenericDao<T, ID> {

	private final Class<T> clazz;

	private final Logger logger;
	protected abstract Logger getLogger();

	private final String idName;
	protected abstract String getIdName();

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		this.logger = getLogger();
		this.idName = getIdName();
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;

	protected HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public DetachedCriteria createEntityCriteria(){
			return DetachedCriteria.forClass(clazz);
	}

	public T save(T entity) throws DAOException {
		try {
		hibernateTemplate.save(entity);
		} catch(DataAccessException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return entity;
	}

	public void persist(T entity) throws DAOException {
		try {
		hibernateTemplate.persist(entity);
		} catch(DataAccessException e) {
			logger.error("Exception Occured:"+clazz.getCanonicalName()+": "+e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
	}
	
	public List<T> saveAll(List<T> entities) throws DAOException {
		if (CollectionUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}

		List<ID> ids = new ArrayList<ID>();
		ID id = null;

		try {
			for (T entity : entities) {
				id = (ID) hibernateTemplate.save(entity);
				ids.add(id);
			}

		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return findByIds(ids);
	}

	public T update(T entity) throws DAOException {
		T t = null;
		try {
			t = hibernateTemplate.merge(entity);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return t;
	}

	public Collection<T> updateAll(Collection<T> entities) throws DAOException {
		if (CollectionUtils.isEmpty(entities)) {
			return Collections.emptyList();
		}
		Collection<T> updatedEntities = entities instanceof List ? new ArrayList<T>() : new HashSet<T>();

		try {
			for (T entity : entities) {
				updatedEntities.add(hibernateTemplate.merge(entity));
			}
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return updatedEntities;
	}

	public void delete(T entity) throws DAOException {
		try {
			hibernateTemplate.delete(entity);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
	}

	public void deleteAll(List<T> entities) throws DAOException {
		if (CollectionUtils.isEmpty(entities)) {
			return;
		}
		try {
			hibernateTemplate.deleteAll(entities);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
	}

	public void deleteById(ID entityId) throws DAOException {
		try {
		T entity = findById(entityId);
		delete(entity);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
	}

	public void deleteByIds(List<ID> ids) throws DAOException {
		try {
			List<T> entities = findByIds(ids);
			hibernateTemplate.deleteAll(entities);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
	}

	public T findById(ID id) throws DAOException {
		T t = null;
		try {
			t = hibernateTemplate.get(clazz, id);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return t;
	}

	public List<T> findByIds(List<ID> ids) throws DAOException {
		if (CollectionUtils.isEmpty(ids)) {
			return Collections.emptyList();
		}
		List<T> list = null;
		try {
			DetachedCriteria queryCriteria = DetachedCriteria.forClass(clazz);
			queryCriteria.add(Restrictions.in(idName, ids));
			list = (List<T>) hibernateTemplate.findByCriteria(queryCriteria);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return list;
	}

	
	public List<T> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults)
			throws DAOException {
		List<T> list = null;
		try {
			list = (List<T>) hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
		} catch (DataAccessException e) {
			logger.error("Exception Occured:" + clazz.getCanonicalName() + ": " + e.getMessage());
			e.printStackTrace();
			throw new DAOException(10, e.getMessage(), e.getMessage());
		}
		return list;
	}

	public List<T> findByCriteria(final DetachedCriteria criteria) throws DAOException {
		return (List<T>) findByCriteria(criteria, -1, -1);
	}

	public List<T> findAll() throws DAOException {
		//return (List<T>) findByCriteria(createEntityCriteria(), -1, -1);
		return (List<T>) hibernateTemplate.findByCriteria(createEntityCriteria());
	}

}