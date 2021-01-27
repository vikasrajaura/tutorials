package com.p5.ls.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

@Entity
@Table(name = "PERSISTENT_LOGINS")
public class PersistentLogin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String series;

	@Column(name = "USERNAME", unique = true, nullable = false)
	private String userName;

	@Column(name = "TOKEN", unique = true, nullable = false)
	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	private Date last_used;

	public PersistentLogin() {
		   
	}

	public PersistentLogin(String series, String userName, String token, Date last_used) {
		super();
		this.series = series;
		this.userName = userName;
		this.token = token;
		this.last_used = last_used;
	}

	public PersistentLogin(PersistentRememberMeToken token) {
		this(token.getSeries(), token.getUsername(), token.getTokenValue(), token.getDate());
	}

	public PersistentRememberMeToken getPersistentRememberMeToken() {
		PersistentRememberMeToken rememberMeToken = new PersistentRememberMeToken(this.getUserName(),
				this.getSeries(), this.getToken(), this.getLast_used());
		return rememberMeToken;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(Date last_used) {
		this.last_used = last_used;
	}

}
