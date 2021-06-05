package com.evidhyalya.users.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evidhyalya.users.dao.IOrgDao;
import com.evidhyalya.users.exception.ServiceException;
import com.evidhyalya.users.model.Org;

@Service("orgService")
//@Transactional(value = "jpaTxMgr", readOnly = false)
public class OrgService implements IOrgService {
	
	@Autowired
	private IOrgDao orgDao;

	@Override
	public Org save(Org org){
		return orgDao.save(org);
	}

	@Override
	public List<Org> saveAll(List<Org> orgs){
		return orgDao.saveAll(orgs);
	}

	@Override
	public Org persist(Org org){
		return orgDao.save(org);
	}

	@Override
	public Org update(Org org){
		return orgDao.save(org);
	}

	@Override
	public Collection<Org> updateAll(Collection<Org> orgs){
		Set<Long> orgIds = new HashSet<>();
		orgs.forEach(e -> orgIds.add(e.getOrgId()));
		return orgDao.findAllById(orgIds);
	}

	@Override
	public void delete(Org org){
		orgDao.delete(org);
	}

	@Override
	public void deleteAll(List<Org> orgs){
		orgDao.deleteAll(orgs);
	}

	@Override
	public void deleteById(Long id){
		orgDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids){
		ids.forEach(id -> orgDao.deleteById(id));
	}

	@Override
	public Optional<Org> findById(Long id){
		Optional<Org> org = orgDao.findById(id);
		return org;
	}

	@Override
	public List<Org> findAll(){
		return orgDao.findAll();
	}

	@Override
	public List<Org> findByIds(List<Long> ids){
		return orgDao.findAllById(ids);
	}

}
