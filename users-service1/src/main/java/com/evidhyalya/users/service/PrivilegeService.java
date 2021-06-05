package com.evidhyalya.users.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evidhyalya.users.dao.IPrivilegeDao;
import com.evidhyalya.users.model.Privilege;

@Service("privilegeService")
//@Transactional(value = "jpaTxMgr", readOnly = false)
public class PrivilegeService implements IPrivilegeService {
	
	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	public Privilege save(Privilege privilege){
		return privilegeDao.save(privilege);
	}

	@Override
	public List<Privilege> saveAll(List<Privilege> privileges){
		return privilegeDao.saveAll(privileges);
	}

	@Override
	public Privilege persist(Privilege privilege){
		return privilegeDao.save(privilege);
	}

	@Override
	public Privilege update(Privilege privilege){
		return privilegeDao.save(privilege);
		// return privilegeDao.getOne(privilege.getPrivilegeId());
	}

	@Override
	public Collection<Privilege> updateAll(Collection<Privilege> privileges){
		Set<Long> privilegeIds = new HashSet<>();
		privileges.forEach(e -> privilegeIds.add(e.getPrivId()));
		return privilegeDao.findAllById(privilegeIds);
	}

	@Override
	public void delete(Privilege privilege){
		privilegeDao.delete(privilege);
	}

	@Override
	public void deleteAll(List<Privilege> privileges){
		privilegeDao.deleteAll(privileges);
	}

	@Override
	public void deleteById(Long id){
		privilegeDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids){
		ids.forEach(id -> privilegeDao.deleteById(id));
	}

	@Override
	public Optional<Privilege> findById(Long id){
		return privilegeDao.findById(id);
	}

	@Override
	public List<Privilege> findAll(){
		return privilegeDao.findAll();
	}

	@Override
	public List<Privilege> findByIds(List<Long> ids){
		return privilegeDao.findAllById(ids);
	}

}
