/*******************************************************************************
 * Copyright 2020. Kronos Incorporated. All rights reserved.
 ******************************************************************************/
package com.sp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SharePointUtil {

	/* JWT Token keys */
	private static final String KEY_GRANT_TYPE = "grant_type";
	private static final String KEY_CLIENT_ID = "client_id";
	private static final String KEY_CLIENT_SECRET = "client_secret";
	private static final String KEY_RESOURCE = "resource";
	private static final String VALUE_GRANT_TYPE = "client_credentials";

	private static final String KEY_REALM = "realm";
	
	/*Custom folder property for share point */
	private static final Header HEADER_CONTENT_TYPE_FORM_URL_ENCODED = new BasicHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
	
	private static final String SHARED_DOCUMENTS = String.format("Shared%sDocuments", "%20");
	
	public static final String HEADER_AUTHORIZATION_VALUE = "Bearer";
	public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
	public static final Header HEADER_AUTHORIZATION = new BasicHeader(HttpHeaders.AUTHORIZATION, HEADER_AUTHORIZATION_VALUE);
	public static final Header HEADER_ACCEPT_VERBOSE = new BasicHeader(HttpHeaders.ACCEPT,	"application/json;odata=verbose");
	public static final Header HEADER_CONTENT_TYPE_VERBOSE = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json;odata=verbose");

	private SharePointUtil() {

	}

	public static String getUrlForTenantInfo(String sharePointDomain) {
		return String.format("https://%s/sharepoint.com/_vti_bin/client.svc/", sharePointDomain);
	}

	public static String prepareUrlForListFiles(String sharePointDomain, String siteUrlPath, String path) {
		return prepareUrlForFile(sharePointDomain, siteUrlPath, path);
	}

	public static String prepareUrlForUploadFile(String sharePointDomain, String siteUrlPath, String path, String fileName) {
		String s = prepareUrlForFile(sharePointDomain, siteUrlPath, path);
		return String.format("%s/add(url='%s',overwrite=true)", s, fileName);
	}

	private static String prepareUrlForFile(String sharePointDomain, String siteUrlPath, String path) {
		String sharePointDocStoreUrl = prepareUrlForSharePoint(sharePointDomain, siteUrlPath);
		return String.format("%s/_api/web/GetFolderByServerRelativeUrl('%s/%s')/Files", sharePointDocStoreUrl,
				SHARED_DOCUMENTS, path);
	}

	public static String prepareUrlForDownloadFile(String sharePointDomain, String siteUrlPath, String path, String fileName) {
		String sharePointDocStoreUrl = prepareUrlForSharePoint(sharePointDomain, siteUrlPath);
		return String.format("%s/_api/Web/GetFileByServerRelativePath(decodedurl='/%s/%s/%s/%s')/$value",
				sharePointDocStoreUrl, siteUrlPath, SHARED_DOCUMENTS, path, fileName);
	}

	public static String prepareUrlForDeleteFile(String sharePointDomain, String siteUrlPath, String path, String fileName) {
		String sharePointDocStoreUrl = prepareUrlForSharePoint(sharePointDomain, siteUrlPath);
		return String.format("%s/_api/Web/GetFileByServerRelativePath(decodedurl='/%s/%s/%s/%s')/",
				sharePointDocStoreUrl, siteUrlPath, SHARED_DOCUMENTS, path, fileName);
	}

	public static String prepareUrlForCreateFolder(String sharePointDomain, String siteUrlPath) {
		String sharePointDocStoreUrl = prepareUrlForSharePoint(sharePointDomain, siteUrlPath);
		return String.format("%s/_api/Web/Folders", sharePointDocStoreUrl);
	}

	public static String prepareUrlForListFolders(String sharePointDomain, String siteUrlPath, String path) {
		String sharePointDocStoreUrl = prepareUrlForSharePoint(sharePointDomain, siteUrlPath);
		if (StringUtils.isEmpty(path)) {
			return String.format("%s/_api/Web/GetFolderByServerRelativePath(decodedurl='/%s/%s')/Folders",
					sharePointDocStoreUrl, siteUrlPath, SHARED_DOCUMENTS);
		} else {
			return String.format("%s/_api/Web/GetFolderByServerRelativePath(decodedurl='/%s/%s/%s')/Folders",
					sharePointDocStoreUrl, siteUrlPath, SHARED_DOCUMENTS, path);
		}
	}

	public static String getUrlForOAuth(String tenantId) {
		return String.format("https://accounts.accesscontrol.windows.net/%s/tokens/OAuth/2", tenantId);
	}

	private static String prepareUrlForSharePoint(String sharePointDomain, String siteUrlPath) {
		return String.format("https://%s/%s", sharePointDomain, siteUrlPath);
	}

	/* body of post rest request */
	public static List<BasicNameValuePair> getAuthRequestBody(JWTToken jwtToken) {
		List<BasicNameValuePair> parametersBody = new ArrayList<>();
		parametersBody.add(new BasicNameValuePair(KEY_GRANT_TYPE, VALUE_GRANT_TYPE));
		parametersBody.add(new BasicNameValuePair(KEY_CLIENT_ID,
				String.format("%s@%s", jwtToken.getClientId(), jwtToken.getTenantId())));
		parametersBody.add(new BasicNameValuePair(KEY_CLIENT_SECRET, jwtToken.getClientSecret()));
		parametersBody.add(new BasicNameValuePair(KEY_RESOURCE,
				String.format("%s/%s@%s", jwtToken.getResourceId(), jwtToken.getDomain(), jwtToken.getTenantId())));
		return parametersBody;
	}

	public static JWTToken prepareJWTToken(Map<String, String> tenantInfo, String sharePointDomain, String siteUrlPath, String clientId,
			String clientSecret) {
		JWTToken jwtToken = new JWTToken();
		jwtToken.setTenantId(tenantInfo.get(KEY_REALM));
		jwtToken.setResourceId(tenantInfo.get(KEY_CLIENT_ID));
		jwtToken.setClientId(clientId);
		jwtToken.setClientSecret(clientSecret);
		jwtToken.setDomain(sharePointDomain);
		jwtToken.setSiteUrlPath(siteUrlPath);
		return jwtToken;
	}

	public static String trimChar(String s, String charToRemove) {
		s = StringUtils.stripStart(s, charToRemove);
		s = StringUtils.stripEnd(s, charToRemove);
		return s;
	}

	public static HttpURLConnection getConnection(String methodType, String urlString, String token)
			throws IOException {
		Header[] headers = { HEADER_ACCEPT_VERBOSE, HEADER_CONTENT_TYPE_VERBOSE,
				new BasicHeader(HttpHeaders.AUTHORIZATION, String.format("%s %s", HEADER_AUTHORIZATION_VALUE, token)) };

		URL url = new URL(urlString);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		httpConn.setRequestMethod(methodType);
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		for (Header h : headers) {
			httpConn.setRequestProperty(h.getName(), h.getValue());
		}
		return httpConn;
	}

	public static HttpPost createOAuthPost(JWTToken jwtToken) {
		// oAuthUrl
		String oAuthurl = SharePointUtil.getUrlForOAuth(jwtToken.getTenantId());

		HttpPost oauthPost = new HttpPost(oAuthurl);
		oauthPost.setHeader(HEADER_CONTENT_TYPE_FORM_URL_ENCODED);

		// prepare body
		List<BasicNameValuePair> parametersBody = getAuthRequestBody(jwtToken);
		oauthPost.setEntity(new UrlEncodedFormEntity(parametersBody, StandardCharsets.UTF_8));
		return oauthPost;
	}

	public static JsonObject prepareJsonToCreateFolder(String path, String folderName) {
		String jsonString = "{\"__metadata\":{ \"type\": \"SP.Folder\" }}";
		JsonObject createFolderJson = (new JsonParser()).parse(jsonString).getAsJsonObject();
		if (StringUtils.isEmpty(path)) {
			createFolderJson.addProperty("ServerRelativeUrl",
					String.format("/teams/WFC-DocStore/%s/%s", SHARED_DOCUMENTS, folderName));
		} else {
			createFolderJson.addProperty("ServerRelativeUrl",
					String.format("/teams/WFC-DocStore/%s/%s/%s", SHARED_DOCUMENTS, path, folderName));
		}
		return createFolderJson;
	}
	

}
