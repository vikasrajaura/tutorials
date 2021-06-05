package com.evidhyalya.users.service;

import java.sql.Timestamp;
import java.util.List;

import com.evidhyalya.users.exception.ServiceException;
import com.evidhyalya.users.model.UserDetails;

public interface IUserService extends IJpaGenericService<UserDetails, Long> {

	UserDetails findByUserName(String userName);
	
	int updateLastLogin(Timestamp lastLogin, Long userId);

	UserDetails saveUserWithRoles(UserDetails user, List<Long> roleIds) throws ServiceException;
	
	List<UserDetails> findByOrgId(Long orgId) throws ServiceException;
	
	List<UserDetails> findByBranchId(Long branchId) throws ServiceException;
	
    int changePassword(String newPassword, Long userId);
    
    int enableOrDisableUser(boolean isEnabled, Long userId);


}
