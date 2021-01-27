/*******************************************************************************
 * Copyright 2020. Kronos Incorporated. All rights reserved.
 ******************************************************************************/
package com.sp;

public class JWTToken {

	private String tenantId;
	private String resourceId;
	private String clientId;
	private String clientSecret;
	private String domain;
	private String siteUrlPath;

	@Override
	public String toString() {
		return "JWTToken [tenantId=" + tenantId + ", resourceId=" + resourceId + ", clientId=" + clientId
				+ ", clientSecret=" + clientSecret + ", domain=" + domain + ", siteUrlPath=" + siteUrlPath+"]";
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

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}
