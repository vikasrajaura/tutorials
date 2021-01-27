package com.p5.ls.web.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.p5.ls.web.exception.ServiceException;
import com.p5.ls.web.model.User;

public interface IUserService extends IJpaGenericService<User, Long> {

	User findByUserName(String userName);
	
	int updateLastLogin(Timestamp lastLogin, Long userId);

	User saveUserWithRoles(User user, List<Long> roleIds) throws ServiceException;
	
	List<User> findByOrgId(Long orgId) throws ServiceException;
	
	List<User> findByBranchId(Long branchId) throws ServiceException;
	
    int changePassword(String newPassword, Long userId);
    
    int enableOrDisableUser(boolean isEnabled, Long userId);


}
