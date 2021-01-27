package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IPrivilegeDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Privilege;

@Service("privilegeService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class PrivilegeService implements IPrivilegeService {
	
	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	public Privilege save(Privilege privilege) throws ServiceException {
		return privilegeDao.save(privilege);
	}

	@Override
	public List<Privilege> saveAll(List<Privilege> privileges) throws ServiceException {
		return privilegeDao.saveAll(privileges);
	}

	@Override
	public void persist(Privilege privilege) throws ServiceException {
		privilegeDao.save(privilege);
	}

	@Override
	public Privilege update(Privilege privilege) throws ServiceException {
		return privilegeDao.save(privilege);
		// return privilegeDao.getOne(privilege.getPrivilegeId());
	}

	@Override
	public Collection<Privilege> updateAll(Collection<Privilege> privileges) throws ServiceException {
		Set<Long> privilegeIds = new HashSet<>();
		privileges.forEach(e -> privilegeIds.add(e.getPrivId()));
		return privilegeDao.findAllById(privilegeIds);
	}

	@Override
	public void delete(Privilege privilege) throws ServiceException {
		privilegeDao.delete(privilege);
	}

	@Override
	public void deleteAll(List<Privilege> privileges) throws ServiceException {
		privilegeDao.deleteAll(privileges);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		privilegeDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> privilegeDao.deleteById(id));
	}

	@Override
	public Privilege findById(Long id) throws ServiceException {
		Optional<Privilege> privilege = privilegeDao.findById(id);
		return privilege.get();
	}

	@Override
	public List<Privilege> findAll() throws ServiceException {
		return privilegeDao.findAll();
	}

	@Override
	public List<Privilege> findByIds(List<Long> ids) throws ServiceException {
		return privilegeDao.findAllById(ids);
	}

}
