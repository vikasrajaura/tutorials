package com.p5.ls.web.service;

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

import com.p5.ls.web.dao.IRoleDao;
import com.p5.ls.web.dao.IUserDao;
import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.Role;
import com.p5.ls.web.model.User;

@Service("userService")
@Transactional(value = "jpaTxMgr", readOnly = false)
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User save(User user) throws ServiceException {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}

	@Override
	public List<User> saveAll(List<User> users) throws ServiceException {
		return userDao.saveAll(users);
	}

	@Override
	public void persist(User user) throws ServiceException {
		userDao.save(user);
	}

	@Override
	public User update(User user) throws ServiceException {
		userDao.update(user.getFirstName(), user.getMiddleName(), user.getLastName(),
				user.getEmail(), user.getGender(), user.getDob(), user.getUserId());
		return user;
	}

	@Override
	public Collection<User> updateAll(Collection<User> users) throws ServiceException {
		users.forEach(e -> userDao.update(e.getFirstName(), e.getMiddleName(), e.getLastName(), e.getEmail(),
				e.getGender(), e.getDob(), e.getUserId()));
		Set<Long> userIds = new HashSet<>();
		users.forEach(e -> userIds.add(e.getUserId()));
		return userDao.findAllById(userIds);
	}

	@Override
	public void delete(User e) throws ServiceException {
		userDao.delete(e);
	}

	@Override
	public void deleteAll(List<User> users) throws ServiceException {
		userDao.deleteAll(users);
	}

	@Override
	public void deleteById(Long id) throws ServiceException {
		userDao.deleteById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) throws ServiceException {
		ids.forEach(id -> userDao.deleteById(id));
	}

	@Override
	public User findById(Long id) throws ServiceException {
		Optional<User> user = userDao.findById(id);
		return user.get();
	}

	@Override
	public List<User> findAll() throws ServiceException {
		return userDao.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public int updateLastLogin(Timestamp lastLogin, Long userId) {
		return userDao.updateLastLogin(lastLogin, userId);
	}

	@Override
	public List<User> findByIds(List<Long> ids) throws ServiceException {
		return userDao.findAllById(ids);
	}

	@Override
	public User saveUserWithRoles(User user, List<Long> roleIds) throws ServiceException {
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
	
	public List<User> findByOrgId(Long orgId) throws ServiceException {
		return userDao.findByOrg(orgId);
	}
	
	public List<User> findByBranchId(Long branchId) throws ServiceException {
		return userDao.findByBranch(branchId);
	}

    public int changePassword(String newPassword, Long userId) {
    	return userDao.changePassword(newPassword, userId);
    }

    public int enableOrDisableUser(boolean isEnabled, Long userId) {
    	return userDao.enableOrDisableUser(isEnabled, userId);
    }

}
