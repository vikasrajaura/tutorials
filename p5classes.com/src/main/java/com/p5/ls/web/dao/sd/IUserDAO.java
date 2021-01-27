package com.p5.ls.web.dao.sd;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.p5.ls.web.model.User;

public interface IUserDAO extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	
	@Query(value="SELECT user FROM users user WHERE pl.userId = :userId"  , nativeQuery = true  )
	User findByUserId(@Param("userId") Long userId);
	
	@Modifying
    @Query("UPDATE User u SET u.lastLogin = :lastLogin WHERE u.userId = :userId")
    int updateLastLogin(@Param("lastLogin") Timestamp lastLogin, @Param("userId") Long userId);
	
}