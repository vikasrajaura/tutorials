package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IAreaDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Area;

@Service("areaService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class AreaService implements IAreaService {
	
	@Autowired
	private IAreaDao areaDao;

	@Override
	public Area save(Area area) throws ServiceException {
		return areaDao.save(area);
	}

	@Override
	public List<Area> saveAll(List<Area> areas) throws ServiceException {
		return areaDao.saveAll(areas);
	}

	@Override
	public void persist(Area area) throws ServiceException {
		areaDao.save(area);
	}

	@Override
	public Area update(Area area) throws ServiceException {
		return areaDao.save(area);
		// return areaDao.getOne(area.getAreaId());
	}

	@Override
	public Collection<Area> updateAll(Collection<Area> areas) throws ServiceException {
		Set<Long> areaIds = new HashSet<>();
		areas.forEach(e -> areaIds.add(e.getAreaId()));
		return areaDao.findAllById(areaIds);
	}

	@Override
	public void delete(Area area) throws ServiceException {
		areaDao.delete(area);
	}

	@Override
	public void deleteAll(List<Area> areas) throws ServiceException {
		areaDao.deleteAll(areas);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		areaDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> areaDao.deleteById(id));
	}

	@Override
	public Area findById(Long id) throws ServiceException {
		Optional<Area> area = areaDao.findById(id);
		return area.get();
	}

	@Override
	public List<Area> findAll() throws ServiceException {
		return areaDao.findAll();
	}

	@Override
	public List<Area> findByIds(List<Long> ids) throws ServiceException {
		return areaDao.findAllById(ids);
	}

}
