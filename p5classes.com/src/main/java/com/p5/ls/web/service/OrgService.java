package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IOrgDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Org;

@Service("orgService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class OrgService implements IOrgService {
	
	@Autowired
	private IOrgDao orgDao;

	@Override
	public Org save(Org org) throws ServiceException {
		return orgDao.save(org);
	}

	@Override
	public List<Org> saveAll(List<Org> orgs) throws ServiceException {
		return orgDao.saveAll(orgs);
	}

	@Override
	public void persist(Org org) throws ServiceException {
		orgDao.save(org);
	}

	@Override
	public Org update(Org org) throws ServiceException {
		return orgDao.save(org);
	}

	@Override
	public Collection<Org> updateAll(Collection<Org> orgs) throws ServiceException {
		Set<Long> orgIds = new HashSet<>();
		orgs.forEach(e -> orgIds.add(e.getOrgId()));
		return orgDao.findAllById(orgIds);
	}

	@Override
	public void delete(Org org) throws ServiceException {
		orgDao.delete(org);
	}

	@Override
	public void deleteAll(List<Org> orgs) throws ServiceException {
		orgDao.deleteAll(orgs);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		orgDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> orgDao.deleteById(id));
	}

	@Override
	public Org findById(Long id) throws ServiceException {
		Optional<Org> org = orgDao.findById(id);
		return org.get();
	}

	@Override
	public List<Org> findAll() throws ServiceException {
		return orgDao.findAll();
	}

	@Override
	public List<Org> findByIds(List<Long> ids) throws ServiceException {
		return orgDao.findAllById(ids);
	}

}
