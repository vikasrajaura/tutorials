package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.ISectionDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Section;

@Service("sectionService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class SectionService implements ISectionService {
	
	@Autowired
	private ISectionDao sectionDao;

	@Override
	public Section save(Section section) throws ServiceException {
		return sectionDao.save(section);
	}

	@Override
	public List<Section> saveAll(List<Section> sections) throws ServiceException {
		return sectionDao.saveAll(sections);
	}

	@Override
	public void persist(Section section) throws ServiceException {
		sectionDao.save(section);
	}

	@Override
	public Section update(Section section) throws ServiceException {
		return sectionDao.save(section);
		// return sectionDao.getOne(section.getSectionId());
	}

	@Override
	public Collection<Section> updateAll(Collection<Section> sections) throws ServiceException {
		Set<Long> sectionIds = new HashSet<>();
		sections.forEach(e -> sectionIds.add(e.getSectionId()));
		return sectionDao.findAllById(sectionIds);
	}

	@Override
	public void delete(Section section) throws ServiceException {
		sectionDao.delete(section);
	}

	@Override
	public void deleteAll(List<Section> sections) throws ServiceException {
		sectionDao.deleteAll(sections);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		sectionDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> sectionDao.deleteById(id));
	}

	@Override
	public Section findById(Long id) throws ServiceException {
		Optional<Section> section = sectionDao.findById(id);
		return section.get();
	}

	@Override
	public List<Section> findAll() throws ServiceException {
		return sectionDao.findAll();
	}

	@Override
	public List<Section> findByIds(List<Long> ids) throws ServiceException {
		return sectionDao.findAllById(ids);
	}

}
