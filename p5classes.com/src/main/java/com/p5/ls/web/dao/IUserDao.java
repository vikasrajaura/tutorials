package com.p5.ls.web.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.p5.ls.web.model.User;

@Repository("userDao")
public interface IUserDao extends JpaRepository<User, Long> {

	public static final String UPDATE_USER = "UPDATE User u SET u.firstName = :firstName, u.middleName = :middleName, "
			+ "u.lastName = :lastName, u.email = :email, u.gender = :gender,"
			+ "u.dob = :dob WHERE u.userId = :userId";

	User findByUserName(String userName);
	
	@Query(value = "SELECT * FROM USERS WHERE ORG_ID = :orgId", nativeQuery = true)
	List<User> findByOrg(@Param("orgId") Long orgId);
	
	@Query(value = "SELECT * FROM USERS WHERE BRANCH_ID = :branchId", nativeQuery = true)
	List<User> findByBranch(@Param("branchId") Long branchId);

	//@Query(value = "SELECT user FROM users user WHERE pl.userId = :userId", nativeQuery = true)
	User findByUserId(@Param("userId") Long userId);

	//@Query(value = "SELECT user FROM users user WHERE pl.userId = :userId", nativeQuery = true)
	User findByEmail(@Param("email") String email);

	@Modifying
    @Query("UPDATE User u SET u.lastLogin = :lastLogin WHERE u.userId = :userId")
    int updateLastLogin(@Param("lastLogin") Timestamp lastLogin, @Param("userId") Long userId);

	@Modifying
    @Query(UPDATE_USER)
	public void update(@Param("firstName") String firstName, @Param("middleName") String middleName, 
			@Param("lastName") String lastName, @Param("email") String email, 
			@Param("gender") String gender, @Param("dob") Date dob, @Param("userId") Long userId);

	@Modifying
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.userId = :userId")
    int changePassword(@Param("newPassword") String newPassword, @Param("userId") Long userId);

	@Modifying
    @Query("UPDATE User u SET u.isEnabled = :isEnabled WHERE u.userId = :userId")
    int enableOrDisableUser(@Param("isEnabled") boolean isEnabled, @Param("userId") Long userId);
	
}
