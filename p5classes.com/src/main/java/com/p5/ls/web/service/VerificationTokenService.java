package com.p5.ls.web.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p5.ls.web.dao.IVerificationTokenDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.User;
import com.p5.ls.web.model.VerificationToken;

@Service("verificationTokenService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class VerificationTokenService implements IVerificationTokenService {
	
	@Autowired
	private IVerificationTokenDao verificationTokenDao;

	@Override
	public VerificationToken save(VerificationToken verificationToken) throws ServiceException {
		return verificationTokenDao.save(verificationToken);
	}

	@Override
	public List<VerificationToken> saveAll(List<VerificationToken> verificationTokens) throws ServiceException {
		return verificationTokenDao.saveAll(verificationTokens);
	}

	@Override
	public void persist(VerificationToken verificationToken) throws ServiceException {
		verificationTokenDao.save(verificationToken);
	}

	@Override
	public VerificationToken update(VerificationToken verificationToken) throws ServiceException {
		return verificationTokenDao.save(verificationToken);
	}

	@Override
	public Collection<VerificationToken> updateAll(Collection<VerificationToken> verificationTokens) throws ServiceException {
		Set<Long> verificationTokenIds = new HashSet<>();
		verificationTokens.forEach(e -> verificationTokenIds.add(e.getTokenId()));
		return verificationTokenDao.findAllById(verificationTokenIds);
	}

	@Override
	public void delete(VerificationToken verificationToken) throws ServiceException {
		verificationTokenDao.delete(verificationToken);
	}

	@Override
	public void deleteAll(List<VerificationToken> verificationTokens) throws ServiceException {
		verificationTokenDao.deleteAll(verificationTokens);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		verificationTokenDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> verificationTokenDao.deleteById(id));
	}

	@Override
	public VerificationToken findById(Long id) throws ServiceException {
		Optional<VerificationToken> verificationToken = verificationTokenDao.findById(id);
		return verificationToken.get();
	}

	@Override
	public List<VerificationToken> findAll() throws ServiceException {
		return verificationTokenDao.findAll();
	}

	@Override
	public List<VerificationToken> findByIds(List<Long> ids) throws ServiceException {
		return verificationTokenDao.findAllById(ids);
	}

	@Override
	public VerificationToken findByToken(String token){
		return verificationTokenDao.findByToken(token);
	}

	@Override
	public String createTokenForUser(User user) {
		final String token = UUID.randomUUID().toString();
		verificationTokenDao.save(new VerificationToken(token, new Date(), new Date(), user));
		return token;
	}

	
}
