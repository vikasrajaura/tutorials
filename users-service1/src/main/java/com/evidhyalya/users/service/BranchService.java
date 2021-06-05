package com.evidhyalya.users.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evidhyalya.users.dao.IBranchDao;
import com.evidhyalya.users.exception.ServiceException;
import com.evidhyalya.users.model.Branch;

@Service("branchService")
//@Transactional(value = "jpaTxMgr", readOnly = false)
public class BranchService implements IBranchService {
	
	@Autowired
	private IBranchDao branchDao;

	@Override
	public Branch save(Branch branch) {
		return branchDao.save(branch);
	}

	@Override
	public List<Branch> saveAll(List<Branch> branches) {
		return branchDao.saveAll(branches);
	}

	@Override
	public Branch persist(Branch branch) {
		return branchDao.save(branch);
	}

	@Override
	public Branch update(Branch branch) {
		return branchDao.save(branch);
		// return branchDao.getOne(branch.getBranchId());
	}

	@Override
	public Collection<Branch> updateAll(Collection<Branch> branches) {
		Set<Long> branchIds = new HashSet<>();
		branches.forEach(e -> branchIds.add(e.getBranchId()));
		return branchDao.findAllById(branchIds);
	}

	@Override
	public void delete(Branch branch) {
		branchDao.delete(branch);
	}

	@Override
	public void deleteAll(List<Branch> branches) {
		branchDao.deleteAll(branches);
	}

	@Override
	public void deleteById(Long id) {
		branchDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		ids.forEach(id -> branchDao.deleteById(id));
	}

	@Override
	public Optional<Branch> findById(Long id) {
		return branchDao.findById(id);
	}

	@Override
	public List<Branch> findAll() {
		return branchDao.findAll();
	}

	@Override
	public List<Branch> findByIds(List<Long> ids) {
		return branchDao.findAllById(ids);
	}

}
