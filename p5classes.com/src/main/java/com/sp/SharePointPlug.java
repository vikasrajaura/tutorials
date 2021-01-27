package com.sp;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.mortbay.util.ajax.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SharePointPlug {

	public Object getConfiguration(String key) {
		String url = "https://kronos.sharepoint.com/teams/WFC-DocStore/";
		String clientId = "541a7034-cf88-4582-96f6-a98ce3591c9f";
		String clientSecret = "cB05LX3Cp7ukg1tJTDENIK3v0++HCclZtnzxvwEUW78=";
		if (CLIENT_ID.equals(key)) {
			return clientId;
		}
		if (CLIENT_SECRET_KEY.equals(key)) {
			return clientSecret;
		}
		if (AUTHENTICATION_URL.equals(key)) {
			return url;
		}
		else return "";
	}

	/* Request Types */
	private static final String HTTP_GET="GET";
	private static final String HTTP_POST="POST";
	private static final String HTTP_DELETE="DELETE";
	

	// vendor configurations
	private static final String VENDOR_NAME = "SharePoint";
	private static final String AUTHENTICATION_URL = "AuthenticationUrl";
	private static final String CLIENT_ID = "ClientID";
	private static final String CLIENT_SECRET_KEY = "ClientSecret";

	private static final Long HALF_HOUR_IN_SECONDS = 30*60L;
	
	/* considering token will expire 30 minutes before actual expiration
	 * formula is : tokenExpireInSeconds = actualExpireInSeconds - HALF_HOUR_IN_SECONDS*/
	private static Long tokenExpireInSeconds=0L;
	private static OAuthToken savedOAuthToken  = null;

	private static SharePointPlug sharePointPlugin = new SharePointPlug();
	public static SharePointPlug getInstance(){
		return sharePointPlugin;
	}

	private SharePointPlug(){
		
	}
	
	/**
	 * This method will return vendor name as 'SharePoint'
	 */
	
	public String getVendorName(){
		System.out.println(String.format("%s VendorName is : %s", "getVendorName()", VENDOR_NAME));
		return VENDOR_NAME;
	}
	
	/**
	 * This method return the set of configuration keys
	 */
	
	public Set<String> getConfigurationKeys() {
		System.out.println(String.format("%s Getting configuration keys of SharePointPlug", "getConfigurationKeys()"));
		Set<String> configurationKeys = new HashSet<>();
		configurationKeys.add(AUTHENTICATION_URL);
		configurationKeys.add(CLIENT_ID);
		configurationKeys.add(CLIENT_SECRET_KEY);
		return configurationKeys;
	}
	
	/**
	 * This method return true if byte[] of file is successfully saved at
	 * provided path in SharePoint else return false
	 * 
	 * @param bFile binay file
	 * @param path
	 * @param fileName
	 * @return 
	 */
	public boolean saveDocument(byte[] bFile, String path, String fileName) {
		final String METHOD_NAME = "saveDocument()";
		
		// prepare folder structure before upload file
		if(StringUtils.isNotEmpty(path)) {
			//path = path.replace("\\", "/");
			path = SharePointUtil.trimChar(path, "/");
			prepareFolderStructure(path);
		}

		System.out.println(String.format("%s: Saving document %s at path %s ", METHOD_NAME, fileName, path));
		String uploadUrl = SharePointUtil.prepareUrlForUploadFile(getOAuthTokenWithDetails().getDomain(), getOAuthTokenWithDetails().getSiteUrlPath(), path, fileName);
		System.out.println(String.format("%s: uploadUrl:%s", METHOD_NAME, uploadUrl));
		
		int statusCode = 0;
		try {
			HttpURLConnection httpConn = SharePointUtil.getConnection(HTTP_POST, uploadUrl, getOAuthToken());
			DataOutputStream wr = new DataOutputStream(httpConn.getOutputStream());
			wr.write(bFile);
			wr.flush();
			wr.close();
			statusCode = httpConn.getResponseCode();
			System.out.println(String.format("%s: statusCode:%s", METHOD_NAME, statusCode));
		} catch (IOException e) {
			System.out.println(String.format("%s:Error occured: %s", METHOD_NAME, e.getMessage()));
		}
		return statusCode == HttpStatus.SC_OK;
	}
     
	/**
	 * This method return true if file is successfully deleted
	 * from the provided path in SharePoint else return false
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 */
	public boolean deleteDocument(String path, String fileName) {
		final String METHOD_NAME = "deleteDocument()";
		
		if(StringUtils.isNotEmpty(path)) {
			path = SharePointUtil.trimChar(path, "/");
		}

		System.out.println(String.format("%s Deleting document %s from path %s ", METHOD_NAME, fileName, path));
		String urlStrig = SharePointUtil.prepareUrlForDeleteFile(getOAuthTokenWithDetails().getDomain(), getOAuthTokenWithDetails().getSiteUrlPath(), path, fileName);
		System.out.println(String.format("%s: urlStrig is:%s)", METHOD_NAME, urlStrig));
		
		boolean isDeleted=false;
		int statusCode = 0;
		try {
			HttpURLConnection httpConn = SharePointUtil.getConnection(HTTP_DELETE, urlStrig, getOAuthToken());
			statusCode = httpConn.getResponseCode();
			isDeleted = statusCode == HttpStatus.SC_OK;
			System.out.println(String.format("%s: statusCode:%s, isDeleted:%s", METHOD_NAME, statusCode, isDeleted));
		} catch (IOException e) {
			System.out.println(String.format("%s:Error Occured %s", METHOD_NAME, e.getMessage()));
		}
		return isDeleted;
	}

	/**
	 * This method will return byte[] of file if file exists
	 * at the provided path on SharePoint else return null
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 */
	public byte[] getDocumentContent(String path, String fileName) {
		final String METHOD_NAME = "getDocumentContent()";

		if(StringUtils.isNotEmpty(path)) {
			path = SharePointUtil.trimChar(path, "/");
		}

		System.out.println(String.format("%s: params path:%s, fileName:%s", METHOD_NAME, path, fileName));
		String urlStrig = SharePointUtil.prepareUrlForDownloadFile(getOAuthTokenWithDetails().getDomain(), getOAuthTokenWithDetails().getSiteUrlPath(), path, fileName);
		System.out.println(String.format("%s: urlStrig:%s)", METHOD_NAME, urlStrig));
		
		int statusCode = 0;
		try {
			HttpURLConnection httpConn = SharePointUtil.getConnection(HTTP_GET, urlStrig, getOAuthToken());
			statusCode = httpConn.getResponseCode();
			System.out.println(String.format("%s: statusCode:%s", METHOD_NAME, statusCode));
			
			// Read the response
			InputStreamReader isr = null;
			if(statusCode == HttpStatus.SC_OK){
				isr = new InputStreamReader(httpConn.getInputStream());
				return IOUtils.toByteArray(isr);
			} else {
				isr = new InputStreamReader(httpConn.getErrorStream());
				System.out.println(String.format("%s:Error occured in downloading file %s, urlStrig: %s", METHOD_NAME, IOUtils.toByteArray(isr), urlStrig));
			}
		} catch (IOException e) {
			System.out.println(String.format("%s:Error Occured %s", METHOD_NAME, e.getMessage()));
		}
		return StringUtils.EMPTY.getBytes();
	}

	
	/**
	 * This method will return list of fileNames at provided path
	 * 
	 * @param filePath
	 * @return List<String> the list of fileNames
	 */
	
	public List<String> listDocuments(String filePath) {
		final String METHOD_NAME = "listDocuments()";

		if(StringUtils.isNotEmpty(filePath)) {
			filePath = SharePointUtil.trimChar(filePath, "/");
		}

		System.out.println(String.format("%s getting document list at path %s ", "listDocuments()", filePath));
		String urlStrig = SharePointUtil.prepareUrlForListFiles(getOAuthTokenWithDetails().getDomain(), getOAuthTokenWithDetails().getSiteUrlPath(), filePath);
		System.out.println(String.format("%s: urlStrig:%s)", METHOD_NAME, urlStrig));
		
		int statusCode = 0;
		List<String> files = new ArrayList();
		try {
			HttpURLConnection httpConn = SharePointUtil.getConnection(HTTP_GET, urlStrig, getOAuthToken());
			statusCode = httpConn.getResponseCode();
			System.out.println(String.format("%s: statusCode: %s", METHOD_NAME, statusCode));

			InputStreamReader isr =null;
			if(statusCode == HttpStatus.SC_OK){
				isr = new InputStreamReader(httpConn.getInputStream());
				JsonObject jsonObject =(new JsonParser()).parse(isr).getAsJsonObject();
				JsonArray jsonArray = jsonObject.getAsJsonObject("d").getAsJsonArray("results");
				Iterator<JsonElement> iterator = jsonArray.iterator();				 
				while(iterator.hasNext()){
					 JsonObject ob = iterator.next().getAsJsonObject();
					 files.add(ob.get("Name").getAsString());
				 }
			} else {
				isr = new InputStreamReader(httpConn.getErrorStream());
				System.out.println(String.format("%s:ErrorOccured: %s", METHOD_NAME, IOUtils.toString(isr)));
			}
			return files;
		} catch (Exception e) {
			System.out.println(String.format("%s:Error Occured: %s", METHOD_NAME, e.getMessage()));
		}
		return Collections.emptyList();
	}
	
	/**
	 * This method returns true if file exists at provided path else return
	 * false
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	
	public boolean isDocumentExists(String filePath, String fileName) {
		final String METHOD_NAME = "isDocumentExists()";
		System.out.println(String.format("%s checking document %s exists or not at path %s ", METHOD_NAME, fileName, filePath));
		boolean isFileExists = false;
		List<String> filesListOnPath = listDocuments(filePath);
		isFileExists = filesListOnPath.contains(fileName);
		System.out.println(String.format("%s: FilePath: %s/%s,  isFileExists: %s)", METHOD_NAME, filePath, fileName, isFileExists));
		return isFileExists;
	}

	/**
	 * This method validates the configuration
	 */
	
	public void validateConfiguration()  {
		System.out.println(String.format("%s validating configuration ", "validateConfiguration()"));
	}

	/**
	 * This method will always create new OAuth token either expired or not
	 */
	
	public boolean refreshOAuthToken() {
		return createOAuthToken();
	}

	/**
	 * This method will always create new OAuth token
	 */
	
	public boolean createOAuthToken() {
			savedOAuthToken = generateNewToken();
			System.out.println(String.format("%s generated OAuthToken: %s", "createOAuthToken()", savedOAuthToken));
			tokenExpireInSeconds = savedOAuthToken.getExpiresInSeconds()-HALF_HOUR_IN_SECONDS;
			//saveOAuthToken(savedOAuthToken.toString(), null);
		return true;
	}

	/**
	 * This method will invalidate token
	 */
	
	public boolean invalidateOAuthToken() {
		tokenExpireInSeconds = 0L;
		savedOAuthToken = null;
		//saveOAuthToken(null, null);
		return true;
	}

	/**
	 * This method validates token,
	 *  if token is valid(not expired) return true else return false
	 */
	
	public boolean isOAuthTokenValid() {
		boolean isValid = false;
		Long nowInSeconds = (new Date()).getTime();;
		if(savedOAuthToken!=null) {
			Long tokenCreatedOnSeconds = savedOAuthToken.getCreatedOn().getTime();
			isValid = nowInSeconds < (tokenCreatedOnSeconds+tokenExpireInSeconds) ? true : false;
		}
		return isValid;
	}

	/**
	 * This method will return the OAuth token with all details
	 * If the token is expired then generate new and return new token
	 * @return OAuth token string
	 */
	
	public String getOAuthToken() {
		if(!isOAuthTokenValid()){
			createOAuthToken();
		}
		return savedOAuthToken.getToken();
	}
	
	/**
	 * This method will return oauth token string only
	 * If the token is expired then generate new and return new token
	 * 
	 * @return OAuth token string
	 */
	public OAuthToken getOAuthTokenWithDetails() {
		if(!isOAuthTokenValid()){
			createOAuthToken();
		}
		return savedOAuthToken;
	}
	
	/**
	 * This method get tenant info, then prepare JWTToken, then generate OAuthToken
	 * call only when token is invalid/expired
	 * 
	 * @return OAuthToken
	 */
	private OAuthToken generateNewToken() {
		final String METHOD_NAME = "generateNewToken()";
		OAuthToken token = null;
		try {
		String spUrl = String.valueOf(getConfiguration(AUTHENTICATION_URL));
		String spDomain="";
		String siteUrlPath="";
		
		if(StringUtils.isNotEmpty(spUrl)) {
			String temp = StringUtils.stripStart(spUrl, "https://");
			temp = StringUtils.stripEnd(temp, "/");
			int firstFWSlashIndex  = temp.indexOf("/");
			spDomain = temp.substring(0, firstFWSlashIndex);
			siteUrlPath = temp.substring(firstFWSlashIndex+1);
		}
		String clientId = String.valueOf(getConfiguration(CLIENT_ID));
		String clientSecret = String.valueOf(getConfiguration(CLIENT_SECRET_KEY));
		System.out.println(String.format("%s spUrl: %s, clientId: %s, clientSecret: %s", METHOD_NAME, spUrl, clientId, clientSecret));

		Map<String, String> tenantInfo = getTenantInfo(spDomain);
		System.out.println(String.format("%s tenantInfo: %s", METHOD_NAME, tenantInfo));
		if(tenantInfo.size()==0){
			System.out.println(String.format("%s Error occured: %s", METHOD_NAME, "Unable to get tenantId"));
		}
		JWTToken jwtToken = SharePointUtil.prepareJWTToken(tenantInfo, spDomain, siteUrlPath, clientId, clientSecret);
		
		token = generateOAuthToken(jwtToken);

		} catch (IOException e) {
			System.out.println(String.format("%s error occured: %s", METHOD_NAME, e.getLocalizedMessage()));
		}
		return token;
	}
	
	/**
	 * This method will get the tenant info
	 * 
	 * @param domain
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	private Map<String, String> getTenantInfo(String domain) {
		final String METHOD_NAME = "getTenantInfo()";
		System.out.println(String.format("%s: Getting tenant info for domain:%s", METHOD_NAME, domain));
		Map<String, String> tenantInfoResponse = Collections.emptyMap();

		// Send a post request to the OAuth URL.
		HttpGet tenantInfoGet = new HttpGet(SharePointUtil.getUrlForTenantInfo(domain));
		tenantInfoGet.setHeader(SharePointUtil.HEADER_AUTHORIZATION);
		try {
			HttpResponse response = HttpClientBuilder.create().build().execute(tenantInfoGet);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
				String header = response.getFirstHeader(SharePointUtil.WWW_AUTHENTICATE).getValue();
				if (StringUtils.isNotEmpty(header)) {
					header = StringUtils.remove(header, SharePointUtil.HEADER_AUTHORIZATION_VALUE).trim();
				}

				List<String> wwwAuthenticate = Arrays.asList(header.split(","));
				tenantInfoResponse = wwwAuthenticate.stream()
						.filter(e -> e.contains("realm") || e.contains("client_id")).map(str -> str.split("="))
						.collect(Collectors.toMap(x -> x[0], x -> SharePointUtil.trimChar(x[1], "\"")));
			}
		} catch (IOException e) {
			System.out.println(String.format("%s error occured: %s", METHOD_NAME, e.getLocalizedMessage()));
		}
		return tenantInfoResponse;
	}
	
	/**
	 * This method will generate OAuth token
	 * 
	 * @param jwtToken
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public OAuthToken generateOAuthToken(JWTToken jwtToken) throws IOException {
		final String METHOD_NAME = "generateOAuthToken()";
		System.out.println(String.format("%s: jwtToken:%s", METHOD_NAME, jwtToken));
		HttpPost oauthPost = SharePointUtil.createOAuthPost(jwtToken);
		HttpResponse response = HttpClientBuilder.create().build().execute(oauthPost);

		// Execute the request.
		int statusCode = response.getStatusLine().getStatusCode();
		OAuthToken oAuthToken = null;
		if (statusCode == HttpStatus.SC_OK) {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> oauthLoginResponse = mapper.readValue(EntityUtils.toString(response.getEntity()), Map.class);	
			
			oauthLoginResponse.put("domain", jwtToken.getDomain());
			oauthLoginResponse.put("siteUrlPath", jwtToken.getSiteUrlPath());
			oAuthToken = OAuthToken.get(oauthLoginResponse);
		}
		System.out.println(String.format("%s: OAuthToken :%s", METHOD_NAME, oAuthToken));
		return oAuthToken;
	}
	

	/**
	 * This method will create directory structure if already not created else
	 * it will not impact
	 * 
	 * @param path
	 */
	private void prepareFolderStructure(String path) {
		String[] pathStructureArray = path.split("/");
		String tempPath = "";
		for(String folderName: pathStructureArray) {
			if(!isFolderExistsOnPath(tempPath, folderName)){
				createFolder(tempPath, folderName);
			}
			tempPath=String.format("%s/%s", tempPath,folderName);
		}
	}

	/**
	 * This method returns true if folder on the path already exists 
	 * else return false
	 * 
	 * @param path
	 * @param folderName
	 * @return
	 */
	private boolean isFolderExistsOnPath(String path, String folderName) {
		final String METHOD_NAME = "isFolderExistsOnPath()";
		boolean isFolderExists = false;
		List<String> foldersListOnPath =  listFolders(path);
		isFolderExists = foldersListOnPath.contains(folderName);
		System.out.println(String.format("%s: path: %s, folderName: %s,  isFolderExists: %s", METHOD_NAME, path, folderName, isFolderExists));
		return isFolderExists;
	}
	
	/**
	 * This method return the list of folders on the provided path
	 * 
	 * @param path
	 * @return List<String> the list of folders
	 */
	private List<String> listFolders(String path) {
		final String METHOD_NAME = "listFolders()";
		System.out.println(String.format("%s: params path:%s", METHOD_NAME, path));
		String urlStrig = SharePointUtil.prepareUrlForListFolders(getOAuthTokenWithDetails().getDomain(), getOAuthTokenWithDetails().getSiteUrlPath(), path);
		System.out.println(String.format("%s: urlStrig: %s)", METHOD_NAME, urlStrig));
		
		int statusCode = 0;
		List<String> folders = new ArrayList();
		try {
			HttpURLConnection httpConn = SharePointUtil.getConnection(HTTP_GET, urlStrig, getOAuthToken());
			statusCode = httpConn.getResponseCode();
			System.out.println(String.format("%s: statusCode is:%s", METHOD_NAME, statusCode));

			InputStreamReader isr =null;
			if(statusCode == HttpStatus.SC_OK){
				isr = new InputStreamReader(httpConn.getInputStream());
				JsonObject jsonObject =(new JsonParser()).parse(isr).getAsJsonObject();
				JsonArray jsonArray = jsonObject.getAsJsonObject("d").getAsJsonArray("results");
				Iterator<JsonElement> iterator = jsonArray.iterator();
				while(iterator.hasNext()){
					 JsonObject resultsItem = iterator.next().getAsJsonObject();
					 JsonObject metaData = resultsItem.getAsJsonObject("__metadata");
					 if("SP.Folder".equalsIgnoreCase(metaData.get("type").getAsString())) {
						 folders.add(resultsItem.get("Name").getAsString());						 
					 }
				 }
			} else {
				isr = new InputStreamReader(httpConn.getErrorStream());
				System.out.println(String.format("%s:Error Occured: %s", METHOD_NAME, IOUtils.toString(isr)));
			}
			return folders;
		} catch (Exception e) {
			System.out.println(String.format("%s:Error Occured while getting folder list: %s", METHOD_NAME, e.getMessage()));
		}
		return Collections.emptyList();
	}

	/**
	 * This method will create folder on the provided path and return true
	 * 
	 * @param path
	 * @param folderName
	 * @return
	 */
	private boolean createFolder(String path, String folderName) {
		final String METHOD_NAME = "createFolder()";
		System.out.println(String.format("%s: creating folder:%s  on path:%s", METHOD_NAME, folderName, path));
		
		path = SharePointUtil.trimChar(path, "/");
		folderName = SharePointUtil.trimChar(folderName, "/");
		String createFolderUrl = SharePointUtil.prepareUrlForCreateFolder(getOAuthTokenWithDetails().getDomain(), getOAuthTokenWithDetails().getSiteUrlPath());
		System.out.println(String.format("%s: createFolderUrl:%s", METHOD_NAME, createFolderUrl));		

		int statusCode = 0;
		try {
			HttpURLConnection httpConn = SharePointUtil.getConnection(HTTP_POST, createFolderUrl, getOAuthToken());
			
			JsonObject jsonOb = SharePointUtil.prepareJsonToCreateFolder(path, folderName);
			try(OutputStream os = httpConn.getOutputStream()) {
			    byte[] input = jsonOb.toString().getBytes("utf-8");
			    os.write(input, 0, input.length);
			}
			
			statusCode = httpConn.getResponseCode();
			System.out.println(String.format("%s: statusCode: %s", METHOD_NAME, statusCode));

		} catch (IOException e) {
			System.out.println(String.format("%s:ErrorOccured: %s", METHOD_NAME, e.getMessage()));
		}
		return statusCode == HttpStatus.SC_CREATED;
	}

	public static void main(String args[]) {
		String domain = "https://kronos.sharepoint.com/teams/WFC-DocStore";
		
		//String domain = "kronos.sharepoint.com";
		String clientId = "541a7034-cf88-4582-96f6-a98ce3591c9f";
		String clientSecret = "cB05LX3Cp7ukg1tJTDENIK3v0++HCclZtnzxvwEUW78=";

		String path ="tt\\uv";// "-1/151/1/8ec88a07-8940-4a99-ac9a-37a0e203c7c5";
		Long MIN = 0L;
		Long b = 0L;
		if(b<MIN) {
			System.out.println("Excep");
		}
		/*
		SharePointPlug spp = getInstance();
		//spp.createOAuthToken();
		System.out.println("====================================================================================");
		System.out.println(spp.getOAuthToken());


		
		
		
		
		
			// get tenant info
			//Map<String, String> tenantInfo = spp.getTenantInfo(domain);
			
			// test prepare jwt token and get auth token
			  //JWTToken jwtToken = SharePointUtil.prepareJWTToken(tenantInfo, domain, clientId, clientSecret);
			  //OAuthToken oAuthToken = spp.generateOAuthToken(jwtToken);

			//String urlToGetDocumentsList = SharePointUtil.prepareUrlForListDocs(domain, path);
			//instance.getDocumentsList(urlToGetDocumentsList, oAuthTokenDetails.getToken());
			
			String fileContent = "tesint fsakjjfks vikas1";
			String fileName = "Virfile47.txt";

			// test upload file
			boolean b = spp.saveDocument(fileContent.getBytes(), path, fileName);
			
			//test list files
			List<String> filesList = spp.listDocuments(path);
			System.out.println(filesList);

			//test list folders
			//List<String> foldersList = spp.getFoldersListOnPath(path, oAuthToken);
			//System.out.println(foldersList);
			
			// test downloadFile
			//FileOutputStream fos = new FileOutputStream(new File("C:\\TempFileServer\\"+fileName));
			//fos.write(spp.getDocumentContent(path, fileName));
			
			// test delete file
			//boolean isDeleted = spp.deleteDocument(path, fileName);
			//System.out.println("isDeleted: "+isDeleted);
			
*/
	}

}
