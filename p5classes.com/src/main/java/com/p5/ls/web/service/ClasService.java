package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IClasDao1;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Clas;

@Service("clasService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class ClasService implements IClasService {
	
	@Autowired
	private IClasDao1 clasDao1;

	@Override
	public Clas save(Clas clas) throws ServiceException {
		return clasDao1.save(clas);
	}

	@Override
	public List<Clas> saveAll(List<Clas> clases) throws ServiceException {
		return clasDao1.saveAll(clases);
	}

	@Override
	public void persist(Clas clas) throws ServiceException {
		clasDao1.save(clas);
	}

	@Override
	public Clas update(Clas clas) throws ServiceException {
		return clasDao1.save(clas);
		// return clasDao1.getOne(clas.getClasId());
	}

	@Override
	public Collection<Clas> updateAll(Collection<Clas> clases) throws ServiceException {
		Set<Long> clasIds = new HashSet<>();
		clases.forEach(e -> clasIds.add(e.getClasId()));
		return clasDao1.findAllById(clasIds);
	}

	@Override
	public void delete(Clas clas) throws ServiceException {
		clasDao1.delete(clas);
	}

	@Override
	public void deleteAll(List<Clas> clases) throws ServiceException {
		clasDao1.deleteAll(clases);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		clasDao1.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> clasDao1.deleteById(id));
	}

	@Override
	public Clas findById(Long id) throws ServiceException {
		Optional<Clas> clas = clasDao1.findById(id);
		return clas.get();
	}

	@Override
	public List<Clas> findAll() throws ServiceException {
		return clasDao1.findAll();
	}

	@Override
	public List<Clas> findByIds(List<Long> ids) throws ServiceException {
		return clasDao1.findAllById(ids);
	}

}
