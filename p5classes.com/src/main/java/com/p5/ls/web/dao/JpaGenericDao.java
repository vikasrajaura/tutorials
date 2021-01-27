
package com.p5.ls.web.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(value = "jpaTxMgr", readOnly = false)
public abstract class JpaGenericDao<T, ID extends Serializable> implements IJpaGenericDao<T, ID> {

	private final Class<T> clazz;

	private final Logger logger;
	protected abstract Logger getLogger();

	private final String idName;
	protected abstract String getIdName();

	@SuppressWarnings("unchecked")
	public JpaGenericDao() {
	   // super(JpaEntityInformationSupport.getMetadata(domainClass, null), null, null); 
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		this.logger = getLogger();
		this.idName = getIdName();

	}


	
	@Override
	public T saveEntity(T entity) {
		return null;
	}

	@Override
	public List<T> saveAll(List<T> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> updateAll(Collection<T> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(List<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(ID entityId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByIds(List<ID> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByIds(List<ID> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
