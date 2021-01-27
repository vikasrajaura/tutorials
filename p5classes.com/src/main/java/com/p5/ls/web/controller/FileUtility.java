package com.p5.ls.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtility {

	public static void uploadFile(File file, String path, String fileName) throws IOException {
		createDirIfNotExists(path);
		FileCopyUtils.copy(file, new File(path +File.pathSeparator+ fileName));
	}

	public static void createDirIfNotExists(String path) {
		// create dir if not
		File nullFilePath = null;
		File createDirPath = new File(nullFilePath, path);
		createDirPath.mkdirs();
	}

	public static void uploadFile(MultipartFile file, String path, String fileName) throws IOException {
		createDirIfNotExists(path);
		FileCopyUtils.copy(file.getBytes(), new File(path +"/"+ fileName));
	}

	
}
