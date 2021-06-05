package com.evidhyalya.users.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evidhyalya.users.dao.IRoleDao;
import com.evidhyalya.users.dao.IUserDao;
import com.evidhyalya.users.exception.ServiceException;
import com.evidhyalya.users.model.Role;
import com.evidhyalya.users.model.UserDetails;

@Service("userService")
//@Transactional(value = "jpaTxMgr", readOnly = false)
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails save(UserDetails user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}

	@Override
	public List<UserDetails> saveAll(List<UserDetails> users) {
		return userDao.saveAll(users);
	}

	@Override
	public UserDetails persist(UserDetails user) {
		return userDao.save(user);
	}

	@Override
	public UserDetails update(UserDetails user) {
		userDao.update(user.getFirstName(), user.getMiddleName(), user.getLastName(),
				user.getEmail(), user.getGender(), user.getDob(), user.getUserId());
		return user;
	}

	@Override
	public Collection<UserDetails> updateAll(Collection<UserDetails> users) {
		users.forEach(e -> userDao.update(e.getFirstName(), e.getMiddleName(), e.getLastName(), e.getEmail(),
				e.getGender(), e.getDob(), e.getUserId()));
		Set<Long> userIds = new HashSet<>();
		users.forEach(e -> userIds.add(e.getUserId()));
		return userDao.findAllById(userIds);
	}

	@Override
	public void delete(UserDetails e) {
		userDao.delete(e);
	}

	@Override
	public void deleteAll(List<UserDetails> users) {
		userDao.deleteAll(users);
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		ids.forEach(id -> userDao.deleteById(id));
	}

	@Override
	public Optional<UserDetails> findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public List<UserDetails> findAll() {
		return userDao.findAll();
	}

	@Override
	public UserDetails findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public int updateLastLogin(Timestamp lastLogin, Long userId) {
		return userDao.updateLastLogin(lastLogin, userId);
	}

	@Override
	public List<UserDetails> findByIds(List<Long> ids) {
		return userDao.findAllById(ids);
	}

	@Override
	public UserDetails saveUserWithRoles(UserDetails user, List<Long> roleIds) {
		Set<Role> roles = null;
		//try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			roles = new HashSet<Role>(roleDao.findAllById(roleIds));
			user.setRoles(roles);
			userDao.save(user);
		/*} catch (DAOException e) {
			LOGGER.error("Exception Occured:" + User.class.getCanonicalName() + ": " + e.getMessage());
			throw new ServiceException(20, e.getErMsg(), e.getErDetails());
		}*/
		return user;
	}
	
	public List<UserDetails> findByOrgId(Long orgId) {
		return userDao.findByOrg(orgId);
	}
	
	public List<UserDetails> findByBranchId(Long branchId) {
		return userDao.findByBranch(branchId);
	}

    public int changePassword(String newPassword, Long userId) {
    	return userDao.changePassword(newPassword, userId);
    }

    public int enableOrDisableUser(boolean isEnabled, Long userId) {
    	return userDao.enableOrDisableUser(isEnabled, userId);
    }

}
