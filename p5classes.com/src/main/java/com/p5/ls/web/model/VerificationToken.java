package com.p5.ls.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VERIFICATION_TOKEN")
public class VerificationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TOKEN_ID")
	private Long tokenId;

	@Column(name = "TOKEN", nullable = false, unique = true, length = 100)
	private String token;

	@Column(name = "CREATED_AT")
	private Date createdAt;

	@Column(name = "EXPIRED_AT")
	private Date expiredAt;

	@Column(name = "VERIFIED_AT")
	private Date verifiedAt;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;

	public VerificationToken() {
		super();
	}

	public VerificationToken(String token, Date createdAt, Date expiredAt, User user) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiredAt = expiredAt;
		this.user = user;
	}

	public Long getTokenId() {
		return tokenId;
	}

	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(Date expiredAt) {
		this.expiredAt = expiredAt;
	}

	public Date getVerifiedAt() {
		return verifiedAt;
	}

	public void setVerifiedAt(Date verifiedAt) {
		this.verifiedAt = verifiedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
