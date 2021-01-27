/*******************************************************************************
 * Copyright 2020. Kronos Incorporated. All rights reserved.
 ******************************************************************************/
package com.sp;

import java.util.Date;
import java.util.Map;
public class OAuthToken {

	private String domain;
	private String siteUrlPath;
	private String token;
	private String resource;
	private String tokenType;
	private Date createdOn;
	private Date expiresOn;
	private Long expiresInSeconds;

	public OAuthToken(String domain, String siteUrlPath, String token, String resource, String tokenType, Date createdOn,
			Date expiresOn, Long expiresInSeconds) {
		super();
		this.domain = domain;
		this.siteUrlPath = siteUrlPath;
		this.token = token;
		this.resource = resource;
		this.tokenType = tokenType;
		this.createdOn = createdOn;
		this.expiresOn = expiresOn;
		this.expiresInSeconds = expiresInSeconds;
	}

	@Override
	public String toString() {
		return "{domain=" + domain + ",siteUrlPath=" + siteUrlPath + ",access_token=" + token + ",resource=" + resource + ",token_type=" + tokenType
				+ ",not_before=" + createdOn + ",expires_on=" + expiresOn + ",expires_in=" + expiresInSeconds + "}";
	}

	public static OAuthToken get(Map<String, String> oauthTokenMap) {
		String token = oauthTokenMap.get("access_token");
		String resource = oauthTokenMap.get("resource");
		Long createdOn = Long.valueOf(oauthTokenMap.get("not_before"));
		Long expiresOn = Long.valueOf(oauthTokenMap.get("expires_on"));
		String tokenType = oauthTokenMap.get("token_type");
		Long expiresInSeconds = Long.valueOf(oauthTokenMap.get("expires_in"));
		return new OAuthToken(oauthTokenMap.get("domain"), oauthTokenMap.get("siteUrlPath"), token, resource, tokenType,
				new Date(1000 * createdOn), new Date(1000 * expiresOn),	expiresInSeconds);
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSiteUrlPath() {
		return siteUrlPath;
	}

	public void setSiteUrlPath(String siteUrlPath) {
		this.siteUrlPath = siteUrlPath;
	}

	public String getToken() {
		return token;
	}

	public String getResource() {
		return resource;
	}

	public String getTokenType() {
		return tokenType;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getExpiresOn() {
		return expiresOn;
	}

	public Long getExpiresInSeconds() {
		return expiresInSeconds;
	}

}
