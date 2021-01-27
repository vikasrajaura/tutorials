package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IRoleDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Role;

@Service("roleService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public Role save(Role role) throws ServiceException {
		return roleDao.save(role);
	}

	@Override
	public List<Role> saveAll(List<Role> roles) throws ServiceException {
		return roleDao.saveAll(roles);
	}

	@Override
	public void persist(Role role) throws ServiceException {
		roleDao.save(role);
	}

	@Override
	public Role update(Role role) throws ServiceException {
		return roleDao.save(role);
		// return roleDao.getOne(role.getRoleId());
	}

	@Override
	public Collection<Role> updateAll(Collection<Role> roles) throws ServiceException {
		Set<Long> roleIds = new HashSet<>();
		roles.forEach(e -> roleIds.add(e.getRoleId()));
		return roleDao.findAllById(roleIds);
	}

	@Override
	public void delete(Role role) throws ServiceException {
		roleDao.delete(role);
	}

	@Override
	public void deleteAll(List<Role> roles) throws ServiceException {
		roleDao.deleteAll(roles);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		roleDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> roleDao.deleteById(id));
	}

	@Override
	public Role findById(Long id) throws ServiceException {
		Optional<Role> role = roleDao.findById(id);
		return role.get();
	}

	@Override
	public List<Role> findAll() throws ServiceException {
		return roleDao.findAll();
	}

	@Override
	public List<Role> findByIds(List<Long> ids) throws ServiceException {
		return roleDao.findAllById(ids);
	}

}
