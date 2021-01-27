
package com.p5.ls.web.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IJpaGenericDao<T, ID extends Serializable> extends JpaRepository<T, ID> {

	public T saveEntity(T entity);
	List<T> saveAll(List<T> entities);
	public void persist(T entity);

	public T update(T entity);
	public Collection<T> updateAll(Collection<T> entities);

	public void delete(T entity);
	public void deleteAll(List<T> entities);
	public void deleteById(ID entityId);
	public void deleteByIds(List<ID> ids);

	public Optional<T> findById(ID id);
	public List<T> findByIds(List<ID> ids);
	public List<T> findAll();

}
