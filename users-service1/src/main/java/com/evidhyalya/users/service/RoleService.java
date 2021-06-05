package com.evidhyalya.users.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evidhyalya.users.dao.IRoleDao;
import com.evidhyalya.users.model.Role;

@Service("roleService")
//@Transactional(value = "jpaTxMgr", readOnly = false)
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public Role save(Role role) {
		return roleDao.save(role);
	}

	@Override
	public List<Role> saveAll(List<Role> roles) {
		return roleDao.saveAll(roles);
	}

	@Override
	public Role persist(Role role) {
		return roleDao.save(role);
	}

	@Override
	public Role update(Role role) {
		return roleDao.save(role);
		// return roleDao.getOne(role.getRoleId());
	}

	@Override
	public Collection<Role> updateAll(Collection<Role> roles) {
		Set<Long> roleIds = new HashSet<>();
		roles.forEach(e -> roleIds.add(e.getRoleId()));
		return roleDao.findAllById(roleIds);
	}

	@Override
	public void delete(Role role) {
		roleDao.delete(role);
	}

	@Override
	public void deleteAll(List<Role> roles) {
		roleDao.deleteAll(roles);
	}

	@Override
	public void deleteById(Long id) {
		roleDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		ids.forEach(id -> roleDao.deleteById(id));
	}

	@Override
	public Optional<Role> findById(Long id) {
		return roleDao.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public List<Role> findByIds(List<Long> ids) {
		return roleDao.findAllById(ids);
	}

}
