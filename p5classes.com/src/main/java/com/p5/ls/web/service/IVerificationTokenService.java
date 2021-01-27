package com.p5.ls.web.service;

import com.p5.ls.web.model.User;
import com.p5.ls.web.model.VerificationToken;

public interface IVerificationTokenService extends IJpaGenericService<VerificationToken, Long> {
	public VerificationToken findByToken(String token);

	public String createTokenForUser(User user);
}
