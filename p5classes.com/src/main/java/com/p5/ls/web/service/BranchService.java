package com.p5.ls.web.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IBranchDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Branch;

@Service("branchService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class BranchService implements IBranchService {
	
	@Autowired
	private IBranchDao branchDao;

	@Override
	public Branch save(Branch branch) throws ServiceException {
		return branchDao.save(branch);
	}

	@Override
	public List<Branch> saveAll(List<Branch> branches) throws ServiceException {
		return branchDao.saveAll(branches);
	}

	@Override
	public void persist(Branch branch) throws ServiceException {
		branchDao.save(branch);
	}

	@Override
	public Branch update(Branch branch) throws ServiceException {
		return branchDao.save(branch);
		// return branchDao.getOne(branch.getBranchId());
	}

	@Override
	public Collection<Branch> updateAll(Collection<Branch> branches) throws ServiceException {
		Set<Long> branchIds = new HashSet<>();
		branches.forEach(e -> branchIds.add(e.getBranchId()));
		return branchDao.findAllById(branchIds);
	}

	@Override
	public void delete(Branch branch) throws ServiceException {
		branchDao.delete(branch);
	}

	@Override
	public void deleteAll(List<Branch> branches) throws ServiceException {
		branchDao.deleteAll(branches);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		branchDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> branchDao.deleteById(id));
	}

	@Override
	public Branch findById(Long id) throws ServiceException {
		Optional<Branch> branch = branchDao.findById(id);
		return branch.get();
	}

	@Override
	public List<Branch> findAll() throws ServiceException {
		return branchDao.findAll();
	}

	@Override
	public List<Branch> findByIds(List<Long> ids) throws ServiceException {
		return branchDao.findAllById(ids);
	}

}
