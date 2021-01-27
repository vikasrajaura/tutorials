package com.sp;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public static void main(String[] ar) {
		String spUrl = "kronos.com";
		String spDomain = "";
		String siteUrlPath = "";

		if (StringUtils.isNotEmpty(spUrl)) {
			String temp = StringUtils.stripStart(spUrl, "https://");
			temp = StringUtils.stripEnd(temp, "/");
			int firstFWSlashIndex = temp.indexOf("/");

			spDomain = firstFWSlashIndex < 1 ? temp : temp.substring(0, firstFWSlashIndex);
			siteUrlPath = firstFWSlashIndex < 1 ? "" : temp.substring(firstFWSlashIndex + 1);
		}
	}
}
