package com.p5.ls.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p5.ls.web.model.VerificationToken;

@Repository("verificationTokenDao")
public interface IVerificationTokenDao extends JpaRepository<VerificationToken, Long> {
	VerificationToken findByToken(String token);
}
